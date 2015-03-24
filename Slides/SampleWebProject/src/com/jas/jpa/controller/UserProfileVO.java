package com.jas.jpa.controller;

import com.jas.jpa.model.UserProfile;

public class UserProfileVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private UserProfile userProfile;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}
