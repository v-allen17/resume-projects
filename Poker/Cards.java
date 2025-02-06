// Card.java
// Victoria Allen
// This program creates cards for the deck class

public class Card implements Comparable<Card>{
	
    private int suit;
    private int rank;
	
    public Card(int s, int r){
        suit = s;
        rank = r;
    }
	
    public int compareTo(Card c){
        if (rank == c.getRank()){
            return suit - c.getSuit();
        }
        return rank - c.getRank();     
    }
	
    public int getSuit(){
        return suit;
    }

    public int getRank(){
        return rank;
    }

    public String toString(){
        String [] cardSuites = {"Diamonds", "Clubs", "Spades", "Hearts"};
        String [] cardRanks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "King", "Queen", "Ace"};
        return cardRanks[rank - 1] + " of " + cardSuites[suit - 1];    
    }

}
