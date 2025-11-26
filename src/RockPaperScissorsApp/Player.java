package RockPaperScissorsApp;

public class Player {
    String name;
    int score;

    Player(){
        name=null;
        score=0;
    }
    Player(String name){
        this.name=name;
    }

    Player(String name , int score){
        this(name);
        this.score=score;

    }
    void setName(String name){
        this.name=name;
    }
    void setScore(){
        this.score=0;
    }

    void addPoint(){
        score++;
    }

    int getScore(){
        return score;
    }
    String getName(){
        return name;
    }
}
