package com.ct;

public class Projector extends Device{
	
	public void adjust_brightness() {
		System.out.println("brightness adjusted");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Projector p1 =new Projector();
		p1.on();
		p1.adjust_brightness();
		
	}

}
