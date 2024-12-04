package com.codingshuttle.production_ready_feature.prod;

import com.codingshuttle.production_ready_feature.prod.dto.EmployeeDTO;
import com.codingshuttle.production_ready_feature.prod.services.PostService;
import com.codingshuttle.production_ready_feature.prod.services.PostServiceImp;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdApplicationTests {

	@Autowired
	private PostService postService;

	@Test
	@Order(3)
	public void getAllData(){
		Object obj=postService.getWeatherData();
		System.out.println(obj);

	}
	@Test
	@Order(2)
	public void getEmployeeById(){
		EmployeeDTO emp=postService.getEmployeeById(1);

		System.out.println(emp.toString());
	}

	@Test
	@Order(4)
	public void GetAllEmployee(){
		List<EmployeeDTO> empList=postService.getAllEmployee();
		//System.out.println(empList);
		empList.forEach(emp-> System.out.println(emp.toString()));
	}

	@Test
	@Order(1)
	public void postEmployee(){
		EmployeeDTO emp=EmployeeDTO.builder().name("hitesh").age(26).email("xyz@gmail.com").dateOfJoining(LocalDate.of(2022,2,3))
				.isActive(true).role("USER").salary(Double.valueOf(23000)).build();
		EmployeeDTO employeeDTO=postService.postEmployeeData(emp);
		System.out.println(employeeDTO);
	}






}
