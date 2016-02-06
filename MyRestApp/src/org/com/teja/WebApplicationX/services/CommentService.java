package org.com.teja.WebApplicationX.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Comment;
import org.com.teja.WebApplicationX.model.Message;

public class CommentService
{
  private Map<Integer, Message> messagesmap = Dao.getMessageMap();
  
  public List<Comment> getMessageComments(Integer messageId)
  {
    Map<Integer, Comment> CommentsMapOfMessage = ((Message)this.messagesmap.get(messageId)).getCommentsMap();
    return new ArrayList(CommentsMapOfMessage.values());
  }
  
  public Comment getACommentOfMessage(Integer messageId, Integer commentId)
  {
    Map<Integer, Comment> CommentsMapOfMessage = ((Message)this.messagesmap.get(messageId)).getCommentsMap();
    return (Comment)CommentsMapOfMessage.get(commentId);
  }
  
  public Comment addComment(Integer messageId, Comment comment)
  {
    Map<Integer, Comment> CommentsMapOfMessage = ((Message)this.messagesmap.get(messageId)).getCommentsMap();
    List<Integer> deleteList = ((Message)this.messagesmap.get(messageId)).getCommentDeleteList();
    if (messageId.intValue() == 0) {
      return null;
    }
    if (deleteList.isEmpty())
    {
      comment.setCommentid(Integer.valueOf(CommentsMapOfMessage.size() + 1));
      CommentsMapOfMessage.put(comment.getCommentid(), comment);
      return comment;
    }
    comment.setCommentid((Integer)deleteList.get(0));
    CommentsMapOfMessage.put(comment.getCommentid(), comment);
    deleteList.remove(0);
    return comment;
  }
  
  public Comment updateComment(Integer messageId, Comment comment)
  {
    Map<Integer, Comment> CommentsMapOfMessage = ((Message)this.messagesmap.get(messageId)).getCommentsMap();
    if (comment.getCommentid().intValue() <= 0) {
      return null;
    }
    CommentsMapOfMessage.put(comment.getCommentid(), comment);
    return comment;
  }
  
  public Comment deleteComment(Integer messageId, Integer commentId)
  {
    Map<Integer, Comment> CommentsMapOfMessage = ((Message)this.messagesmap.get(messageId)).getCommentsMap();
    Comment deletedComment = (Comment)CommentsMapOfMessage.remove(commentId);
    List<Integer> deleteList = ((Message)this.messagesmap.get(messageId)).getCommentDeleteList();
    deleteList.add(commentId);
    return deletedComment;
  }
}
