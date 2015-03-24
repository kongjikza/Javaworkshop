package com.jas.jpa.business;

import java.util.List;

import javax.persistence.EntityManager;

import com.jas.common.dao.DaoUtil;
import com.jas.jpa.dao.UserProfileDAO;
import com.jas.jpa.dao.UserProfileDAOImpl;
import com.jas.jpa.model.Province;

public class ProvinceServiceImpl implements ProvinceService {

	public List<Province> getAllProvinces() {
		EntityManager em = DaoUtil.createEntityManager();
		UserProfileDAO dao = new UserProfileDAOImpl(em);
		
		return dao.findAllProvinces();
	}
}
