package com.napier.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity

//@Data provides getters and setters and toString() methods defaultly
@Data

//If table name is not given then Class name will be taken as table name
@Table(name="Student")

public class StudentEntity {
	
	//@Id specifies a primary key
	@Id
	//@SequenceGenerator(name = "stud_seq", sequenceName = "sequenceName", allocationSize =2, initialValue=4)
	//generating studentId automatically in sequence way
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="studentId")
	private long studId;
	
	@Column(name ="studentName")
	private String studName;
	
	@Column(name ="studentAddress")
	private String studAddress;
	
	@Column(name ="studentEmail", nullable = false, unique=true)  //email is not null and unique
	private String email;
	
	//many-many
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
				name ="studentCourseMap",
				joinColumns =@JoinColumn(
						name ="fkStudentId",
						referencedColumnName = "studentId"
						),
				inverseJoinColumns = @JoinColumn(
						name ="fkCourseId",
						referencedColumnName = "courseId"
						)
			  )
	
	private List<CourseEntity> courses;

	
	
	
	

}
