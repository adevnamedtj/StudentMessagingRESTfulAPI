package org.com.teja.WebApplicationX.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Profile;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest({Dao.class})
public class ProfileServiceTest {
	 private Map<String, Profile> profileservicetestmap;
	 private ProfileService profileService;


	@Before
	public void setUp() throws Exception {
		profileservicetestmap = new HashMap<>();
		profileservicetestmap.put("teja", new Profile(Integer.valueOf(1), "teja", "Teja", "Kalagara"));
	    profileservicetestmap.put("ravi", new Profile(Integer.valueOf(2), "ravi", "Ravi", "Kalagara"));
	}
	
	@Test
	public void setProfileServiceTest(){
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getProfileMap()).andReturn(profileservicetestmap).anyTimes();
		PowerMock.replay(Dao.class);
		profileService = new ProfileService();
		assertEquals(Dao.getProfileMap().get("teja").toString(),profileservicetestmap.get("teja").toString());
		PowerMock.verify(Dao.class);
	
	}

	@Test
	public void addProfileTest() {
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getProfileMap()).andReturn(profileservicetestmap).anyTimes();
		PowerMock.replay(Dao.class);
		profileService = new ProfileService();
		profileService.addProfile(new Profile(Integer.valueOf(2), "raju", "RAjendra", "Karuturi"));
		assertEquals(new Profile(Integer.valueOf(3), "raju", "RAjendra", "Karuturi").toString(), 
				profileService.getProfileservicemap().get("raju").toString());
		
	}
	@Test
	public void deleteProfiletest(){
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getProfileMap()).andReturn(profileservicetestmap).anyTimes();
		PowerMock.replay(Dao.class);
		profileService = new ProfileService();
		profileService.deleteProfile("teja");
		assertFalse(profileService.getProfileservicemap().containsKey("teja"));
		
		
		
	}
	//Testing ProfileService.getProfile()
	@Test
	public void getProfileTest(){
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getProfileMap()).andReturn(profileservicetestmap).anyTimes();
		PowerMock.replay(Dao.class);
		profileService = new ProfileService();
		assertEquals(new Profile(Integer.valueOf(1), "teja", "Teja", "Kalagara").toString(), 
				profileService.getProfile("teja").toString());
		PowerMock.verify(Dao.class);
	}
	//Testing ProfileService.getProfiles();
	@Test
	public void getAllProfilesTest(){
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getProfileMap()).andReturn(profileservicetestmap).anyTimes();
		PowerMock.replay(Dao.class);
		profileService = new ProfileService();
		assertEquals(profileService.getProfiles().toString(), profileservicetestmap.toString());
		PowerMock.verify(Dao.class);
		
	}
	//Testing ProfileServices.UpdateProfile
	@Test
	public void updateProfileTest(){
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getProfileMap()).andReturn(profileservicetestmap).anyTimes();
		PowerMock.replay(Dao.class);
		profileService = new ProfileService();
		profileService.updateProfile(new Profile(Integer.valueOf(1), "teja", "Teja", "KalagaraUpdated"),
				"teja").toString();
		assertEquals(
		profileService.getProfileservicemap().get("teja").toString(),
		new Profile(Integer.valueOf(1), "teja", "Teja", "KalagaraUpdated").toString()
		
		);
		
	}
	@After
	public void cleanUp(){
		profileService =null;
		profileservicetestmap = null;
		PowerMock.reset(Dao.class);
	}

}
