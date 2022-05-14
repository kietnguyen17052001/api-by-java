package com.javaweb.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.springboot.dto.CourseDTO;
import com.javaweb.springboot.entities.Course;
import com.javaweb.springboot.objects.Message;
import com.javaweb.springboot.services.CourseService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CourseAPI {

	@Autowired
	private CourseService service;

	@GetMapping(value = "/courses")
	public List<CourseDTO> getCourses() {
		return service.getCourses();
	}

	@GetMapping(value = "/courses/{id}")
	public CourseDTO getCourse(@PathVariable Integer id) {
		return service.getCourse(id);
	}

	@PostMapping(value = "/courses")
	public void insert(@RequestBody Course course) {
		service.insert(course);
	}

	@DeleteMapping(value = "/courses/{id}")
	public Message delete(@PathVariable Integer id) {
		return service.delete(id);
	}

}
