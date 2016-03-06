package org.com.teja.WebApplicationX.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Comment;
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
@PrepareForTest({ Dao.class, CommentService.class })
public class CommentServiceTest {
	private Map<Integer, Message> messagesTestMap;
	private CommentService commentService;

	@Before
	public void setUp() throws Exception {
		messagesTestMap = new HashMap<Integer, Message>();
		messagesTestMap.put(Integer.valueOf(1), new Message(Integer.valueOf(1), "hi there, how are you?", "Teja"));
		messagesTestMap.put(Integer.valueOf(2), new Message(Integer.valueOf(2), "I am Fine, How about you?", "Ravi"));
		PowerMock.mockStatic(Dao.class);
		EasyMock.expect(Dao.getMessageMap()).andReturn(messagesTestMap).anyTimes();

	}

	@Test
	public void getMessageCommentsTest() {

		PowerMock.replay(Dao.class);
		commentService = new CommentService();
		assertEquals(messagesTestMap.get(Integer.valueOf(1)).getCommentsMap().get(1).toString(),
				commentService.getMessageComments(Integer.valueOf(1)).get(0).toString());
		PowerMock.verify(Dao.class);

	}

	@Test
	public void getACommentOfMessageTest() {
		PowerMock.replay(Dao.class);
		commentService = new CommentService();
		assertEquals(messagesTestMap.get(Integer.valueOf(1)).getCommentsMap().get(1).toString(),
				commentService.getACommentOfMessage(Integer.valueOf(1), Integer.valueOf(1)).toString());
		PowerMock.verify(Dao.class);
	}

	@Test
	public void addCommentTest() {
		PowerMock.replay(Dao.class);
		commentService = new CommentService();
		assertEquals(new Comment(Integer.valueOf(9), "New Comment", "teja").toString(), commentService
				.addComment(Integer.valueOf(1), new Comment(Integer.valueOf(1), "New Comment", "teja")).toString());
		PowerMock.verify(Dao.class);
	}

	@Test
	public void updateCommentTest() {
		PowerMock.replay(Dao.class);
		commentService = new CommentService();
		assertEquals(new Comment(Integer.valueOf(2), "Comment Update Test", "teja").toString(), commentService
				.updateComment(Integer.valueOf(1), new Comment(Integer.valueOf(2), "Comment Update Test", "teja"))
				.toString());
		// System.out.println(commentService.getMessageComments(Integer.valueOf(1)).get(1));
		PowerMock.verify(Dao.class);
	}

	@Test
	public void deleteCommentest() {
		PowerMock.replay(Dao.class);
		commentService = new CommentService();
		commentService.deleteComment(Integer.valueOf(1), Integer.valueOf(1));
		assertFalse(commentService.getMessagesmap().get(Integer.valueOf(1)).getCommentsMap()
				.containsKey(Integer.valueOf(1)));
		// System.out.println(commentService.getMessageComments(Integer.valueOf(1)).get(1));
		PowerMock.verify(Dao.class);
	}

	@After
	public void tearDown() throws Exception {
		PowerMock.reset(Dao.class);
		messagesTestMap = null;
		commentService = null;

	}

}
