package com.codingshuttle.production_ready_feature.prod.controllers;

import com.codingshuttle.production_ready_feature.prod.dto.PostDto;
import com.codingshuttle.production_ready_feature.prod.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    List<PostDto>getAllPost(){
        return postService.getAllPost();
    }

    @PostMapping
    PostDto createNewPost(@RequestBody PostDto postDto){
        return postService.createNewPost(postDto);
    }

    @GetMapping(path = "/{postId}")
    PostDto getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);

    }


}
