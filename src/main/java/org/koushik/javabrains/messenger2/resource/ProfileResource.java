package org.koushik.javabrains.messenger2.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger2.model.Profile;
import org.koushik.javabrains.messenger2.service.ProfileService;

@Path("/profiles")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ProfileResource {
	ProfileService profileService= new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}

	@POST
	public Profile addProfile( Profile profile){
		profile.setCreated(new Date());
		return profileService.addProfile(profile);
	}
	@Path("/{profileName}")
	@GET
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	@Path("/{profileName}")
	@PUT
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	@Path("/{profileName}")
	@DELETE
	public Profile deleteProfile(@PathParam("profileName")String profileName){
		return profileService.removeProfile(profileName);
	}


}
