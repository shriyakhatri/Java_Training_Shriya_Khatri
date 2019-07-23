package com.ct;

public class Radio extends Device {

	public void change_channel()
	{
		System.out.println("channel frequency is adjusted");
		
	}
	public void increment_volume()
	{
		System.out.println("volume incremented");
		
	}
	public void decrement_volume()
	{
		System.out.println("volume decremented");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		Radio r1 = new Radio();
		r1.change_channel();
		r1.on();
		r1.off();
		
		
	}

}
