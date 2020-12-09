package com.sc.lambdas;

import java.security.MessageDigest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnOneListener oneListener = new OnOneListener() {
			
			@Override
			public void onOne(String message, String message2) {
				// TODO Auto-generated method stub
				System.out.println(message + ": " + message2);
			}
		};
		
		OnOneListener oneListener2 = (String message, String message2) -> {
			System.out.println(message + ": " +  message2);
		};
		
		OnOneListener oneListener3 = (message, message2) -> System.out.println(message + ": " +  message2);
		
		oneListener.onOne("One", "Sin lambda :(");
		
		oneListener2.onOne("Two","Con Lambda :)");
		
		oneListener3.onOne("Trhee","Lambda como Variable");
		
		//forEach (System.out::println); 
	}

}
