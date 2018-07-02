package com.greenjavadude.Poker.test.Server;

import java.util.ArrayList;

public class Player {	
	private int amount;
	private ArrayList<Card> cards;
	
	public Player(int i) {
		amount = i;
		cards = new ArrayList<Card>();
	}
	
	public void add(int i) {
		amount += i;
	}
	
	//TODO
	public boolean remove(int i) {
		if(amount >= i) {
			amount -= i;
			return true;
		}else {
			return false;
		}
	}
	
	public int getMoney() {
		return amount;
	}
	
	public void setCards(ArrayList<Card> c) {
		cards = c;
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}