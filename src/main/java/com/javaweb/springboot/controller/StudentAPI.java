package com.javaweb.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.springboot.dto.StudentDTO;
import com.javaweb.springboot.objects.Message;
import com.javaweb.springboot.services.StudentService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class StudentAPI {
	@Autowired
	private StudentService service;

	@GetMapping(value = "/students")
	public List<StudentDTO> getStudents() {
		return service.getStudents();
	}

	@GetMapping(value = "/students/{id}")
	public StudentDTO getStudent(@PathVariable Integer id) {
		return service.getStudent(id);
	}

	@GetMapping(value = "/students/search/{name}")
	public List<StudentDTO> searchName(@PathVariable String name) {
		return service.searchName(name);
	}

	@PostMapping(value = "/students")
	public void insert(@RequestBody StudentDTO student) {
		service.insert(student);
	}

	@DeleteMapping(value = "/students/{id}")
	public Message delete(@PathVariable Integer id) {
		return service.delete(id);
	}

	@PutMapping(value = "/students/{id}/courses")
	public void registerCourse(@PathVariable Integer id, @RequestBody List<Integer> coursesId) {
		service.registerCourse(id, coursesId);
	}
}
