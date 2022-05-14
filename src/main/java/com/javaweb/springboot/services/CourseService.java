package com.javaweb.springboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.springboot.converter.CourseConverter;
import com.javaweb.springboot.dto.CourseDTO;
import com.javaweb.springboot.entities.Course;
import com.javaweb.springboot.entities.Student;
import com.javaweb.springboot.objects.Message;
import com.javaweb.springboot.objects.Message.Status;
import com.javaweb.springboot.repositories.CourseRepository;
import com.javaweb.springboot.repositories.StudentRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseConverter converter;

	public List<CourseDTO> getCourses() {
		List<Course> courses = repository.findAll();
		return converter.toDTOs(courses);
	}

	public CourseDTO getCourse(Integer id) {
		Course course = null;
		course = repository.findOneById(id);
		if (id == null || course == null) {
			return null;
		}
		return converter.toDTO(course);
	}

	public void insert(Course course) {
		repository.save(course);
	}

	public Message delete(Integer id) {
		Message message = new Message();
		Course course = null;
		course = repository.findOneById(id);
		if (id == null || course == null) {
			message.setStatus(Status.FAILED);
			message.setMessage("Is null or empty!");
		} else {
			course.setStudents(null);
			repository.save(course);
			repository.delete(course);
			message.setStatus(Status.SUCCESS);
			message.setMessage("Delete successfully");
		}
		return message;
	}

	public void addStudent(Integer courseId, List<Integer> studentsId) {
		Course course = repository.findOneById(courseId);
		List<Student> students = course.getStudents();
		if (students == null) {
			students = new ArrayList<Student>();
		}
		Student student = null;
		for (Integer studentId : studentsId) {
			student = studentRepository.findOneById(studentId);
			if (students.contains(student)) {
				continue;
			}
			students.add(student);
		}
		course.setStudents(students);
		repository.save(course);
	}
}
