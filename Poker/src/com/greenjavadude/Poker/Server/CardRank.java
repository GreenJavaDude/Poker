package com.greenjavadude.Poker.Server;

public enum CardRank {
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
	
	private int num;
	
	private CardRank(int i){
		num = i;
	}
	
	public int getRank(){
		return num;
	}
	
	public String toString() {
		int value = num;
		switch (value) {
		case 1: return "A";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return null;
		}
	}
}