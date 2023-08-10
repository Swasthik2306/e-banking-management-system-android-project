package ajiet.ise.dept.horizonbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajiet.ise.dept.horizonbank.R;
import ajiet.ise.dept.horizonbank.Transactionsdetails;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Transactionsdetails> list;

    public MyAdapter(Context context, List<Transactionsdetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Transactionsdetails td3 = list.get(position);
        holder.pn.setText(td3.getSenttophno());
        holder.am.setText(td3.getAmount());
        holder.tid.setText(String.valueOf(td3.getTransid()));
        holder.tacid.setText(td3.getAcno00());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView pn, am, tid, tacid;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pn = itemView.findViewById(R.id.tphno);
            am = itemView.findViewById(R.id.tamount);
            tid = itemView.findViewById(R.id.tid);
            tacid = itemView.findViewById(R.id.acid1);
        }
    }
}
