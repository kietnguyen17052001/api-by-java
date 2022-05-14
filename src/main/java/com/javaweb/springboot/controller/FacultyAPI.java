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

import com.javaweb.springboot.entities.Faculty;
import com.javaweb.springboot.objects.Message;
import com.javaweb.springboot.services.FacultyService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FacultyAPI {

	@Autowired
	private FacultyService service;

	@GetMapping(value = "/faculties")
	private List<Faculty> getFaculties() {
		return service.getFaculties();
	}

	@GetMapping(value = "/faculties/{id}")
	private Faculty getFaculty(@PathVariable Integer id) {
		return service.getFaculty(id);
	}

	@PostMapping(value = "/faculties")
	private void insert(@RequestBody Faculty faculty) {
		service.insert(faculty);
	}

	@DeleteMapping(value = "/faculties/{id}")
	private Message delete(@PathVariable Integer id) {
		return service.delete(id);
	}
}
