package org.com.teja.WebApplicationX.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;

public class Comment
{
  @Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", comment=" + comment + ", createdDate=" + createdDate + ", author="
				+ author + ", Auth=" + Auth + "]";
	}

private Integer commentid;
  private String comment;
  private Date createdDate;
  private String author;
  private String Auth;
  
  public Comment() {}
  
  public Comment(Integer commentId, String comment, String author)
  {
    this.commentid = commentId;
    this.comment = comment;
    this.author = author;
    this.createdDate = new Date();
  }
  
  public Comment(Integer messageId, String comment, String error, Boolean status)
  {
    this.comment = comment;
    this.Auth = ("message " + messageId + " Active Status " + status + " Response " + error);
  }
  
  public Integer getCommentid()
  {
    return this.commentid;
  }
  
  public void setCommentid(Integer cid)
  {
    this.commentid = cid;
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public void setComment(String comment)
  {
    this.comment = comment;
  }
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public void setAuthor(String author)
  {
    this.author = author;
  }
  
  public Date getCreatedDate()
  {
    return this.createdDate;
  }
  
  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }
  
  @XmlTransient
  public String getAuth()
  {
    return this.Auth;
  }
  
  public void setAuth(String auth)
  {
    this.Auth = auth;
  }
}
