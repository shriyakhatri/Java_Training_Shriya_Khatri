package com.ct;
import java.util.Scanner;
public class Assign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String[] s1= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		System.out.println("Enter a number");
		int n1=sc.nextInt();
		if(n1<100)
		{
			System.out.println(s1[n1/10]+" "+s1[n1%10]);
		}
		else
		{
			int no2=n1%100;
			System.out.println(s1[n1/100]+" "+s1[no2/10]+" "+s1[no2%10]);
			
		}
	}

}
