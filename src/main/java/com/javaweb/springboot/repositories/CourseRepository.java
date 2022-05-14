package com.javaweb.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.springboot.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	Course findOneById(int id);

}
