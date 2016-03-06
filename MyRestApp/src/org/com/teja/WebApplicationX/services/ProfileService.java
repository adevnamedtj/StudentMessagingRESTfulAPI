package org.com.teja.WebApplicationX.services;

import java.util.Map;
import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Profile;

public class ProfileService 
{
  private Map<String, Profile>  profileservicemap;//= Dao.getProfileMap(); for testing
  
  public Map<String, Profile> getProfileservicemap() {
	return profileservicemap;
}

public Map<String, Profile> setProfileService()
  {
	  profileservicemap = Dao.getProfileMap();
	 
   // this.profileservicemap.put("teja", new Profile(Integer.valueOf(1), "teja", "Teja", "Kalagara"));
   // this.profileservicemap.put("ravi", new Profile(Integer.valueOf(2), "ravi", "Ravi", "Kalagara"));
    return this.profileservicemap;
  }
  
  public Map<String, Profile> getProfiles()
  {
	  profileservicemap = Dao.getProfileMap();
    return this.profileservicemap;
  }
  
  public Profile getProfile(String profileUserId)
  {
	  profileservicemap = Dao.getProfileMap();
    if (profileUserId.isEmpty()) {
      return null;
    }
    return (Profile)this.profileservicemap.get(profileUserId);
  }
  
  public Profile addProfile(Profile profile)
  {
	  profileservicemap = Dao.getProfileMap();
    profile.setProfileId(Integer.valueOf(this.profileservicemap.size() + 1));
    return 
      (Profile)this.profileservicemap.put(profile.getProfileUserId(), profile);
  }
  
  public Profile updateProfile(Profile profile, String profileUserId)
  {
	  profileservicemap = Dao.getProfileMap();
    profile.setProfileUserId(profileUserId);
    
    return 
      (Profile)this.profileservicemap.put(profileUserId, profile);
  }
  
  public Profile deleteProfile(String profileUserId)
  {
	  profileservicemap = Dao.getProfileMap();
    return (Profile)this.profileservicemap.remove(profileUserId);
  }
}
