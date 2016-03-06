package org.com.teja.WebApplicationX.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile
{
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dob == null) ? 0 : Dob.hashCode());
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		result = prime * result + ((profileUserFname == null) ? 0 : profileUserFname.hashCode());
		result = prime * result + ((profileUserId == null) ? 0 : profileUserId.hashCode());
		result = prime * result + ((profileUserLname == null) ? 0 : profileUserLname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (Dob == null) {
			if (other.Dob != null)
				return false;
		} else if (!Dob.equals(other.Dob))
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (profileUserFname == null) {
			if (other.profileUserFname != null)
				return false;
		} else if (!profileUserFname.equals(other.profileUserFname))
			return false;
		if (profileUserId == null) {
			if (other.profileUserId != null)
				return false;
		} else if (!profileUserId.equals(other.profileUserId))
			return false;
		if (profileUserLname == null) {
			if (other.profileUserLname != null)
				return false;
		} else if (!profileUserLname.equals(other.profileUserLname))
			return false;
		return true;
	}

@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileUserId=" + profileUserId + ", profileUserFname="
				+ profileUserFname + ", profileUserLname=" + profileUserLname + ", Dob=" + Dob + "]";
	}

private Integer profileId;
  private String profileUserId;
  private String profileUserFname;
  private String profileUserLname;
  private Date Dob;
  
  public Profile() {}
  
  public Profile(Integer profileIdx, String profileUserIdx, String profileUserFnamex, String profileUserLnamex, Date Dobx)
  {
    this.profileId = profileIdx;
    this.profileUserId = profileUserIdx;
    this.profileUserFname = profileUserFnamex;
    this.profileUserLname = profileUserLnamex;
    this.Dob = Dobx;
  }
  
  public Profile(Integer profileIdx, String profileUserIdx, String profileUserFnamex, String profileUserLnamex)
  {
    this.profileId = profileIdx;
    this.profileUserId = profileUserIdx;
    this.profileUserFname = profileUserFnamex;
    this.profileUserLname = profileUserLnamex;
    this.Dob = new Date();
  }
  
  public Integer getProfileId()
  {
    return this.profileId;
  }
  
  public void setProfileId(Integer profileId)
  {
    this.profileId = profileId;
  }
  
  public String getProfileUserId()
  {
    return this.profileUserId;
  }
  
  public void setProfileUserId(String profileUserId)
  {
    this.profileUserId = profileUserId;
  }
  
  public String getProfileUserFname()
  {
    return this.profileUserFname;
  }
  
  public void setProfileUserFname(String profileUserFname)
  {
    this.profileUserFname = profileUserFname;
  }
  
  public String getProfileUserLname()
  {
    return this.profileUserLname;
  }
  
  public void setProfileUserLname(String profileUserLname)
  {
    this.profileUserLname = profileUserLname;
  }
  
  public Date getDob()
  {
    return this.Dob;
  }
  
  public void setDob(Date dob)
  {
    this.Dob = dob;
  }
}
