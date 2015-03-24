package com.jas.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jas.jpa.business.ProvinceService;
import com.jas.jpa.model.Province;

@Controller
@RequestMapping("/province")
public class ProvinceController {

	private ProvinceService provinceService;
	
	@Autowired
	public ProvinceController(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Province> getAll() {
		return provinceService.getAllProvinces();
	}
}
