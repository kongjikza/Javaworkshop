package com.jas.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jas.common.dao.DaoUtil;
import com.jas.jpa.model.Education;
import com.jas.jpa.model.EducationInstitute;
import com.jas.jpa.model.HomeAddress;
import com.jas.jpa.model.Job;
import com.jas.jpa.model.Province;
import com.jas.jpa.model.UserAccount;
import com.jas.jpa.model.UserProfile;

public class UserProfileDAOImpl implements UserProfileDAO {
	private EntityManager em;
	
	public UserProfileDAOImpl(EntityManager em) {
		this.em = em;
	}
	

	public List<Province> findAllProvinces() {
		List<Province> provinces = null;
		TypedQuery<Province> query = this.em.createQuery("SELECT e FROM Province e", Province.class);
		provinces = query.getResultList();
		
		return provinces;
	}
	
	public List<EducationInstitute> findAllEducationInstitutes() {
		List<EducationInstitute> educationInstitutes = null;
		TypedQuery<EducationInstitute> query = this.em.createQuery(
				"SELECT e FROM EducationInstitute e", EducationInstitute.class);
		educationInstitutes = query.getResultList();
		
		return educationInstitutes;
	}
	
	public void createUserProfile(UserProfile userProfile) {
		this.em.persist(userProfile.getUserAccount());
		
		HomeAddress homeAddress = userProfile.getHomeAddress();
		homeAddress.setUserProfile(userProfile); // set ให้ homeAddress รู้จัก userProfile
		this.em.persist(homeAddress);
		
		Education education = userProfile.getEducations().get(0);
		education.setUserProfile(userProfile);
		this.em.persist(education);
		
		Job job = userProfile.getJobs().get(0);
		job.setUserProfile(userProfile);
		this.em.persist(job);
		
		this.em.persist(userProfile);
	}	
	
	public Integer findUserProfileId(String userName) {
		TypedQuery<UserProfile> query = this.em.createQuery(
				"SELECT up FROM UserProfile up, UserAccount ua"
				+ " WHERE ua.id=up.userAccount.id AND ua.userName=:userName", UserProfile.class);
		UserProfile userProfile = query.setParameter("userName", userName).getSingleResult();
		
		return userProfile.getId();
	}
	
	// This method has bad performance. It send query 4 times to DB.
	public UserProfile findUserProfile(Integer id) {
		UserProfile userProfile = this.em.find(UserProfile.class, id);
		userProfile.setHomeAddress(this.findHomeAddress(userProfile.getId()));
		userProfile.setEducations(this.findEducations(userProfile.getId()));
		userProfile.setJobs(this.findJobs(userProfile.getId()));
		
		return userProfile;
	}
	
	public HomeAddress findHomeAddress(Integer userProfileId) {
		TypedQuery<HomeAddress> query = this.em.createQuery(
				"SELECT e FROM HomeAddress e WHERE e.userProfile.id = :userProfileId", HomeAddress.class);
		HomeAddress homeAddress = query.setParameter("userProfileId", userProfileId).getSingleResult();
		
		return homeAddress;
	}
	
	public List<Education> findEducations(Integer userProfileId) {
		List<Education> educations = null;
		TypedQuery<Education> query = this.em.createQuery(
				"SELECT e FROM Education e WHERE e.userProfile.id = :userProfileId", Education.class);
		educations = query.setParameter("userProfileId", userProfileId).getResultList();
		
		return educations;
	}
	
	public List<Job> findJobs(Integer userProfileId) {
		List<Job> jobs = null;
		TypedQuery<Job> query = this.em.createQuery(
				"SELECT e FROM Job e WHERE e.userProfile.id = :userProfileId", Job.class);
		jobs = query.setParameter("userProfileId", userProfileId).getResultList();
		
		return jobs;
	}
}
