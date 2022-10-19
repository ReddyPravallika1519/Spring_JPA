package com.napier.springboot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.napier.springboot.dao.ICourseDao;
import com.napier.springboot.dao.ICourseMaterial;
import com.napier.springboot.dao.IStudentDao;
import com.napier.springboot.dao.ITeacherDao;
import com.napier.springboot.entity.CourseEntity;
import com.napier.springboot.entity.CourseMaterialEntity;
import com.napier.springboot.entity.StudentEntity;
import com.napier.springboot.entity.TeacherEntity;

@SpringBootApplication
public class SpringJpaLeranApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con =
				SpringApplication.run(SpringJpaLeranApplication.class, args);
		
		  //testing the application 
		
		 //inserting data
	/*	  IStudentDao bean = con.getBean(IStudentDao.class);
		  StudentEntity se = con.getBean(StudentEntity.class); 
		  se.setStudName("Pravalli");
		  se.setEmail("reddy@gmail.com"); 
		  se.setStudAddress("hyd"); bean.save(se);
		  
		  StudentEntity se1 = new StudentEntity(); 
		  se1.setStudName("nanu");
		  se1.setEmail("nanu@gmail.com");
		  se1.setStudAddress("delhi"); bean.save(se1);
		  
		  StudentEntity se2 = new StudentEntity(); 
		  se2.setStudName("yamini");
		  se2.setEmail("yamini@gmail.com");
		  se2.setStudAddress("mysore"); bean.save(se2);
		  
		  StudentEntity se3 = new StudentEntity(); 
		  se3.setStudName("manga");
		  se3.setEmail("manga@gmail.com");
		  se3.setStudAddress("vizag"); bean.save(se3);
		  
		  StudentEntity se4 = new StudentEntity(); 
		  se4.setStudName("sravani");
		  se4.setEmail("sravani@gmail.com");
		  se4.setStudAddress("hyd"); bean.save(se4);
		  
		  StudentEntity se5 = new StudentEntity(); 
		  se5.setStudName("saranya");
		  se5.setEmail("sarru@gmail.com");
		  se5.setStudAddress("delhi"); bean.save(se5);
		  
		  StudentEntity se6 = new StudentEntity(); 
		  se6.setStudName("madhu");
		  se6.setEmail("madhu@gmail.com");
		  se6.setStudAddress("hyd"); bean.save(se6);
		  
		  StudentEntity se7 = new StudentEntity(); 
		  se7.setStudName("vanitha");
		  se7.setEmail("vanni@gmail.com");
		  se7.setStudAddress("chennai"); bean.save(se7);
		  
		  //display data 
		  
		  //1.findAll()
		  List<StudentEntity> it = bean.findAll();
		  for(StudentEntity item : it)
		  {
			  System.out.println("findAll() method :\n"+"Id : "+item.getStudId()+"\nName : "+item.getStudName()+"\nAddress : "+item.getStudAddress()+"\nEmail : "+item.getEmail());
		  }
		  
		  //2.findById()
		  Optional<StudentEntity> obj =bean.findById(2l); //l reprsents long
		  System.out.println("findAllById() method : ");
		  if(obj.isPresent())
		  {
			  System.out.println(obj.get());
		  }
		  else
		  {
			  System.out.println("no record found");
		  }
		  
		  //3.findAllById()
		  ArrayList<Long> ids = new ArrayList<Long>();
		  ids.add(4l);
		  ids.add(7l);
		  ids.add(5l);
		  List<StudentEntity> obj1 = bean.findAllById(ids);
		  for(StudentEntity item1 : obj1)
		  {
			  System.out.println("findAllById() method : "+item1.toString());
		  }
		  
		  //count()
		  System.out.println("No of records : "+bean.count());
		  
		  //deleteAll()
		 // bean.deleteAll();
		  
		  
		  //custom method, return based on name of student
		  Optional<StudentEntity> obj2 = bean.findByStudName("nanu");
		  System.out.println(obj2.get());
		  
		  //custom method, return based on name of student containing the given string
		  List<StudentEntity> obj3 = bean.findByStudNameContaining("ra");
		  System.out.println(obj3);
		  
		  //JPQL queries calling
		  String obj4 = bean.getAllDataUsingJPQL("reddy@gmail.com");
		  System.out.println("name is "+obj4);
		  
		  List<StudentEntity> obj5 = bean.getAllDataUsingJPQL1("reddy@gmail.com");
		  for(StudentEntity item1 : obj5)
		  {
			  System.out.println("getAllDataUsingJPQL() method : "+item1.toString());
		  }
		  
		  //Native Queries calling
		  List<StudentEntity> obj6 = bean.getAllDataUsingNativeQuery("reddy@gmail.com");
		  for(StudentEntity item1 : obj6)
		  {
			  System.out.println("getAllDataUsingNativeQuery() method : "+item1.toString());
		  }
		 
		  //Native named query
		  List<StudentEntity> obj7 = bean.getAllDataUsingNativeNamedQuery("reddy@gmail.com","hy");
		  if(obj7.isEmpty())
		  {
			  System.out.println("no records found");
		  }
		  else
		  {
			  for(StudentEntity item1 : obj7)
			  {
				  System.out.println("getAllDataUsingNativeNamedQuery() method : "+item1.toString());
			  }
		  }
		
		  bean.getAllDataUsingNativeNamedUpdateQuery1("google",4);
		  bean.getAllDataUsingNativeNamedInsertQuery2(12,"abc", "xyz","abc@gmail.com");
		
		
		  //sorting
		  List<StudentEntity> list = bean.findAll(Sort.by(Sort.Direction.ASC,"studName"));
		  System.out.println("Names display using Sort");
		  for(StudentEntity en : list)
		  {
			  System.out.println(en.getStudName());
		  }
		 
		  //pagination and sorting
		  Pageable page = PageRequest.of(0, 5,Sort.by(Sort.Direction.ASC, "studName"));
		  List<StudentEntity> studList = bean.findAll(page).getContent();
		  System.out.println(studList);
		  long totalPages = bean.findAll(page).getTotalPages();
		  long totElements = bean.findAll(page).getTotalElements();
		  long size= bean.findAll(page).getSize();
		  System.out.println("one "+totalPages+" two : "+totElements+" three : "+size);
		  System.out.println("page no is: "+page.getPageNumber()+" page size is: "+page.getPageSize());
		  
		  
		  //entity relationships
		  //one -one mapping
		  ICourseMaterial bean1 = con.getBean(ICourseMaterial.class);
		  
		  CourseEntity ce = new CourseEntity();
		  ce.setCourseName("Java");
		  ce.setCourseCredit(6);
		
		  CourseMaterialEntity cme = new CourseMaterialEntity();
		  cme.setCourseUrl("www.google.com");
		  cme.setCourse(ce);
		  bean1.save(cme);
		/*
		 * List<CourseMaterialEntity> entity = bean1.findAll();
		 * System.out.println(entity);
		 * 
		 * //here while printing CourseMaterial we are getting Course details also, but not vice versa..because we done unimapping
		  //so to acheive viceversa case also, we need bidirectional mapping
		 * ICourseDao bean2 = con.getBean(ICourseDao.class); List<CourseEntity> entity1
		 * = bean2.findAll(); System.out.println(entity1);
		 */
		  
		  
		/*
		  //many-one mapping
		  List<CourseEntity> courseList = new ArrayList<CourseEntity>();
		  ICourseDao bean2 = con.getBean(ICourseDao.class);
		  
		  TeacherEntity teacher = new TeacherEntity();
		  teacher.setTecaherName("XYZ");
		  
		  CourseEntity  java = new CourseEntity();
		  java.setCourseName("java");
		  java.setCourseCredit(6);
		  java.setTeacher(teacher);
		  courseList.add(java);
		
		  
		  CourseEntity  py = new CourseEntity();
		  py.setCourseName("Python");
		  py.setCourseCredit(7);
		  py.setTeacher(teacher);
		  courseList.add(py);
		  
		  bean2.saveAll(courseList); */
		  
		  
		  
		  
		  
		  //one-many mapping
		/*  ITeacherDao bean3 = con.getBean(ITeacherDao.class);
		  
		  CourseEntity  java = new CourseEntity();
		  java.setCourseName("Java");
		  java.setCourseCredit(6);
		  
		  CourseEntity  py = new CourseEntity();
		  py.setCourseName("Python");
		  py.setCourseCredit(6);
		  
		  TeacherEntity te = new TeacherEntity();
		  te.setTecaherName("Abc");
		  te.setCourses(List.of(java, py));
		  bean3.save(te);
		  */
		  
		  //many-many mapping
		
		/*TeacherEntity teaEnt = new TeacherEntity();
		  teaEnt.setTecaherName("onlineteacher");
		 
		  
		  CourseEntity couEnt = new CourseEntity();
		  couEnt.setCourseName("springboot");
		  couEnt.setCourseCredit(10);
		  couEnt.setTeacher(teaEnt);
		  
		  
		  StudentEntity studEnt = new  StudentEntity();
		  studEnt.setStudName("vijji");
		  studEnt.setEmail("vijji@gmail.com");
		  studEnt.setStudAddress("velpur");
		  studEnt.setCourses(List.of(couEnt));
		  
		  bean.save(studEnt);
		  */
		  
		  
		   
		
		  
		
		  
		
		  
	
	}

}
