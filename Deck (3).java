// Deck.java
// Victoria Allen
// vca2102
// This program simulates all the functions of a deck for
// a poker game like shuffling and dealing

import java.util.Arrays;
import java.util.Random;

public class Deck {
	
    private Card[] cards;
    private int top; 
	
    public Deck(){
        cards = new Card[52];
        int count = 0;
        for(int suit = 1; suit <= 4; suit++){
            for(int rank = 1; rank <= 13; rank++){
                cards[count] = new Card(suit, rank);
                count++;
            }
        }
        top = 0;
    }
	
    public void shuffle(){
        Random r = new Random();
        for(int i = 0; i < cards.length; i++){
            int deckShuffle = r.nextInt(cards.length);
            Card location = cards[i];
            cards[i] = cards[deckShuffle];
            cards[deckShuffle] = location;
        }
        top = 0;
    }
    
    public Card deal(){ 
        return cards[top++];
    }
	
    public String toString(){
        StringBuilder buildString = new StringBuilder();
        for(Card card : cards){
            buildString.append(card.toString()).append("\n");
        }
        return buildString.toString();
    }

}
