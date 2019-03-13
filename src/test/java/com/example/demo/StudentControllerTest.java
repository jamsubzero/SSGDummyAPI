package com.example.demo;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.StudentController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
//	@InjectMocks
//    StudentController studentController;
//	
	@MockBean
	StudentServiceImpl studentServiceImpl;
	

//@Before	
//	public void setUp() throws Exception{
//		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
//	}


@Test
public void testInsertAStudent() throws Exception {
	
	Student mockStd = new Student(123, "Jam", "BSIT", 3);
	
	String inputInJson = this.mapToJson(mockStd);
	
	String URI = "/enrolment/insertone";
	
    Mockito.when(studentServiceImpl.insertAStudent(Mockito.any(Student.class))).thenReturn(mockStd);
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post(URI)
			.accept(MediaType.APPLICATION_JSON).content(inputInJson)
			.contentType(MediaType.APPLICATION_JSON);

			mockMvc.perform(requestBuilder)
	
	.andExpect(MockMvcResultMatchers.status().isOk())
    .andExpect(MockMvcResultMatchers.content().string(inputInJson));
		
}


@Test
public void testInserAStudentVoid() throws Exception {
	
	Student mockStd = new Student(12300, "Jam", "BSIT", 3);
	
	String inputInJson = this.mapToJson(mockStd);
	
	String URI = "/enrolment/insertonevoid";
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post(URI)
			.accept(MediaType.APPLICATION_JSON).content(inputInJson)
			.contentType(MediaType.APPLICATION_JSON);

	mockMvc.perform(requestBuilder)
	.andExpect(MockMvcResultMatchers.status().isOk())
    .andExpect(MockMvcResultMatchers.content().string("new Student inserted: " + mockStd.getName()));
	
	verify(studentServiceImpl, times(1)).insertAStudentVoid(mockStd);

}  





/**
 * 
 * @param object
 * @return A String in JSON form of the object
 * @throws JsonProcessingException
 */

private String mapToJson(Object object) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(object);
}



	
	
	
	
	

}
