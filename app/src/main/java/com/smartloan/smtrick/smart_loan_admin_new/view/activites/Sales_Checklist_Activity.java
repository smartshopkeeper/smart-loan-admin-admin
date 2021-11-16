package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesChecklistAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.UploadListAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Sales_Received_Lead_Details_Fragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Sales_Checklist_Activity extends AppCompatActivity implements OnCheckedClickListener {

    RecyclerView recycleChecklist, recycleCollectedDocuments;
    SalesChecklistAdapter checkListAdapter;
    UploadListAdapter uploadListAdapter;
    ArrayList<String> checklist;
    LeedsModel leedsModel;
    ImageView AddDoc;
    Button AddChecklist;

    private static final int RESULT_LOAD_IMAGE = 1;

    private List<Uri> fileDoneList;
    ArrayList<String> imageList1;
    static private ArrayList<String> serList;
    LeedRepository leedRepository;

    private StorageReference storageReference;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__checklist_);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        leedRepository = new LeedRepositoryImpl();
        storageReference = FirebaseStorage.getInstance().getReference();

        checklist = new ArrayList<>();
        checklist = leedsModel.getChecklist();
        fileDoneList = new ArrayList<>();
        imageList1 = new ArrayList<>();
        serList = new ArrayList<>();

        AddDoc = (ImageView) findViewById(R.id.add_docsimage);
        AddChecklist = (Button) findViewById(R.id.add_Collected_Checklist);
        recycleChecklist = (RecyclerView) findViewById(R.id.recycler_view_users);
        recycleChecklist.setHasFixedSize(true);
        recycleChecklist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        checkListAdapter = new SalesChecklistAdapter(getApplicationContext(), checklist,(OnCheckedClickListener) Sales_Checklist_Activity.this);
        recycleChecklist.setAdapter(checkListAdapter);


        recycleCollectedDocuments = (RecyclerView) findViewById(R.id.recycler_view_collected);
        recycleCollectedDocuments.setHasFixedSize(true);
        recycleCollectedDocuments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));


        AddDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });
        AddChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });

    }

    public void pickImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), RESULT_LOAD_IMAGE);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {

            if (data.getClipData() != null) {

                int totalItemsSelected = data.getClipData().getItemCount();

                for (int i = 0; i < totalItemsSelected; i++) {

                    Uri fileUri = data.getClipData().getItemAt(i).getUri();
                    fileDoneList.add(data.getClipData().getItemAt(i).getUri());

                    //String fileName = getFileName(fileUri);
                }
                uploadListAdapter = new UploadListAdapter(Sales_Checklist_Activity.this, fileDoneList);
                recycleCollectedDocuments.setLayoutManager(new LinearLayoutManager(Sales_Checklist_Activity.this, LinearLayoutManager.HORIZONTAL, true));
                recycleCollectedDocuments.setHasFixedSize(true);
                recycleCollectedDocuments.setAdapter(uploadListAdapter);

            } else if (data.getData() != null) {

                Uri image = data.getData();
                fileDoneList.add(image);

                uploadListAdapter = new UploadListAdapter(Sales_Checklist_Activity.this, fileDoneList);
                recycleCollectedDocuments.setLayoutManager(new LinearLayoutManager(Sales_Checklist_Activity.this, LinearLayoutManager.HORIZONTAL, true));
                recycleCollectedDocuments.setHasFixedSize(true);
                recycleCollectedDocuments.setAdapter(uploadListAdapter);

            }
        }
    }


    private void uploadFile() {
        //checking if file is available
        if (fileDoneList != null) {
            //displaying progress dialog while image is uploading
            final ProgressDialog progressDialog = new ProgressDialog(Sales_Checklist_Activity.this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();

            for (int i = 0; i < fileDoneList.size(); i++) {

                //getting the storage reference
                final StorageReference sRef = storageReference.child(Constant.STORAGE_PATH_UPLOADS + System.currentTimeMillis() + "." + getFileExtension(fileDoneList.get(i)));

                //adding the file to reference
                sRef.putFile(fileDoneList.get(i))
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                //displaying success toast
                                sRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        String downloadurl = uri.toString();
                                        imageList1.add(downloadurl);

                                        if (imageList1 != null && imageList1.size() != 0) {

                                            if (imageList1.size() == fileDoneList.size()) {

                                                updatLeed(leedsModel);

                                                progressDialog.dismiss();
                                            }
                                        }

                                    }
                                });
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                //displaying the upload progress
                                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                                progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                            }
                        });

            }

        } else {
            //display an error if no file is selected
            Toast.makeText(this, "Please Select a file", Toast.LENGTH_SHORT).show();
        }
    }

    public String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void updatLeed(LeedsModel leedsModel) {
        leedsModel.setChecklistCollected(serList);
        leedsModel.setChecklistCollectedimages(imageList1);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {

        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {

                Toast.makeText(Sales_Checklist_Activity.this, "Documents Added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Sales_Checklist_Activity.this,Sales_View_Lead_Details_Activity.class);
                intent.putExtra(LEED_MODEL, leedsModel);
                startActivity(intent);

            }

            @Override
            public void onError(Object object) {
                Utility.showLongMessage(Sales_Checklist_Activity.this, getString(R.string.server_error));
            }
        });
    }

    @Override
    public void onImageClick(String imageData, boolean isChecked) {
        if (isChecked) {
            serList.add(imageData);

        } else if (!isChecked) {
            int i = serList.indexOf(imageData);
            serList.remove(i);

        }
    }

}
