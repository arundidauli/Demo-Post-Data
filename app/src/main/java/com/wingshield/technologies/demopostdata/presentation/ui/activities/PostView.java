package com.wingshield.technologies.demopostdata.presentation.ui.activities;

import com.wingshield.technologies.demopostdata.model.Post;

import java.util.List;

public interface PostView {
    void getPost(List<Post> postList);
    void onError(String message);
}
