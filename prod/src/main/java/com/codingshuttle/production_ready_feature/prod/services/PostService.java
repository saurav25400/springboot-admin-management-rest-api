package com.codingshuttle.production_ready_feature.prod.services;

import com.codingshuttle.production_ready_feature.prod.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    List<PostDto> getAllPost();

    PostDto createNewPost(PostDto postDto);

    PostDto getPostById(Long postId);

}
