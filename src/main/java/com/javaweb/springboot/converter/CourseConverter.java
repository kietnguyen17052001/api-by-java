package com.javaweb.springboot.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.springboot.dto.CourseDTO;
import com.javaweb.springboot.entities.Course;

@Component
public class CourseConverter {

	public CourseDTO toDTO(Course course) {
		CourseDTO dto = new CourseDTO();
		dto.setId(course.getId());
		dto.setName(course.getName());
		return dto;
	}

	public List<CourseDTO> toDTOs(List<Course> courses) {
		List<CourseDTO> dtos = new ArrayList<CourseDTO>();
		for (Course course : courses) {
			dtos.add(toDTO(course));
		}
		return dtos;
	}
}
