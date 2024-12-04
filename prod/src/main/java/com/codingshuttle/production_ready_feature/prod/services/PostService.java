package com.codingshuttle.production_ready_feature.prod.services;

import com.codingshuttle.production_ready_feature.prod.dto.EmployeeDTO;
import com.codingshuttle.production_ready_feature.prod.dto.PostDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    List<PostDto> getAllPost();

    PostDto createNewPost(PostDto postDto);

    PostDto getPostById(Long postId);

    public Object getWeatherData();

    public JsonNode getGeminiResponse(Object prompt);

    public EmployeeDTO getEmployeeById(int id);

    public List<EmployeeDTO>getAllEmployee();

    public EmployeeDTO postEmployeeData(EmployeeDTO employeeDTO);

}
