package com.codingshuttle.production_ready_feature.prod;

import com.codingshuttle.production_ready_feature.prod.services.PostService;
import com.codingshuttle.production_ready_feature.prod.services.PostServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdApplicationTests {

	@Autowired
	private PostService postService;

	@Test
	public void getAllData(){
		Object obj=postService.getWeatherData();
		System.out.println(obj);

	}






}
