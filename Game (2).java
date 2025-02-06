// Game.java
// Victoria Allen
// vca2102
// This program impliments the actual game part 
// of the poker game. It follows the directions
// in the README.md.

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
    private Player p;
    private Deck cards;
    private ArrayList<Card> hand;
	
	
    public Game(String[] testHand){
        hand = new ArrayList<>();
        for (String cardType : testHand){
            int cardSuit = getCardSuitIndex(cardType.charAt(0));
            int cardRank = Integer.parseInt(cardType.substring(1));
            Card newCard = new Card(cardSuit, cardRank);
            hand.add(newCard);
        }
    }
	
    public Game(){
		cards = new Deck();
        hand = new ArrayList<>();
        p = new Player();
    }
	
    public void play(){
        Scanner in = new Scanner(System.in);
        boolean continuePlaying = true;
        while (continuePlaying){
            System.out.println("Bet 1-5 tokens: ");
            int playerBet = in.nextInt();
            in.nextLine();
            if (playerBet > 5){
                System.out.println("Invalid, try again.");
                continue;
            }
            if (playerBet < 1){
                System.out.println("Invalid, try again.");
                continue;
            }
            p.bets(playerBet);
            cards.shuffle();
            hand.clear();
            for (int i=0; i < 5; i++) {
                Card dealtCard = cards.deal();
                hand.add(dealtCard);
            }
            System.out.println("Your current hand is: " + hand);
            System.out.println("Would you like to replace any cards?");
            System.out.println("If so, enter cards by position (like 1 2 3).");
            System.out.println("For no change, enter 0: ");
            String replacement = in.nextLine();
            if (!replacement.equals("0")) {
                String [] placement = replacement.split(" ");
                for (String newPlacement : placement) {
                    int index = Integer.parseInt(newPlacement) - 1;
                    Card newCard = cards.deal();
                    hand.set(index, newCard);
                }
                System.out.println("Your updated hand is: " + hand);
            }
            int playerWinnings = playerBet * checkHand();
            p.winnings(playerWinnings);
            System.out.println("Your winnings: " + playerWinnings);
            System.out.println("Current bankroll: " + p.getBankroll());
            System.out.println("Play again?: ");
            String answer = in.nextLine();
            if (answer.equals("no")) {
                continuePlaying = false;
            } 
        }     
    }
    
    public void testPlay(){
        System.out.println("Hand for testing: " + hand);
        System.out.println("Multiplier: " + checkHand());

    }
	
	public int checkHand(){
        if (royalFlush(hand) == true) {
            System.out.println("Royal Flush!");
            return 250;
        }
        else if (straightFlush(hand) == true) {
            System.out.println("Straight Flush");
            return 50; 
        }
        else if (fourOfAKind(hand) == true) {
            System.out.println("Four of a Kind");
            return 25;
        }
        else if (fullHouse(hand) == true) {
            System.out.println("Full House");
            return 6;
        }
        else if (flush(hand) == true) {
            System.out.println("Flush");
            return 5;
        }
        else if (straight(hand) == true) {
            System.out.println("Straight");
            return 4;
        }
        else if (threeOfAKind(hand) == true) {
            System.out.println("Three of a Kind");
            return 3;
        }
        else if (twoPairs(hand) == true) {
            System.out.println("Two pairs");
            return 2;
        }
        else if (onePair(hand) == true) {
            System.out.println("One pair");
            return 1;
        }
        else {
            System.out.println("No pair");
            return 0;
        }
    } 
    
    private boolean royalFlush(ArrayList<Card> hand) {
        boolean handIsStraightFlush = straightFlush(hand);
        boolean handStartsWithTen = hand.get(0).getRank() == 10;
        return handIsStraightFlush && handStartsWithTen;
    }

    private boolean straightFlush(ArrayList<Card> hand) {
        boolean handIsStraight = straight(hand);
        boolean handIsFlush = flush(hand);
        return handIsStraight && handIsFlush;
    }

    private boolean fourOfAKind(ArrayList<Card> hand) {
        int[] rankCounts = new int[14];
        for (Card card : hand) {
            rankCounts[card.getRank()]++;
        }
        for (int count : rankCounts) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }
    private boolean fullHouse(ArrayList<Card> hand) {
        return (hand.get(0).getRank() == hand.get(2).getRank() &&
        hand.get(3).getRank() == hand.get(4).getRank()) ||
        (hand.get(0).getRank() == hand.get(1).getRank() &&
        hand.get(2).getRank() == hand.get(4).getRank());
    }

    private boolean flush(ArrayList<Card> hand) {
        int cardSuit = hand.get(0).getSuit();
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getSuit() != cardSuit) {
                return false;
            }
        }
        return true;
    }

    private boolean straight(ArrayList<Card> hand) {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() != hand.get(i-1).getRank() + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean threeOfAKind(ArrayList<Card> hand) {
        int[] countForRank = new int[14];
        for (Card card : hand) {
            countForRank[card.getRank()]++;
        }
        for (int count : countForRank) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean twoPairs(ArrayList<Card> hand) {
        int count = 0;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() == hand.get(i-1).getRank()) {
                count++;
                i++;
            }
        }
        return count == 2;
    }

    private boolean onePair(ArrayList<Card> hand) {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() == hand.get(i-1).getRank()) {
                return true;
            }
        }
        return false;
    }

    private int getCardSuitIndex(char characterOfSuit) {
        switch (characterOfSuit) {
            case 'c':
                return 1;
            case 'd':
                return 2;
            case 'h':
                return 3;
            case 's':
                return 4;
            default:
                return -1;
        }
    }
}
