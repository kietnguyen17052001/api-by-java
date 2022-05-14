package com.javaweb.springboot.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.springboot.dto.StudentDTO;
import com.javaweb.springboot.entities.Course;
import com.javaweb.springboot.entities.Faculty;
import com.javaweb.springboot.entities.Student;

@Component
public class StudentConverter {
	@Autowired
	private CourseConverter courseConverter;

	public StudentDTO toDTO(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setEmail(student.getEmail());
		dto.setAddress(student.getAddress());
		dto.setId_faculty(student.getFaculty().getId());
		dto.setCourses(courseConverter.toDTOs(student.getCourses()));
		return dto;
	}

	public Student toEntity(StudentDTO dto, Faculty faculty, List<Course> courses) {
		Student student = new Student();
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setAddress(dto.getAddress());
		student.setFaculty(faculty);
		student.setCourses(courses);
		return student;
	}

	public List<StudentDTO> getDTOs(List<Student> students) {
		List<StudentDTO> dtos = new ArrayList<StudentDTO>();
		for (Student student : students) {
			dtos.add(toDTO(student));
		}
		return dtos;
	}
}
