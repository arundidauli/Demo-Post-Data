package com.wingshield.technologies.demopostdata.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.model.Users;
import com.wingshield.technologies.demopostdata.presentation.ui.uiInterface.UserListener;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.PostViewHolder> {

    private final Context context;
    private final List<Users> usersList;
    private UserListener userListener;

    public HistoryAdapter(Context context, List<Users> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    public HistoryAdapter(Context context, List<Users> usersList, UserListener userListener) {
        this.context = context;
        this.usersList = usersList;
        this.userListener = userListener;
    }

    @NonNull
    @Override
    public HistoryAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.history_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.PostViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView txt_name, txt_email,txt_status,txt_gender,txt_delete,txt_edit;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

          /*  txt_delete = itemView.findViewById(R.id.txt_delete);
            txt_edit = itemView.findViewById(R.id.txt_edit);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_email = itemView.findViewById(R.id.txt_email);
            txt_status = itemView.findViewById(R.id.txt_status);
            txt_gender = itemView.findViewById(R.id.txt_gender);
*/


        }





        void bindData(Users post) {
            txt_name.setText(post.getName());
            txt_email.setText(post.getEmail());
            txt_status.setText(post.getStatus());
            txt_gender.setText(post.getGender());
        }
    }
}
