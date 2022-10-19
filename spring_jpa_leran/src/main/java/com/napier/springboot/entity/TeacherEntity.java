package com.napier.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Teacher")
public class TeacherEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long teacherId;
	private String tecaherName;
	
	//one-many
	/*
	@OneToMany(cascade =CascadeType.ALL)
	@JoinColumn(
			name="fk_teacherId",
			referencedColumnName ="teacherId")
	private List<CourseEntity> courses;*/
	
	
	
	

}
