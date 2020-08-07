package com.revature;

public class Driver {

	public static void main(String[] args) {
		String s = "Hello Strings";
		
		//s = s.concat("builder, It is a lovely day in the office.");
		
		
		StringBuilder sb = new StringBuilder(s);
		
		System.out.println(sb);
		
		sb.append("builder, It is a lovely day in the office.");

		sb.delete(20, sb.length());
		System.out.println(sb);
		System.out.println(s);
		
		sb.reverse();
		System.out.println(sb);
		
		s = new String(sb.reverse());
		System.out.println(s);
		
//		sb = new StringBuilder("new password");
		System.out.println("====================================");
		
		User u = new User();
		u.name= "Tim";
		u.userId= 111;
		u.username = "TrainerTim";
		
		StringBuilder output = new StringBuilder();
		
		output.append("Hello, "+u.name+", please give me your user name?");
		
		System.out.println(output);
		
		output.delete(output.length()-30, output.length());
		output.append("your username is "+u.username+" and userid is "+u.userId);
		
		System.out.println(output);

	}

}

class User {
	public String username;
	public String name;
	public int userId; 
}
