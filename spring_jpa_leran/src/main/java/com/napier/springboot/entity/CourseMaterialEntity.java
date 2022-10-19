package com.napier.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CourseMaterial")
public class CourseMaterialEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseMaterialId;
	private String courseUrl;
	
	
	//Course and CourseMaterial tables is having one to one mapping and courseId will be  the foreign key in courseMaterial table
	@OneToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name ="fkCourseId",
			referencedColumnName ="courseId"
			)
	private CourseEntity course;

}
