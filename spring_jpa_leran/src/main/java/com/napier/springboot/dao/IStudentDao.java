package com.napier.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.napier.springboot.entity.StudentEntity;

@Repository
public interface IStudentDao extends JpaRepository<StudentEntity, Long>
{

	Optional<StudentEntity> findByStudName(String string);

	List<StudentEntity> findByStudNameContaining(String string);
	
	//JPQL Queries
	//this JPQL deals with class name and variable names
	@Query("select s.studName from StudentEntity s where s.email=?1")
	String getAllDataUsingJPQL(String mailId);
	
	@Query("select s from StudentEntity s where s.email=?1")
	List<StudentEntity> getAllDataUsingJPQL1(String mailId);
	
	//Native queries
	@Query(
			value ="select * from Student s where s.student_Email=?1",
			nativeQuery =true
			)
	List<StudentEntity> getAllDataUsingNativeQuery(String mailId);
	
	//Native Named param
	@Query(
			value = "select * from Student s where s.student_Email =:emailVar and s.student_address =:addressVar",
			nativeQuery = true)
	List<StudentEntity> getAllDataUsingNativeNamedQuery(@Param("emailVar") String emailVar, @Param("addressVar") String var2);
	
	//update queries
	@Modifying
	@Transactional
	@Query(
			value = "update Student  set student_name=?1  where student_id=?2",
			nativeQuery = true)
	void getAllDataUsingNativeNamedUpdateQuery1(String one, long two);
	
	@Modifying
	@Transactional
	@Query(
			value = "insert into Student(student_id,student_name, student_address, student_email) values(?1,?2,?3,?4)",
			nativeQuery = true)
	void getAllDataUsingNativeNamedInsertQuery2(long id,String one, String two, String three);
	
	//Pagination and sorting methods
	//pagination

	
	
	
	
	
	
	
	
}
