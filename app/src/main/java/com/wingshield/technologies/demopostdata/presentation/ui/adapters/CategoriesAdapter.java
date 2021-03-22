package com.wingshield.technologies.demopostdata.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.model.Post;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.PostViewHolder> {

    private final Context context;
    private final List<Post> postList;

    public CategoriesAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public CategoriesAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.PostViewHolder holder, int position) {

        //holder.bindData(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title, txt_body;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            /*txt_title = itemView.findViewById(R.id.txt_title);
            txt_body = itemView.findViewById(R.id.txt_body);*/
        }


        void bindData(Post post) {
            txt_title.setText(post.getTitle());
            txt_body.setText(post.getBody());
        }
    }
}
