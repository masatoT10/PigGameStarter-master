package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int id = 0;
    private int playerScore0;
    private int playerScore1;
    private int currentT;
    private int currentV;

    public PigGameState (){
        int id = 0;
        int playerScore0 = 0;
        int playerScore1 = 0;
        int currentT = 0;
      int currentV =0;

    }

    public PigGameState(PigGameState pgs) {
        this.id = pgs.getId();
        this.currentT = pgs.getCurrentT();
        this.playerScore1 = pgs.getPlayerScore1();
        this.playerScore0 = pgs.getPlayerScore0();
        this.currentV = pgs.getCurrentV();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerScore0() {
        return playerScore0;
    }

    public void setPlayerScore0(int playerScore0) {
        this.playerScore0 = playerScore0;
    }

    public int getPlayerScore1() {
        return playerScore1;
    }

    public void setPlayerScore1(int playerScore1) {
        this.playerScore1 = playerScore1;
    }

    public int getCurrentT() {
        return currentT;
    }

    public void setCurrentT(int currentT) {
        this.currentT = currentT;
    }

    public int getCurrentV() {
        return currentV;
    }

    public void setCurrentV(int currentV) {
        this.currentV = currentV;
    }
}
