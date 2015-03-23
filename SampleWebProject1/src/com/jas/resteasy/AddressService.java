package com.jas.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jas.myweb.domain.Address;;


@Path("/Address")
public class AddressService {
	
	@POST
	@Consumes("application/json")
	public Response create(Address address) {
		String result = "";
		if (address != null) {
			System.out.println("City =" + address.getCity());
			System.out.println("Province =" + address.getProvince());
			System.out.println("Street 1 =" + address.getStreet1());
			System.out.println("Street 2 =" + address.getStreet2());
			System.out.println("Zipcode =" + address.getZipCode());
			
			result = "City created for " + address.getCity();
		}
		
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/{city}")
	@Produces("application/json")
	public Response get(@PathParam("city") String city) {
		Address address = new Address();
		address.setCity(city);
		address.setProvince("Talad");
		address.setStreet1("Changwatana");
		address.setStreet2("Bangkok");
		address.setZipCode(84000);
		
		return Response.status(200).entity(address).build();
	}
}
