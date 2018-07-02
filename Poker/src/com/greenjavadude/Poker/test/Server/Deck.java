package com.greenjavadude.Poker.test.Server;

import java.util.ArrayList;
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
		
		Collections.shuffle(deck);
	}
	/*
	public void shuffle() {
		Collections.shuffle(deck);
	}
	*/
	public Card drawCard() {
		return deck.pop();
	}
	
	public void decide(ArrayList<Person> people, ArrayList<Card> table) {
		Person p = people.get(0);
		for(int i = 1; i<people.size(); i++) {
			//compare people.get(i) to p, best = p
			
			//account for split pot
			
			//per person: table + people.get(i).getCards
		}
		
		//give pot and money, account for possible split pot
	}
	
	private String score(ArrayList<Card> cards) {
		
		//check for common rank: 1 pair, 2 pair, 3 of a kind, 4 of a kind, full house
		
		
		int valstage = 1;
		
		int pairstage = 1;
		
		String pair1 = "";
		String pair2 = "";
		String three = "";
		String four = "";
		
		for (Card c1 : cards) {
			
			
			
			
			
			
			
			for (int i = 1; i<cards.size(); i++) {
				if(c1.getRank().equals(cards.get(i).getRank())) {
					valstage++;
				}
			}
			
			if (valstage == 1) {
				if (pairstage == 1) {
					pair1 = c1.getRank().toString();
					pairstage++;
				}
				if(pairstage == 2) {
					pair2 = c1.getRank().toString();
					//not necessary ++
				}
			}
			valstage = 1;
		}
		
		
		//check full house, all the way at end
		
		
		
		
		//check for best in common rank
		
		
		//check for common suite: flush, straight flush (royal is the best)
		
		//check stairs rank: straight, straight flush (royal is the best)
		
		//give score: each type is ranked on the best card or cards for flush
		
		
		//do check for best combo
		
		String combo = "";
		
		
		
		//string or int or enum?
		return null;
	}
}
























