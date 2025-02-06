// This class represents a computer
// player in the Odd and Even game
// ComputerPlayer.java
// Victoria Allen

import java.util.Random;

public class ComputerPlayer{
    private double t;
    private int tokenBalance;
    private double compT;
    
    public ComputerPlayer(){

        t = 0.5;
        tokenBalance = 0;
    }
    
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
