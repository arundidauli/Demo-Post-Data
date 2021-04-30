package com.wingshield.technologies.demopostdata.presentation.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.model.Post;
import com.wingshield.technologies.demopostdata.presentation.ui.activities.impl.AppointmentActivity;

import java.util.List;

public class ProfileRowAdapter extends RecyclerView.Adapter<ProfileRowAdapter.PostViewHolder> {

    private final Context context;
    private final List<Post> postList;

    public ProfileRowAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ProfileRowAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.profile_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRowAdapter.PostViewHolder holder, int position) {

        //holder.bindData(postList.get(position));


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title, txt_body;
       // RelativeLayout rl_root;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
           // rl_root=itemView.findViewById(R.id.rl_root);
            /*txt_title = itemView.findViewById(R.id.txt_title);
            txt_body = itemView.findViewById(R.id.txt_body);*/
        }


        void bindData(Post post) {
            txt_title.setText(post.getTitle());
            txt_body.setText(post.getBody());
        }
    }
}
