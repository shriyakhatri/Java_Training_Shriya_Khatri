package com.ct;
import java.util.Scanner;
public class Assign3 {

	static int sum = 0;
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a number");
	int n1=sc.nextInt();
	int res = calSum(n1);
	System.out.println(res);
	
	
//	while(n1!=0) {
//		int digit = n1%10;
//		sum = sum + digit;
//		n1 = n1/10;
//		}
	}

static int calSum(int no) {
	while(no!=0) {
		int digit = no%10;
		sum = sum + digit;
		no = no/10;
		}
	if (sum>9) {
		int sum1=sum;
		sum=0;
	 calSum(sum1);
	}

	return sum;
}

}
