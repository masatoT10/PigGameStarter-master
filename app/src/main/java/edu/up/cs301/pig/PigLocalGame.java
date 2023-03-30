package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState pigGameState = new PigGameState();

    Random random = new Random();
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pigGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this
        if(playerIdx == pigGameState.getId()) {
            return true;
        }
        else { return false;}
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigHoldAction){
            if (pigGameState.getId() == 0) {
                pigGameState.setPlayerScore0(pigGameState.getCurrentT() + pigGameState.getPlayerScore0());
            }
            else if (pigGameState.getId() == 1) {
                pigGameState.setPlayerScore1(pigGameState.getCurrentT() + pigGameState.getPlayerScore1());
            }
            if(players.length>0) {
                pigGameState.setId(1);
            }
            changePlayer();
            pigGameState.setCurrentT(0);

            return true;
        }
        if (action instanceof PigRollAction) {
            pigGameState.setCurrentV(random.nextInt(6)+1);
            if (pigGameState.getCurrentV() == 1) {
                pigGameState.setMsg(""+playerNames[pigGameState.getId()]+ " lost all their points : (")
                pigGameState.setCurrentT(0);
               changePlayer();
                pigGameState.setCurrentT(0);
            }
            else {
                pigGameState.setId(pigGameState.getCurrentV() + pigGameState.getCurrentT());
            }
            return true;
        }
        return false;
    }//makeMove

    public void changePlayer() {
        if (players.length == 1) {
        }
        else if (players.length == 2) {
            if (pigGameState.getId() == 0) {
                pigGameState.setId(1);
            }
            if (players.length == 1){
                pigGameState.setId(0);
            }
        }
    }

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState pgs = new PigGameState();

        p.sendInfo(pgs);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method

        if (pigGameState.getPlayerScore0() >= 50) {
                return "Player 1 won with a score " + pigGameState.getPlayerScore0();
        } else if (pigGameState.getPlayerScore1() >= 50) {
            return "Player 2 won with a score " + pigGameState.getPlayerScore1();
        }

        return null;
    }

}// class PigLocalGame
