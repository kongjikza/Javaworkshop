package com.jas.jpa.dao;

import java.util.List;

import com.jas.jpa.model.Education;
import com.jas.jpa.model.EducationInstitute;
import com.jas.jpa.model.HomeAddress;
import com.jas.jpa.model.Job;
import com.jas.jpa.model.Province;
import com.jas.jpa.model.UserAccount;
import com.jas.jpa.model.UserProfile;

public interface UserProfileDAO {

	List<Province> findAllProvinces();
	List<EducationInstitute> findAllEducationInstitutes();
	
	void createUserProfile(UserProfile userProfile);
	
	Integer findUserProfileId(String userName);
	UserProfile findUserProfile(Integer id);
	
	HomeAddress findHomeAddress(Integer userProfileId);
	List<Education> findEducations(Integer userProfileId);
	List<Job> findJobs(Integer userProfileId);
}
