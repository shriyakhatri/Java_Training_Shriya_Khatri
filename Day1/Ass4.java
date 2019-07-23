package com.ct;

import java.util.Scanner;

public class Ass4 {
	
	public static void main(String[] args) {
	int answer=0;
		Scanner sc = new Scanner(System.in);
	System.out.println("enter num 1");
		int num1= sc.nextInt();
		System.out.println("enter num2");
	int num2= sc.nextInt();
	
		for(int i=0;i<num1;i++)
		{
			
			answer = answer +num2;
			
		}
		
		
	
	System.out.println(""+answer);
	}
}