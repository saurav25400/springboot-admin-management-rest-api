package com.codingshuttle.production_ready_feature.prod.controllers;

import com.codingshuttle.production_ready_feature.prod.dto.PostDto;
import com.codingshuttle.production_ready_feature.prod.services.PostService;
import com.fasterxml.jackson.databind.JsonNode;
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

    @GetMapping(path="/calling external-api/weather")
    public Object GetAllWeather(){
        return postService.getWeatherData();
    }

    @PostMapping(path = "/data/prompt")
    public JsonNode getGeminiRespone(@RequestBody Object prompt){
        return postService.getGeminiResponse(prompt);

    }



}
