package RockPaperScissorsApp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsApp {
    Player humanPlayer;
    Player computerPlayer;
    ArrayList<Round> rounds=new ArrayList<>();;

    int R;

    public void startGame(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Welcome to Rock-Paper-Scissors!\n"+"Please enter your name:");
        String humanNAme=sc.nextLine();

        humanPlayer=new Player(humanNAme,0);
        computerPlayer =new Player("Computer",0);

        System.out.println("Hello, "+humanPlayer.name+"! Let's start the game.");

        Scanner sc1= new Scanner(System.in);

        String condition="y";

        R=0;
        while (condition.equals("y")){
            R++;
            playSingleRound(humanPlayer,computerPlayer,R);

            printScoreBoard(humanPlayer,computerPlayer,condition,R);

            System.out.println("\nDo you want to play another round? (y/n):");
            condition = sc.nextLine();
            while (!(condition.equals("n") || condition.equals("y"))){
                System.out.println("\nPlease enter right answer (y/n) ");
                condition = sc.nextLine();
            }

        }

        printScoreBoard(humanPlayer,computerPlayer,condition,R);

    }

    private void playSingleRound(Player human , Player computer,int R){
        Scanner scan= new Scanner(System.in);

        System.out.println("Choose your move:");
        System.out.println("1) ROCK\n" +
                "2) PAPER\n" +
                "3) SCISSORS\n"+
                "your chose: ");

        int humanNum =scan.nextInt();
        while(!(humanNum==1 ||humanNum==2 ||humanNum==3)){
            System.out.println("\nPlease enter number from above numbers (corresponding to your chose) ");
            humanNum =scan.nextInt();
        }

        String humanMove=null;
        humanMove= switch (humanNum) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> humanMove;
        };
        System.out.println("your chose :" + humanMove);


        Random rand=new Random();
        int randNum= rand.nextInt(3)+1;

        String computerMove=null;
        computerMove= switch (randNum) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> computerMove;
        };
        System.out.println("Computer chose: "+computerMove );

        String result=null;
        int difference=humanNum-randNum;
        //draw
        if (difference==0) {
            result="DRAW";
            System.out.println("Result: it's DRAW");
        }//lose
        else if (difference==-1 ||difference==2 ){
            result="LOSE";
            computer.addPoint();
            System.out.println("Result: You LOSE this round!");
        }//win
        else {
            result="WIN";
            human.addPoint();
            System.out.println("Result: You WIN this round!");
        }


        Round round=new Round();
        round.setRoundNumber(R);
        round.setHumanMove(humanMove);
        round.setComputerMove(computerMove);
        round.setResult(result);

        rounds.add(round);


    }

    private void printScoreBoard(Player human , Player computer , String condition,int R){
        if (condition.equals("y")) {
            System.out.printf("Current score -> You: %d | Computer: %d | Draws: %d ",
                    human.score, computer.score, R - (human.score + computer.score));
        }
        else if (condition.equals("n")){
            System.out.printf("Game over!\n" +
                    "Final score:\n" +
                    "You: %d | Computer: %d | Draws: %d\n" +
                    "Total rounds played: %d",human.score, computer.score, R - (human.score + computer.score) ,R);
        }
    }

    void printHistory(){
        for ( Round r : rounds){
            System.out.println("\n--------------------");
            System.out.printf("Round : %d \n"+
                    "You: %s"+
                    "\nComputer: %s"+
                    "\nResult: %s",r.roundNumber,r.humanMove,r.computerMove,r.result);
        }
    }

}
