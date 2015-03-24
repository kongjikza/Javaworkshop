package com.jas.jpa.business;

import javax.persistence.EntityManager;

import com.jas.common.dao.DaoUtil;
import com.jas.jpa.dao.UserProfileDAO;
import com.jas.jpa.dao.UserProfileDAOImpl;
import com.jas.jpa.model.UserProfile;

public class UserProfileServiceImpl implements UserProfileService {

	public void createUserProfile(UserProfile userProfile) {
		EntityManager em = DaoUtil.createEntityManager();
		UserProfileDAO dao = new UserProfileDAOImpl(em);
		
		userProfile.setId(1); //set primary key ให้เท่ากับ 1
		userProfile.getUserAccount().setId(1);
		userProfile.getHomeAddress().setId(1);
		userProfile.getEducations().get(0).setId(1);
		userProfile.getJobs().get(0).setId(1);
		
		// Begin transaction
		em.getTransaction().begin();
		
		// Call DAO to insert
		dao.createUserProfile(userProfile);
		
		// Commit transaction
		em.getTransaction().commit();
	}
	
	public UserProfile getUserProfileWithDetails(String userName) {
		EntityManager em = DaoUtil.createEntityManager();
		UserProfileDAO dao = new UserProfileDAOImpl(em);
		Integer userProfileId = dao.findUserProfileId(userName);
		
		return dao.findUserProfile(userProfileId);
	}
}
