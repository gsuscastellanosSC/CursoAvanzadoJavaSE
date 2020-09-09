package com.sc.lambdas;

import java.security.MessageDigest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnOneListener oneListener = new OnOneListener() {
			
			@Override
			public void onOne(String message) {
				// TODO Auto-generated method stub
				System.out.println("one: "+ message);
			}
		};
		
		OnOneListener oneListener2 = (String message) -> {
			System.out.println("one: "+ message);
		};
		
		oneListener.onOne("Sin lambda :(");
		
		oneListener2.onOne("Con Lambda :)");
	}

}
