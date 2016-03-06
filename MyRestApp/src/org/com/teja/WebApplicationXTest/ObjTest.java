package org.com.teja.WebApplicationXTest;

import static org.junit.Assert.*;

import org.com.teja.WebApplicationX.model.Message;

import org.junit.Test;

public class ObjTest {


	@Test
	public void test() {
		assertEquals(new Message(Integer.valueOf(1), "hi there, how are you?", "Teja").toString(),
				new Message(Integer.valueOf(1), "hi there, how are you?", "Teja").toString());
	}

}
