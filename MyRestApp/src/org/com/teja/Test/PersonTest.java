package org.com.teja.Test;

import static org.junit.Assert.*;

import org.com.teja.WebApplicationX.model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	

	@Test
	public void test() {
		assertEquals(
				new Message(1, "hi there, how are you?", "Teja"),
				new Message(1, "hi there, how are you?", "Teja")
				);
	}
		

}
