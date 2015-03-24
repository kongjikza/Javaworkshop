package com.jas.jpa.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jas.jpa.business.UserProfileService;
import com.jas.jpa.business.UserProfileServiceImpl;
import com.jas.jpa.model.UserProfile;

@Path("/v2/userprofile")
public class UserProfileJPAService {

	@POST
	@Consumes("application/json")
	public Response create(UserProfileVO userProfileVO) {
		String result = "";
		if (userProfileVO != null) {
			
			System.out.println("userName=" + userProfileVO.getUserProfile().getUserAccount().getUserName());
			System.out.println("password=" + userProfileVO.getUserProfile().getUserAccount().getPassword());
			System.out.println("firstName=" + userProfileVO.getUserProfile().getFirstName());
			System.out.println("lastName=" + userProfileVO.getUserProfile().getLastName());
			System.out.println("email=" + userProfileVO.getUserProfile().getEmail());
			System.out.println("street1=" + userProfileVO.getUserProfile().getHomeAddress().getStreet1());
			System.out.println("street2=" + userProfileVO.getUserProfile().getHomeAddress().getStreet2());
			System.out.println("province=" + userProfileVO.getUserProfile().getHomeAddress().getProvince().getId());
			System.out.println("zipCode=" + userProfileVO.getUserProfile().getHomeAddress().getZipCode());
			System.out.println("educationInstitute.id=" + userProfileVO.getUserProfile().getEducations().get(0).getEducationInstitute().getId());
			System.out.println("qualification=" + userProfileVO.getUserProfile().getEducations().get(0).getQualification());
			System.out.println("fromYear=" + userProfileVO.getUserProfile().getEducations().get(0).getFromYear());
			System.out.println("toYear=" + userProfileVO.getUserProfile().getEducations().get(0).getToYear());
			System.out.println("position=" + userProfileVO.getUserProfile().getJobs().get(0).getPosition());
			System.out.println("fromYear=" + userProfileVO.getUserProfile().getJobs().get(0).getFromYear());
			System.out.println("toYear=" + userProfileVO.getUserProfile().getJobs().get(0).getToYear());

			UserProfileService service = new UserProfileServiceImpl();
			service.createUserProfile(userProfileVO.getUserProfile());
			
			result = "User profile created for " + userProfileVO.getUserProfile().getUserAccount().getUserName();
		}
		
		return Response.status(200).entity(result).build();
	}


	@GET
	@Path("{userName}")
	@Produces("application/json")
	public Response get(@PathParam("userName") String userName) {
		UserProfileService service = new UserProfileServiceImpl();
		
		UserProfile userProfile = service.getUserProfileWithDetails(userName);
		
		System.out.println("userName=" + userProfile.getUserAccount().getUserName());
		System.out.println("password=" + userProfile.getUserAccount().getPassword());
		System.out.println("firstName=" + userProfile.getFirstName());
		System.out.println("lastName=" + userProfile.getLastName());
		System.out.println("email=" + userProfile.getEmail());
		System.out.println("street1=" + userProfile.getHomeAddress().getStreet1());
		System.out.println("street2=" + userProfile.getHomeAddress().getStreet2());
		System.out.println("province=" + userProfile.getHomeAddress().getProvince().getId());
		System.out.println("zipCode=" + userProfile.getHomeAddress().getZipCode());
		System.out.println("educationInstitute.id=" + userProfile.getEducations().get(0).getEducationInstitute().getId());
		System.out.println("qualification=" + userProfile.getEducations().get(0).getQualification());
		System.out.println("fromYear=" + userProfile.getEducations().get(0).getFromYear());
		System.out.println("toYear=" + userProfile.getEducations().get(0).getToYear());
		System.out.println("position=" + userProfile.getJobs().get(0).getPosition());
		System.out.println("fromYear=" + userProfile.getJobs().get(0).getFromYear());
		System.out.println("toYear=" + userProfile.getJobs().get(0).getToYear());
		
		return Response.status(200).entity(userProfile).build();
	}
}
