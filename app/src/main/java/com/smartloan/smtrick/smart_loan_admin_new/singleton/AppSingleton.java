package com.smartloan.smtrick.smart_loan_admin_new.singleton;

import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.FirebaseDatabase;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_BALANCE_TRANSFER;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_BP;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_HL;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_LAP;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_RE;

public class AppSingleton {
    private static AppSingleton appSingleton;

    public int notificationId = 100;
    NotificationManager mNotifyManager;
    NotificationCompat.Builder mBuilder;
    private static Context context;

    //private constructor.
    private AppSingleton(Context context) {
        initFirebasePersistence();
    }

    private void initFirebasePersistence() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    FirebaseDatabase.getInstance().setPersistenceEnabled(true);
                    FirebaseDatabase.getInstance().goOnline();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static AppSingleton getInstance(Context context) {
        //if there is no instance available... create new one
        context = context;
        if (appSingleton == null) {
            appSingleton = new AppSingleton(context);
        }
        return appSingleton;
    }

//    public String[] getLoanType() {
//        return new String[]{"Select Loan Type", "HL", "LAP"};
//    }
    public String[] getLoanType() {
        return new String[]{"Select Loan Type", LOAN_TYPE_HL, LOAN_TYPE_LAP, LOAN_TYPE_BALANCE_TRANSFER};
    }
    public String[] getHomeLoanType() {
        return new String[]{"Select Home Loan Type", LOAN_TYPE_BP, LOAN_TYPE_RE};
    }

    public String[] getBalanceTransferType() {
        return new String[]{"Select Balance Transfer Type", "Home Loan", "Loan Against Proerty"};
    }
    public String[] getEmployeeType() {
        return new String[]{"Select Occupation", "Salaried", "Businessman"};
    }

    public void setNotificationManager() {
        try {
            mNotifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mBuilder = new NotificationCompat.Builder(context);
            mBuilder.setContentTitle(context.getString(R.string.file_uploading_progress))
                    .setContentText(context.getString(R.string.notification_message))
                    .setSmallIcon(R.drawable.ic_menu_camera)
                    .setOngoing(true);
            mBuilder.setProgress(0, 0, true);
            // Issues the notification
            mNotifyManager.notify(notificationId, mBuilder.build());
        } catch (Exception e) {
            ExceptionUtil.logException(e);
        }
    }

    public void updateProgress(int uploaded, int total, int percent) {
        try {
            if(mNotifyManager!=null&&mBuilder!=null) {
                if (total == uploaded) {
                    mBuilder.setContentText(context.getString(R.string.file_uploading_complited))
                            // Removes the progress bar
                            .setProgress(0, 0, false)
                            .setContentTitle(context.getString(R.string.file_uploading_complited_message) + " " + uploaded + "/" + total)
                            .setOngoing(false);
                    mNotifyManager.notify(0, mBuilder.build());
                    mNotifyManager.cancel(notificationId);
                    mNotifyManager=null;
                    mBuilder=null;
                } else {
                    mBuilder.setProgress(total, uploaded, false);
                    mBuilder.setContentTitle(context.getString(R.string.file_uploading_progress) + " (" + Integer.toString(percent) + "%)" + " " + uploaded + "/" + total);
                    // Issues the notification
                    mNotifyManager.notify(notificationId, mBuilder.build());
                }
            }
        } catch (Exception e) {
            ExceptionUtil.logException(e);
        }
    }
}