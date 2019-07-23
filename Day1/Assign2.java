package com.ct;

import java.util.Scanner;

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s1 = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] s2 = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen" };
		String[] s3 = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
				"Hundred" };
		System.out.println("Enter a number");
		int n1 = sc.nextInt();
		if (n1 > 10 && n1 < 20) {
			System.out.println(s2[n1 % 10 - 1]);
		}
		
		//less than 100
		if (n1 < 100) {
			if (n1 % 10 == 0) {
				System.out.println(s3[n1 / 10 - 1]);
			} else {
				System.out.println(s3[n1 / 10 - 1] + " " + s1[n1 % 10]);
			}
		}
		else {
			// int n2=n1%100;
			if (n1 % 100 == 0) {
				System.out.println(s1[n1 / 100] + " " + "Hundred");
			}
			else {
			if (n1 % 10 == 0) {
				System.out.println(s1[n1 / 100] + " " + "Hundred and " + s3[(n1 % 100) / 10 - 1]);
			} else {
				if (n1 % 100 < 20 && n1 % 100 > 10) {
					System.out.println(s1[n1 / 100] + " " + "Hundred and " + s2[n1 % 10 - 1]);
				} else {
					System.out.println(
							s1[n1 / 100] + " " + "Hundred and " + s3[(n1 % 100) / 10 - 1] + " " + s1[(n1 % 100) % 10]);
				}
			}
		}
		}

	}
}
