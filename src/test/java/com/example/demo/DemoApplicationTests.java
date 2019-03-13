package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	
@Autowired
private StudentServiceImpl service;

@MockBean
StudentRepository repository;

@Test
public void getAllStudentsTest() {
	when(repository.findAll()).thenReturn(
			Stream.of(
					new Student(123, "Jam", "BSIT", 3),
					new Student(14, "Jom", "BSEd", 4)
					).collect(Collectors.toList())
			);
	
assertEquals(2, service.getAllStudents().size());	
			
}

@Test
public void insertStudentTest() {
	List<Student> students = new ArrayList<>();
	students.add(new Student(123, "Jam", "BSIT", 3));
	students.add(new Student(14, "Jom", "BSEd", 4));
 
	service.insertStudents(students);
	verify(repository, times(1)).saveAll(students);
	
	}

@Test
public void getStudentByIdTest() {
	Student student = new Student(23, "Jam", "BSCrim", 4 );
	
	when(repository.findById(23)).thenReturn(Optional.of(student));
	
	assertEquals("BSCrim", service.getStudentById(23).get().getCourse());
	
}





}

