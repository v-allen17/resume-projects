// Game.java
// Victoria Allen
// This class represents the game

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
    
    public Game (double t1, double t2){
        valueOne = t1;
        valueTwo = t2;
    }

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

/* this method returns the current score (number of tokens)
 * that player 1 has 
 */
    public int getP1Score(){
        return computer1Tokens;      
    }
    
/* this method returns the current score (number of tokens)
 * that player 2 has
 */
    public int getP2Score(){
        return computer2Tokens; 
    }  
    
    
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
