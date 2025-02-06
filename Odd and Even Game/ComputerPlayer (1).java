/**
 * This class represents a computer
 * player in the Odd-Even game
 *
 * ComputerPlayer.java
 *
 * name: Victoria Allen
 * uni: vca2102
 *  
 */
import java.util.Random;

public class ComputerPlayer{
    private double t;
    private int tokenBalance; //ONLY PLACE YOU SHOULD TRACK COMPUTER TOKENS!
    private double compT;
    
    /* no-argument constructor for the ComputerPlayer
       This is meant for Part 1 */
    public ComputerPlayer(){

        t = 0.5;
        tokenBalance = 0;
    }
    
    /* Speicfy the desired strategy in this constructor
       This is meant for Part 2 */
    public ComputerPlayer(double threshold){
        compT = threshold;
    }
    
    //determines a move against a human

    public int move(){
        double randomNumber = Math.random();

        if (randomNumber > t){
            return 2;
        }
        else{
            return 1;
        }
    }

    //determines computer score

    public int getScore(int tokens){
        int tokenBalance = tokens;
        return tokenBalance;
    }

    // determines a move against the computer

    public int compMove(){
        double randomNumber = Math.random();

        if (randomNumber > compT){
            return 2;
        }
        else{
            return 1;
        }
    }

}