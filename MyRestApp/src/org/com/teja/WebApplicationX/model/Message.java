package org.com.teja.WebApplicationX.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message
{

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((messagedata == null) ? 0 : messagedata.hashCode());
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
		Message other = (Message) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (messagedata == null) {
			if (other.messagedata != null)
				return false;
		} else if (!messagedata.equals(other.messagedata))
			return false;
		return true;
	}

@Override
	public String toString() {
		return "Message [id=" + id + ", messagedata=" + messagedata + ", author=" + author + ", createDate="
				+ createDate + ", CommentsMap=" + CommentsMap + ", commentDeleteList=" + commentDeleteList + "]";
	}

private Integer id;
  private String messagedata;
  private String author;
  private Date createDate;
  private Map<Integer, Comment> CommentsMap = new HashMap();
  private List<Integer> commentDeleteList = new ArrayList();
  
  public Message() {}
  
  public Map<Integer, Comment> commentGenerator(Integer messageid, String message, String author)
  {
    Map<Integer, Comment> CommentsMapTemp = new HashMap();
    for (int i = 1; i <= 8; i++)
    {
      Comment comment = new Comment(Integer.valueOf(i), "Comment " + i + " M " + messageid, author);
      CommentsMapTemp.put(comment.getCommentid(), comment);
    }
    return CommentsMapTemp;
  }
  
  public Message(Integer id, String message, String author)
  {
    this.id = id;
    this.messagedata = message;
    this.author = author;
    this.createDate = new Date();
    this.CommentsMap = commentGenerator(id, message, author);
  }
  
  public String getMessage(String Data)
  {
    return Data;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getMessage()
  {
    return this.messagedata;
  }
  
  public void setMessage(String message)
  {
    this.messagedata = message;
  }
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public void setAuthor(String author)
  {
    this.author = author;
  }
  
  public Date getCreateDate()
  {
    return this.createDate;
  }
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public void setCreateDate()
  {
    this.createDate = new Date();
  }
  
  @XmlTransient
  public Map<Integer, Comment> getCommentsMap()
  {
    return this.CommentsMap;
  }
  
  public void setCommentsMap(Map<Integer, Comment> commentsMap)
  {
    this.CommentsMap = commentsMap;
  }
  
  @XmlTransient
  public List<Integer> getCommentDeleteList()
  {
    return this.commentDeleteList;
  }
  
  public void setCommentDeleteList(List<Integer> commentDeleteList)
  {
    this.commentDeleteList = commentDeleteList;
  }
}
