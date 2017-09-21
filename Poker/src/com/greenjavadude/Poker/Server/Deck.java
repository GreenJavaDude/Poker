package com.greenjavadude.Poker.Server;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;
	
	public Deck() {
		for(CardSuite s : CardSuite.values()) {
			for(CardRank r: CardRank.values()) {
				Card c = new Card(s, r);
				deck.push(c);
			}
		}
		
		shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card drawCard() {
		return deck.pop();
	}
}