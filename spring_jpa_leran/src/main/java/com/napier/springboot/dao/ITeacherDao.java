package com.napier.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.napier.springboot.entity.TeacherEntity;

@Repository
public interface ITeacherDao extends JpaRepository<TeacherEntity, Long>{

}
