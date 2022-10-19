package com.napier.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.napier.springboot.entity.CourseEntity;
import com.napier.springboot.entity.CourseMaterialEntity;

@Repository
public interface ICourseDao extends JpaRepository<CourseEntity, Long>
{

}
