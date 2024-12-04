package com.codingshuttle.production_ready_feature.prod.services;

import com.codingshuttle.production_ready_feature.prod.dto.EmployeeDTO;
import com.codingshuttle.production_ready_feature.prod.dto.PostDto;
import com.codingshuttle.production_ready_feature.prod.entities.PostEntity;
import com.codingshuttle.production_ready_feature.prod.exceptions.ResourceNotFoundException;
import com.codingshuttle.production_ready_feature.prod.repositories.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    @Value("api_key")
    private static  String API_KEY;
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";

    private final PostRepository postRepository;
    private final  ModelMapper mapper;
    private final RestClient restClient;
    private final RestTemplate restTemplate;


    // Logger Instance
    Logger log= LoggerFactory.getLogger(PostServiceImp.class);

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

    @Override
    public Object getWeatherData(){
       try{
           ResponseEntity<JsonNode> response=restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.GET,null, JsonNode.class);

           JsonNode responseBody = response.getBody();
           System.out.println(responseBody +" getting data from api call");
           return responseBody;


       }
       catch(Exception e){
           System.out.println(e);

       }
       return null;

    }


    @Override
    public JsonNode getGeminiResponse(Object prompt) {

        try {
            // Create the request body using a Map for proper JSON serialization
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("query", prompt);
            requestBody.put("temperature", 0.7);


            ObjectMapper objectMapper = new ObjectMapper();


            // Prepare the request body as JSON
//            String requestBody = "{"
//                    + "\"query\": \"" + prompt + "\","
//                    + "\"temperature\": 0.7"
//                    + "}";
            // Convert Map to JsonNode for escaping special characters
            JsonNode jsonRequest = objectMapper.valueToTree(requestBody);


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            // Create headers with API key
            headers.set("Authorization", "Bearer " + API_KEY);
            // Create HttpEntity to hold the request body and headers
            HttpEntity<JsonNode> entity = new HttpEntity<>(jsonRequest, headers);
            // Make the API call using RestTemplate
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(
                    API_URL,
                    HttpMethod.POST,
                    entity,
                    JsonNode.class
            );

            // Return the response body as JsonNode
            return responseEntity.getBody();


        } catch (Exception e) {
            System.out.println(e);
        }
        return null;


    }

    @Override
    public EmployeeDTO getEmployeeById(int employeeId) {
        try{
            log.trace("trying to call getEmployeeById: {}",employeeId);
            EmployeeDTO emp=restClient.get().uri("employee/{employeeId}",employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{

                        throw new ResourceNotFoundException("could not able to find the employeeId");
                    })
                    .body(new ParameterizedTypeReference<EmployeeDTO>(){});
            log.trace("getEmployeeById is being called successfully");
            return emp;

        } catch (Exception e) {
            log.error("getting error after getEmployeeById is being called: ",e);
            System.out.println(e);
        }
        return null;


    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
       try{
           log.trace("started calling getAllEmployee function");
           List<EmployeeDTO> list=restClient.get().uri("get/all/employee")
                   .retrieve()
                   .body(new ParameterizedTypeReference<List<EmployeeDTO>>() {
                   });
           log.trace("called getAllEmployee successfully!!");
           return list;


       }
       catch(Exception e){
           log.error("catch error while calling getAllEmployee function");
           System.out.println(e);
       }
       return null;

    }

    @Override
    public EmployeeDTO postEmployeeData(EmployeeDTO employeeDTO) {
       try{
           log.trace("started calling postEmployeeData");
           EmployeeDTO emp=restClient.post().uri("employee")
                   .body(employeeDTO)
                   .retrieve()
                   .onStatus(HttpStatusCode::is5xxServerError,(req,res)->{
                       log.error(res.getBody().readAllBytes().toString());
                       throw new ResourceNotFoundException("server error occured");
                   })
                   .body(new ParameterizedTypeReference<EmployeeDTO>() {
                   });
           log.trace("postEmployeeData function is getting called successfully!!!");
           return emp;

       }
       catch (Exception e){
           log.error("error occured while calling postEmployeeData",e);
           System.out.println(e);
       }
       return null;
    }


}
