// Player.java
// Victoria Allen
// This program controls everything that has to
// with how much the player bets, wins, loses, 
// and the amount in the bank. It is basically
// a simulated bank account for the game.

public class Player {
			
    private int bankroll;
    private int bet;
		
    public Player(){
        bet = 0;		
        bankroll = 100;
    }
		
    public void bets(int amt){
        bet = amt;
        bankroll -= bet;
    }

    public void winnings(int odds){
        bankroll += odds;
    }

    public int getBankroll(){
        return bankroll;
    }

}


