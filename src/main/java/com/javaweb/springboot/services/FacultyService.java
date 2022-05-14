package com.javaweb.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.springboot.entities.Faculty;
import com.javaweb.springboot.objects.Message;
import com.javaweb.springboot.objects.Message.Status;
import com.javaweb.springboot.repositories.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository repository;

	public List<Faculty> getFaculties() {
		List<Faculty> faculties = repository.findAll();
		return faculties;
	}

	public Faculty getFaculty(Integer id) {
		Faculty faculty = null;
		faculty = repository.findOneById(id);
		if (id == null || faculty == null) {
			return null;
		}
		return faculty;
	}

	public void insert(Faculty faculty) {
		repository.save(faculty);
	}

	public Message delete(Integer id) {
		Message message = new Message();
		Faculty faculty = null;
		faculty = repository.findOneById(id);
		if (id == null || faculty == null) {
			message.setStatus(Status.FAILED);
			message.setMessage("Is null or empty!");
		} else {
			repository.delete(faculty);
			message.setStatus(Status.SUCCESS);
			message.setMessage("Delete successfully");
		}
		return message;
	}
}
