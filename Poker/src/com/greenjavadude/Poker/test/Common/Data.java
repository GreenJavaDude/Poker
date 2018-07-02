package com.greenjavadude.Poker.test.Common;

public class Data {
	//holder class for message or turn request or turn result
	private String text;
	private String type;
	
	//for the message
	public Data(String s) {
		text = s;
		type = "M";
	}
	
	/*
	//for the turn request
	public Data() {
		type = "Q";
	}
	
	//for the turn result
	public Data() {
		type = "A";
	}
	*/
	
	public String getText() {
		return text;
	}
	
	public String getType() {
		return type;
	}
}