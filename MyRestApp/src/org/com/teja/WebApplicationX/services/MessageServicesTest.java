package org.com.teja.WebApplicationX.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Message;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Dao.class, MessageServices.class})
public class MessageServicesTest {
	public static Map<Integer, Message> messageservieceMap;
	MessageServices  ms;
	

	@Before
	public void setUp() throws Exception {
	
		messageservieceMap = new HashMap<Integer, Message>();
		messageservieceMap.put(Integer.valueOf(1), new Message(Integer.valueOf(1), "hi there, how are you?", "Teja"));
	    messageservieceMap.put(Integer.valueOf(2), new Message(Integer.valueOf(2), "I am Fine, How about you?", "Ravi"));	
	    PowerMock.mockStatic(Dao.class);
	     EasyMock.expect(Dao.getMessageMap()).andReturn(messageservieceMap).anyTimes();
	     EasyMock.expect(Dao.getDeletedMessageList()).andReturn(new ArrayList<Integer>());
		PowerMock.replay(Dao.class);
		ms = new MessageServices();
	}
	

	@Test
	public void AllMessagesTest() {
		 
		
		assertEquals(ms.getAllMessages().get(Integer.valueOf(1)).getAuthor(),messageservieceMap.get(Integer.valueOf(1)).getAuthor());
		PowerMock.verify(Dao.class);
		
	}
	@Test 
	public void getMessageTest(){
		assertEquals(ms.getMessage(1).getMessage(), "hi there, how are you?");
		
	}
	
	@Test
	public void addMessageTest(){
		assertEquals(ms.addMessage(new Message(Integer.valueOf(3), "hi there, how are you?", "Teja")).getId(), Integer.valueOf(3));
		
	}
	@Test
	public void getMessagebyYearTest(){
		assertEquals(ms.getMessagesFromYear(2015), new ArrayList<Message>());
	}
	@Test
	public void deletemessageTest(){
		
		ms.deleteMessage(1);
		
		assertFalse(ms.messageservieceMap.containsKey(Integer.valueOf(1)));
	}
	@Test
	public void equalsObjCheck(){
		assertEquals(new Message(Integer.valueOf(1), "hi there, how are you?", "Teja").toString(),
				new Message(Integer.valueOf(1), "hi there, how are you?", "Teja").toString());
	}
	@After
	public void cleanUp(){
		
		PowerMock.reset(Dao.class);
		messageservieceMap = null;
		ms = null;
		 
	}

}
