package com.revature;

public class Driver {

	public static void main(String[] args) {
		// "Hello Java" is a String literal.
		String s1 = "Hello Java";
		String s2 = "Hello Java";
		String s3 = "hello java";
		String s4 = new String("Hello Java");

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1.equals(s4));

		System.out.println("================================");

		System.out.println(s1.toLowerCase().equals(s3));
		System.out.println(s1.equals(s3));
		s1 = s1.toLowerCase();
		System.out.println(s1.equals(s3));

		System.out.println("=================================");

		System.out.println(s2.charAt(2));
		// System.out.println(s2.charAt(-1));
		// System.out.println(s2.charAt(11));

		System.out.println("=================================");

		for (int i = 0; i < s2.length(); ++i) {
			System.out.println(s2.charAt(i));
		}

		System.out.println(s1.concat(" " + s2));
		
		String s5 = s1.concat(" ").concat(s2);
		System.out.println(s5);
		
		String sub = s1.substring(2, 7);
		System.out.println(sub);
		sub = s1.substring(2, s1.length()-1);
		System.out.println(sub);
		
		System.out.println("=================================");
		String[] arr = s1.split(" ");
		
		for(int i=0; i<arr.length; ++i) {
			System.out.println(arr[i]);
		}
		
		char[] arr2=s1.toCharArray();
		
		for(int i =0; i<arr2.length; ++i) {
			System.out.println(arr2[i]);
		}

		
	}
}
