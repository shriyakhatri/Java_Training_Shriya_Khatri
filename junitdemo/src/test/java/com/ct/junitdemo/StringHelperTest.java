package com.ct.junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions() {
		
		
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testTruncateAInFirst2Positions2() {
		
		
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
		
		
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		
		
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		
		
	}
	
}