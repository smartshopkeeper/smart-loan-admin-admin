package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.View_Bank_Customers_Activity;

import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {

    private Context context;
    private List<LeedsModel> list;


    String item;


   public CatalogAdapter(Context context, List<LeedsModel> list){
       this.context = context;
       this.list = list;
   }




   @Override
    public CatalogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cataloglist, parent, false);
        CatalogAdapter.ViewHolder viewHolder = new CatalogAdapter.ViewHolder(v);
      //  context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CatalogAdapter.ViewHolder holder, final int position) {
       //String pname = list.get(position);
        final LeedsModel pveo = list.get(position);

            holder.BankName.setText(pveo.getBanknName());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do on click stuff
                //Toast.makeText(holder.pname.getContext(), list.get(position), Toast.LENGTH_SHORT).show();
                String item = list.get(position).toString();
                Intent intent = new Intent(holder.BankName.getContext(), View_Bank_Customers_Activity.class);
                intent.putExtra("invoice", pveo);
                holder.BankName.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView BankName;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            BankName = (TextView) itemView.findViewById(R.id.catalog_name);

            cardView = (CardView) itemView.findViewById(R.id.card);

        }
    }
}
