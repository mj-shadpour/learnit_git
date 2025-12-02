package RockPaperScissorsApp;

public class Round {
    int roundNumber;
    String humanMove;
    String computerMove;
    String result;

    public Round(int roundNumber, String humanMove, String computerMove, String result){
        this.roundNumber=roundNumber;
        this.humanMove=humanMove;
        this.computerMove=computerMove;
        this.result=result;
    }
    public Round(String humanMove, String computerMove, String result){
        this(1,humanMove,computerMove,result);
    }
    public Round(String computerMove, String result){
        this(1,null,computerMove,result);
    }
    public Round(String result){
        this(1,null,null,result);
    }
    public Round(){
        this(1,null,null,null);
    }

    void setRoundNumber(int roundNumber){
        this.roundNumber=roundNumber;
    }

    void setHumanMove(String humanMove){
        this.humanMove=humanMove;
    }

    void setComputerMove(String computerMove){
        this.computerMove=computerMove;
    }
    void setResult(String result){
        this.result=result;
    }

    int getRoundNumber(){
        return roundNumber;
    }
    String getHumanMove(){
        return humanMove;
    }
    String getComputerMove(){
        return computerMove;
    }
    String getResult(){
        return result;
    }
}
