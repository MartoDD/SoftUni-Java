package com.likebookapp.service;

import com.likebookapp.model.binding.PostUploadModel;
import com.likebookapp.model.binding.ReturnedPosts;
import com.likebookapp.model.entity.Post;

import java.util.Set;

public interface PostService {

    public void addPost(PostUploadModel postUploadModel);

    Set<ReturnedPosts> findAllPostsByUser(Long id);
    Set<ReturnedPosts> findPostsByAllOtherUsers(Long id);

    void removePost(Long id);

    Post getPostById(Long id);

    void likePost(Long id);



}
