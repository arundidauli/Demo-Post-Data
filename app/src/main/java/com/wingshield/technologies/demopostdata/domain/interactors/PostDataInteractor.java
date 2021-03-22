package com.wingshield.technologies.demopostdata.domain.interactors;

import com.wingshield.technologies.demopostdata.model.Post;

import java.util.List;

public interface PostDataInteractor {
    interface Callback{
        void postLoaded(List<Post> postList);
        void onError(String error_message);
    }
}
