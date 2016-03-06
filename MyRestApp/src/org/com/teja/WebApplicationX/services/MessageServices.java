package org.com.teja.WebApplicationX.services;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Message;

public class MessageServices
{
  public static Map<Integer, Message> messageservieceMap = Dao.getMessageMap();
  public List<Integer> deleteList = Dao.getDeletedMessageList();
  
  public Map<Integer, Message> getAllMessages()
  {
    return messageservieceMap;
  }
  
  public List<Message> getMessagesFromYear(int Year)
  {
    List<Message> messagesbyYear = new ArrayList();
    Calendar calendar = Calendar.getInstance();
    for (Message message : messageservieceMap.values())
    {
      calendar.setTime(message.getCreateDate());
      if (calendar.get(1) == Year) {
        messagesbyYear.add(message);
      }
    }
    return messagesbyYear;
  }
  
  public List<Message> getMessagesbyPagination(int start, int size)
  {
    ArrayList<Message> messagesbyPaginationlist = new ArrayList(messageservieceMap.values());
    
    return messagesbyPaginationlist.subList(start, start + size);
  }
  
  public Message getMessage(Integer id)
  {
    return (Message)messageservieceMap.get(id);
  }
  
  public Message addMessage(Message message)
  {
    if (this.deleteList.isEmpty())
    {
      message.setId(Integer.valueOf(messageservieceMap.size() + 1));
    }
    else
    {
      message.setId((Integer)this.deleteList.get(0));
      this.deleteList.remove(0);
    }
    message.setCreateDate();
    
    messageservieceMap.put(message.getId(), message);
    return message;
  }
  
  public Message updateMessage(Message message)
  {
    if (message.getId().intValue() <= 0) {
      return null;
    }
    messageservieceMap.put(message.getId(), message);
    return message;
  }
  
  public Message deleteMessage(Integer Id)
  {
    messageservieceMap.remove(Id);
    this.deleteList.add(Id);
    //System.out.println(this.deleteList);
    return new Message(Id,"unkown", "unkown");
  }
  
  public void getservices()
  {
    messageservieceMap.put(Integer.valueOf(1), new Message(Integer.valueOf(1), "hi there, how are you?", "Teja"));
    messageservieceMap.put(Integer.valueOf(2), new Message(Integer.valueOf(2), "I am Fine, How about you?", "Ravi"));
    messageservieceMap.put(Integer.valueOf(3), new Message(Integer.valueOf(3), "I am Great, Lets Starts ", "Teja"));
    messageservieceMap.put(Integer.valueOf(4), new Message(Integer.valueOf(4), "UNWANTED Conversation", "JVM"));
    messageservieceMap.put(Integer.valueOf(5), new Message(Integer.valueOf(5), "what the heck is this man!", "TomCat"));
    messageservieceMap.put(Integer.valueOf(6), new Message(Integer.valueOf(6), "ITs OK.....!", "Developer"));
  }
}
