package com.ct.junitdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizeTest {

	
	StringHelper helper = new StringHelper();

	
	private String input;
	private String output;
	
	public ParameterizeTest(String input, String output) {
		super();
		this.input = input;
		this.output = output;
	}


	@Parameters
	public static Collection<String[]> testconditions()
	{
		String ExpectedValues[][] = {{"AACD", "CD"}, {"ACD", "CD"}};
		
		return Arrays.asList(ExpectedValues);
	}
	
	
	@Test
	public void testTruncateAInFirst2Positions() {
		
		
		assertEquals(output,helper.truncateAInFirst2Positions(input));
		
		
		
		//fail("Not yet implemented");
	}



	/*@Test
	public void testTruncateAInFirst2Positions2() {
		
		
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
		
		
		
		//fail("Not yet implemented");
	}
	
	*/@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		
		
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		
		
	}


}
