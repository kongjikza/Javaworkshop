package com.jas.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jas.jpa.business.EducationInstituteService;
import com.jas.jpa.model.EducationInstitute;

@Controller
@RequestMapping("/educationinstitute")
public class EducationInstituteController {

	private EducationInstituteService educationInstituteService;
		
	@Autowired
	public EducationInstituteController(EducationInstituteService educationInstituteService) {
		this.educationInstituteService = educationInstituteService;
	}
		
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<EducationInstitute> getAll() {
		return educationInstituteService.getAllEducationInstitutes();
	}
}
