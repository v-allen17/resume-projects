/**
 * Game.java
 *
 * name: Victoria Allen
 * uni: vca2102
 *
 * This class represents the Odd-Even game
 * This program runs the odd even game
 * for both a human vs. computer 
 * and computer vs. computer.
 * It follows the instructions
 * of the assignment.
 * 
 */
import java.util.Scanner;

public class Game{

    private int playerOneTokens;
    private int playerTwoTokens;
    private ComputerPlayer computerPlayer;
    private boolean playGame;
    private boolean even;
    private String playerType;
    private int computerScore;
    private int playerScore;
    private int computer1Tokens;
    private int computer2Tokens;
    private double valueOne;
    private double valueTwo;
    
/* this version of the game constructor is for Part 1
 * it takes no parameters 
 */  
    public Game(){

        computerPlayer = new ComputerPlayer();
        playerOneTokens = 0;
        playerTwoTokens = 0;
        computer1Tokens = 0;
        computer2Tokens = 0;
        playGame = true;
        even = true;
        valueOne  = 0.0;
        valueTwo = 0.0;
    }

    //asks for human move and returns result

    public int humanMove(Scanner scanner){

        System.out.println("Declare 'one' or 'two': ");
        String choice = scanner.next();
        if(choice.equals("one")){
            return 1;
        }    
        else{
            return 2;
        }
    }
    
/* this version of the game constructor is for Part 2
 * It requires two doubles as parameters. You will use 
 * these to set the initial thresholds for you computer players 
 */
    public Game (double t1, double t2){
        valueOne = t1;
        valueTwo = t2;
    }


    
/* 
* This method is for Part 1
* This method should play one complete interactive session
* of odd-even until the user wishes to quit. 
*/
    public void playSession(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game!");
        System.out.println("Please choose to be the 'odd' or 'even' player: ");
        playerType = scanner.next();

        while (playGame == true){

            int human = humanMove(scanner);
            int computer = computerPlayer.move();
            int numberSum = human + computer;

            System.out.println("Your move: " + human);
            System.out.println("Computer move: " + computer);
            System.out.println("Sum: " + numberSum);

            if (numberSum % 2 != 0){
                playerOneTokens += numberSum;
                playerTwoTokens -= numberSum;
            }
            else{
                playerOneTokens -= numberSum;
                playerTwoTokens += numberSum;
            }

            System.out.println("Play again?: ");
            String again = scanner.next();

            if (again.equals("no")){
                break;
            }
        }

        int test = oddOrEven();

        System.out.println("Your final score: " + playerScore);
        System.out.println("Computer's final score: " + 
        computerPlayer.getScore(computerScore));
    
    }
    
    
/*
 * This method is for Part 2
 * It takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played 
 */
    public void play(int games){
        for (int i = 0; i < games; i++){
            ComputerPlayer playerOne = new ComputerPlayer(valueOne);
            ComputerPlayer playerTwo = new ComputerPlayer(valueTwo);
                
            int playerOneMove = playerOne.compMove();
            int playerTwoMove = playerTwo.compMove();
            int sum = playerOneMove + playerTwoMove;

            if (sum % 2 != 0){
                computer1Tokens += sum;
                computer2Tokens -= sum;
            }
            else{
                computer1Tokens -= sum;
                computer2Tokens += sum;
            }
        }
    }

/* this method should return the current score (number of tokens)
 * that player 1 has 
 */
    public int getP1Score(){
        return computer1Tokens;      
    }
    
/* this method should return the current score (number of tokens)
 * that player 2 has
 */
    public int getP2Score(){
        return computer2Tokens; 
    }  
    
    
    // you may or may not want more methods here:
    // This method determines if the player is 
    // the odd or even player
    
    public int oddOrEven(){
        if (playerType.equals("odd")){
            even = false;
        }
        if (even == true){
            computerScore = computerPlayer.getScore(playerOneTokens);
            playerScore = playerTwoTokens;
        }
        else{
            computerScore = computerPlayer.getScore(playerTwoTokens);
            playerScore = playerOneTokens;
        }

         return computerScore;
    }
}