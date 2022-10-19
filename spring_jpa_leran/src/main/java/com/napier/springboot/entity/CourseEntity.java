package com.napier.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Course")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long courseId;
	private String courseName;
	private int courseCredit;
	
	
	//bidirectional mapping
	@OneToOne(mappedBy ="course", cascade = CascadeType.ALL)
	private CourseMaterialEntity courseMaterial;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(
			name ="fk_teacher_id",
			referencedColumnName ="teacherId")
	
	private TeacherEntity teacher;
	
	
}
