package com.greenjavadude.Poker.test.Server;

public class Card {
	private CardSuite suite;
	private CardRank rank;
	
	public Card(CardSuite s, CardRank r){
		rank = r;
		suite = s;
	}
	
	public CardSuite getSuite(){
		return suite;
	}
	
	public CardRank getRank(){
		return rank;
	}
}