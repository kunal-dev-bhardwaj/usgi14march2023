package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model.TransactionHistoryList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionHistoryListAdapter extends RecyclerView.Adapter<TransactionHistoryListAdapter.MyViewHolder> {
    private List<TransactionHistoryList> transactionhistory;
    private Activity activity;

    public TransactionHistoryListAdapter(Activity act, List<TransactionHistoryList> transactionHistory) {
        this.activity = act;
        this.transactionhistory = transactionHistory;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView perticular, amount, date, closing_balance;

        public MyViewHolder(View view) {
            super(view);
            perticular = view.findViewById(R.id.perticular);
            amount = view.findViewById(R.id.amount);
            date = view.findViewById(R.id.date);
            closing_balance = view.findViewById(R.id.closing_balance);
        }
    }

    @NonNull
    @Override
    public TransactionHistoryListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_transaction_history_item, parent, false);
        return new TransactionHistoryListAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final TransactionHistoryListAdapter.MyViewHolder holder, final int position) {
        holder.perticular.setText(transactionhistory.get(position).getPerticular());
        holder.closing_balance.setText("Closing Balance : " + transactionhistory.get(position).getClosingBalance());

        if (transactionhistory.get(position).getTransactionType().equalsIgnoreCase("Earn")) {
            holder.amount.setText("+ " + transactionhistory.get(position).getAmount());
            holder.amount.setTextColor(activity.getResources().getColor(R.color.pastel_green));
        } else {
            holder.amount.setText("- " + transactionhistory.get(position).getAmount());
            holder.amount.setTextColor(activity.getResources().getColor(R.color.pastel_red));
        }

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String date_format = transactionhistory.get(position).getCreatedOn();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss aa");
        try {
            Date date1 = formatter.parse(date_format);
            holder.date.setText(dateFormat.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return transactionhistory.size();
    }
}
