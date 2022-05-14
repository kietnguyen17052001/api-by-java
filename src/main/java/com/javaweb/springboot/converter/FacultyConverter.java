package com.javaweb.springboot.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.springboot.dto.FacultyDTO;
import com.javaweb.springboot.entities.Faculty;

@Component
public class FacultyConverter {
	public FacultyDTO toDTO(Faculty faculty) {
		FacultyDTO dto = new FacultyDTO();
		dto.setId(faculty.getId());
		dto.setName(faculty.getName());
		return dto;
	}

	public List<FacultyDTO> toDTOs(List<Faculty> faculties) {
		List<FacultyDTO> dtos = new ArrayList<FacultyDTO>();
		for (Faculty faculty : faculties) {
			dtos.add(toDTO(faculty));
		}
		return dtos;
	}
}
