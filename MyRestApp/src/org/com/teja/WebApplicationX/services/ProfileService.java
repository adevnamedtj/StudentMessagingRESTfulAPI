package org.com.teja.WebApplicationX.services;

import java.util.Map;
import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Profile;

public class ProfileService
{
  private Map<String, Profile> profileservicemap = Dao.getProfileMap();
  
  public Map<String, Profile> setProfileService()
  {
    this.profileservicemap.put("teja", new Profile(Integer.valueOf(1), "teja", "Teja", "Kalagara"));
    this.profileservicemap.put("ravi", new Profile(Integer.valueOf(2), "ravi", "Ravi", "Kalagara"));
    return this.profileservicemap;
  }
  
  public Map<String, Profile> getProfiles()
  {
    return this.profileservicemap;
  }
  
  public Profile getProfile(String profileUserId)
  {
    if (profileUserId.isEmpty()) {
      return null;
    }
    return (Profile)this.profileservicemap.get(profileUserId);
  }
  
  public Profile addProfile(Profile profile)
  {
    profile.setProfileId(Integer.valueOf(this.profileservicemap.size() + 1));
    return 
      (Profile)this.profileservicemap.put(profile.getProfileUserId(), profile);
  }
  
  public Profile updateProfile(Profile profile, String profileUserId)
  {
    profile.setProfileUserId(profileUserId);
    
    return 
      (Profile)this.profileservicemap.put(profileUserId, profile);
  }
  
  public Profile deleteProfile(String profileUserId)
  {
    return (Profile)this.profileservicemap.remove(profileUserId);
  }
}
