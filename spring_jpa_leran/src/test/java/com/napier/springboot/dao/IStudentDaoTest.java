package com.napier.springboot.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.napier.springboot.entity.StudentEntity;

@SpringBootTest

public class IStudentDaoTest {
	
	@Autowired
	private IStudentDao isd;
	
	@Test
	void firstTest() {
		StudentEntity entity = new StudentEntity();
		entity.setEmail("Hii");
		entity.setStudName("po");
		entity.setStudAddress("io");
		isd.save(entity);
	}
	
	@Test
	void hell()
	{
		List<StudentEntity> obj = isd.getAllDataUsingJPQL1("nanu@gmail.com");
		for(StudentEntity item1 : obj)
		  {
			  System.out.println("getAllDataUsingJPQL() method : "+item1.toString());
		  }
	}
}
