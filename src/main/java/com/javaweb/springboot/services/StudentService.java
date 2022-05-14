package com.javaweb.springboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.springboot.converter.StudentConverter;
import com.javaweb.springboot.dto.StudentDTO;
import com.javaweb.springboot.entities.Course;
import com.javaweb.springboot.entities.Faculty;
import com.javaweb.springboot.entities.Student;
import com.javaweb.springboot.objects.Message;
import com.javaweb.springboot.objects.Message.Status;
import com.javaweb.springboot.repositories.CourseRepository;
import com.javaweb.springboot.repositories.FacultyRepository;
import com.javaweb.springboot.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	@Autowired
	private FacultyRepository falRepository;
	@Autowired
	private CourseRepository coRepository;
	@Autowired
	private StudentConverter converter;

	public List<StudentDTO> getStudents() {
		List<Student> students = repository.findAll();
		List<StudentDTO> dtos = converter.getDTOs(students);
		return dtos;
	}

	public StudentDTO getStudent(Integer id) {
		Student student = repository.findOneById(id);
		if (id == null || student == null) {
			return null;
		}
		StudentDTO dto = converter.toDTO(student);
		return dto;
	}

	public void insert(StudentDTO dto) {
		Faculty faculty = falRepository.findOneById(dto.getId_faculty());
		Student student = converter.toEntity(dto, faculty, null);
		repository.save(student);
	}

	public Message delete(Integer id) {
		Message message = new Message();
		Student student = null;
		student = repository.findOneById(id);
		if (id == null || student == null) {
			message.setStatus(Status.FAILED);
			message.setMessage("Is null or empty!");
		} else {
			// delete courses of student
			student.setCourses(null);
			repository.save(student);
			repository.delete(student);
			message.setStatus(Status.SUCCESS);
			message.setMessage("Delete successfully");
		}
		return message;
	}

	public List<StudentDTO> searchName(String name) {
		System.out.println(name.toString());
		List<StudentDTO> students = converter.getDTOs(repository.searchName(name));
		System.out.println(students.size() == 0 ? "Not found" : students.get(0).getName());
		return students;
	}

	public void registerCourse(Integer studentId, List<Integer> coursesId) {
		Student student = repository.findOneById(studentId);
		List<Course> courses = student.getCourses();
		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		Course course = null;
		for (Integer courseId : coursesId) {
			course = coRepository.findOneById(courseId);
			if (courses.contains(course)) {
				continue;
			}
			courses.add(course);
		}
		student.setCourses(courses);
		repository.save(student);
	}

}
