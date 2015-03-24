package com.jas.jpa.business;

import com.jas.jpa.model.UserProfile;

public interface UserProfileService {

	void createUserProfile(UserProfile userProfile);
	
	UserProfile getUserProfileWithDetails(String userName);
}
