package com.napier.springboot.entity;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.napier.springboot.dao.IStudentDao;


@SpringBootTest
class StudentEntityTest {
	@MockBean
	private IStudentDao isd;

	@Test
	void addStudentsTest()
	{
		StudentEntity se = new StudentEntity(); 
		 se.setStudName("Pravalli");
		  se.setEmail("reddy@gmail.com"); 
		  se.setStudAddress("hyd");
		  isd.save(se);
		  
		  StudentEntity se1 = new StudentEntity(); 
		  se1.setStudName("nanu");
		  se1.setEmail("nanu@gmail.com");
		  se1.setStudAddress("delhi"); 
		  isd.save(se1);
	}
	
	@Test
	void getStudentsTest()
	{
		  List<StudentEntity> it = isd.findAll();
		  for(StudentEntity item : it)
		  {
			  System.out.println("findAll() method :\n"+"Id : "+item.getStudId()+"\nName : "+item.getStudName()+"\nAddress : "+item.getStudAddress()+"\nEmail : "+item.getEmail());
		  }
	}
	
}
