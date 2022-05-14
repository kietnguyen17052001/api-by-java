package com.javaweb.springboot.dto;

import java.util.List;

public class StudentDTO {
	private int id;
	private String name;
	private String email;
	private String address;
	private int id_faculty;
	private List<CourseDTO> courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId_faculty() {
		return id_faculty;
	}

	public void setId_faculty(int id_faculty) {
		this.id_faculty = id_faculty;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

}
