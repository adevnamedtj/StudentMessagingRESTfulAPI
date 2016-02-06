package org.com.teja.WebApplicationX.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.com.teja.WebApplicationX.model.Profile;
import org.com.teja.WebApplicationX.services.ProfileService;

@Path("/profiles")
public class ProfileResource
{
  private ProfileService profileservice = new ProfileService();
  
  @GET
  @Path("/set")
  @Produces({"application/json"})
  public List<Profile> getProfiles()
  {
    return new ArrayList(this.profileservice.setProfileService().values());
  }
  
  @GET
  @Produces({"application/json"})
  public List<Profile> getAllProfilesFromResource()
  {
    return new ArrayList(this.profileservice.getProfiles().values());
  }
  
  @GET
  @Produces({"application/json"})
  @Path("/{ProfileUserId}")
  public Profile getProfile(@PathParam("ProfileUserId") String ProfileUserId)
  {
    return this.profileservice.getProfile(ProfileUserId);
  }
  
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Profile addProfile(Profile Profile)
  {
    return this.profileservice.addProfile(Profile);
  }
  
  @PUT
  @Path("/{ProfileUserId}")
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Profile updateProfile(@PathParam("ProfileUserId") String profileUserId, Profile Profile)
  {
    return this.profileservice.updateProfile(Profile, profileUserId);
  }
  
  @DELETE
  @Produces({"application/json"})
  @Path("/{ProfileUserId}")
  public Profile deleteProfile(@PathParam("ProfileUserId") String profileUserId)
  {
    return this.profileservice.deleteProfile(profileUserId);
  }
}
