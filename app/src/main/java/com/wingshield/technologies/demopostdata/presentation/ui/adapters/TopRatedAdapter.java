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

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.PostViewHolder> {

    private final Context context;
    private final List<Post> postList;

    public TopRatedAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public TopRatedAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.top_rated_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedAdapter.PostViewHolder holder, int position) {

        //holder.bindData(postList.get(position));

        holder.rl_root.setOnClickListener(v -> {
            context.startActivity(new Intent(context, AppointmentActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title, txt_body;
        RelativeLayout rl_root;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_root=itemView.findViewById(R.id.rl_root);
            /*txt_title = itemView.findViewById(R.id.txt_title);
            txt_body = itemView.findViewById(R.id.txt_body);*/
        }


        void bindData(Post post) {
            txt_title.setText(post.getTitle());
            txt_body.setText(post.getBody());
        }
    }
}
