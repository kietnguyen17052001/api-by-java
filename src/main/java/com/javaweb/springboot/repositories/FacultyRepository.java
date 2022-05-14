package com.javaweb.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.springboot.entities.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	Faculty findOneById(int id);
}
