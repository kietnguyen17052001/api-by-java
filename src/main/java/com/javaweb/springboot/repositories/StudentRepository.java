package com.javaweb.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.springboot.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findOneById(int id);

	@Query(value = "SELECT * FROM student_management.tbl_student s WHERE s.student_name LIKE %:name%", nativeQuery = true)
	List<Student> searchName(@Param("name") String name);
}
