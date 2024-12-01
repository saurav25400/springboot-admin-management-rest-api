package com.codingshuttle.production_ready_feature.prod.services;

import com.codingshuttle.production_ready_feature.prod.dto.PostDto;
import com.codingshuttle.production_ready_feature.prod.entities.PostEntity;
import com.codingshuttle.production_ready_feature.prod.exceptions.ResourceNotFoundException;
import com.codingshuttle.production_ready_feature.prod.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;
    private final  ModelMapper mapper;
    @Override
    public List<PostDto> getAllPost() {
        List<PostEntity> postEntity=postRepository.findAll();
        return postEntity.stream().map(post->mapper.map(post,PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto postDto) {
        PostEntity postEntity=mapper.map(postDto,PostEntity.class);
        PostEntity savedPost=postRepository.save(postEntity);
        return mapper.map(savedPost,PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity=postRepository.findById(postId).
                orElseThrow(()->new ResourceNotFoundException("searched post with  id  "+postId+" not found"));
        return mapper.map(postEntity,PostDto.class);
    }
}
