package com.likebookapp.service.impl;

import com.likebookapp.model.binding.PostUploadModel;
import com.likebookapp.model.binding.ReturnedPosts;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.MoodService;
import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MoodService moodService;
    private final CurrentUser currentUser;

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, MoodService moodService, CurrentUser currentUser, ModelMapper modelMapper, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.moodService = moodService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void addPost(PostUploadModel postUploadModel) {

        Post post = new Post();
        User user = userRepository.findById(currentUser.getId()).orElse(null);
        Mood mood = moodService.findMoodByName(postUploadModel.getMood());

        post.setUser(user);
        post.setContent(postUploadModel.getContent());
        post.setMood(mood);

        this.postRepository.save(post);

    }

    public Set<ReturnedPosts> mapPosts(Set<Post> posts) {

        return posts.stream().map(p -> {

            ReturnedPosts returnedPosts = new ReturnedPosts();

            returnedPosts.setId(p.getId());
            returnedPosts.setMood(p.getMood());
            returnedPosts.setContent(p.getContent());
            returnedPosts.setUserLikes(p.getUserLikes());
            returnedPosts.setUser(p.getUser());
            return returnedPosts;
        }).collect(Collectors.toSet());
    }

    @Override
    public Set<ReturnedPosts> findAllPostsByUser(Long id) {
        return mapPosts(this.postRepository.findAllByUserId(id));
    }

    @Override
    public Set<ReturnedPosts> findPostsByAllOtherUsers(Long id) {
        return mapPosts(this.postRepository.findPostByUserIdNot(id));
    }

    @Override
    @Transactional
    public void removePost(Long id) {
        postRepository.removePostById(id);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.getPostById(id);
    }

    @Override
    public void likePost(Long id) {

        User user = modelMapper.map(currentUser, User.class);
        Post post = getPostById(id);
        post.getUserLikes().add(user);
        postRepository.save(post);

    }


}
