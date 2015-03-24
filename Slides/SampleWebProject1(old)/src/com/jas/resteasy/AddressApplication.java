package com.jas.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

public class AddressApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	public AddressApplication() {
		singletons.add(new AddressService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
