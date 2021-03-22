package com.wingshield.technologies.demopostdata.presentation.presenters;

import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.PostDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.impl.PostDataInteractorImpl;
import com.wingshield.technologies.demopostdata.model.Post;
import com.wingshield.technologies.demopostdata.presentation.ui.activities.PostView;

import java.util.List;

public class PostDataPresenter extends AbstractPresenter implements PostDataInteractor.Callback {

    private final PostView postView;

    public PostDataPresenter(Executor executor, MainThread mainThread, PostView postView) {
        super(executor, mainThread);
        this.postView = postView;
    }

    public void getAllPost(){
        new PostDataInteractorImpl(mExecutor,mMainThread,this).execute();
    }

    @Override
    public void postLoaded(List<Post> postList) {
        if (postList!=null){
            postView.getPost(postList);
        }
    }

    @Override
    public void onError(String error_message) {
        postView.onError(error_message);
    }
}
