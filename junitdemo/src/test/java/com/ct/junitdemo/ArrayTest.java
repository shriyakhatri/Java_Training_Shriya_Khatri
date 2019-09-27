package com.ct.junitdemo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayTest {

	@Test
	public void test() {
	 int [] numbers = {4,3,2};
	 int [] expected = {2,3,4};
	 
	 Arrays.sort(numbers);
	 assertArrayEquals(expected, numbers);
	
	
	}

 @Test(expected =NullPointerException.class)
		public void test1() {
		 int [] numbers = null;
		 //int [] expected = {2,3,4};
		 
		 Arrays.sort(numbers);
		// assertArrayEquals(expected, numbers);
		
		
		}


}
