package com.jas.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.jas.jpa.ProductRestEasyService;

public class UserProfileApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public UserProfileApplication() {
		singletons.add(new UserProfileService());
		singletons.add(new ProductRestEasyService()); // ��˹�ҷ���繵�����ҧ object
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
