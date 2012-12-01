package com.example.strategotesting;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The model for the board based on a 2D GamePiece array.
 *
 * @author Brandon Dean, Jordan Sablan, Matt Morrison, Jaime Dalrymple
 * @version Nov 10, 2012
 */
public class GameboardModel
{
    private GamePiece[][] board;
    private ArrayList<GamePiece>   bluePieces;
    private ArrayList<GamePiece>   redPieces;
    private int           size = 10;
    private boolean       isGameOver;


    // ----------------------------------------------------------
    /**
     * A 2D array simulating the 10x10 board is created.
     */
    public GameboardModel()
    {
        board = new GamePiece[size][size];
        isGameOver = false;
        bluePieces = new ArrayList<GamePiece>();
        redPieces = new ArrayList<GamePiece>();
    }


    /**
     * Sets a piece on the board in the set up of the game.
     * @return True if the set is successful, false if it is not.
     * @param x The desired x coordinate of the piece.
     * @param y The desired y coordinate of the piece.
     * @param team The team of the piece.
     * @param rank The rank of the piece.
     */
    public boolean setPiece(int x, int y, int team, int rank)
    {
        GamePiece newPiece = new GamePiece(x, y, team, rank);
        if (board[x][y] == null)
        {
            board[x][y] = newPiece;
            if(team == 0) {
                bluePieces.add(newPiece);
            }
            else {
                redPieces.add(newPiece);
            }
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Handles the movement on the gameboard.
     *
     * @return 0 if the move was successful,-1 if the move was unsuccessful, and
     *         1 if the move resulted in a battle where both pieces died.
     * @param mover
     *            The soldier moving.
     * @param x
     *            The intended x coordinate of the move.
     * @param y
     *            The intended y coordinate of the move.
     */
    public int movement(Soldier mover, int x, int y)
    {
        int oldX = mover.getX();
        int oldY = mover.getY();
        int result = mover.move(x, y);
        if (result == 0)
        {
            if (board[x][y] != null)
            {
                int battleResult = mover.battle(mover, board[x][y]);
                if (battleResult == 1)
                {
                    board[x][y] = mover;
                    board[oldX][oldY] = null;
                    return 0;
                }
                else if (battleResult == -1)
                {
                    board[oldX][oldY] = null;
                    return -1;
                }
                else if (battleResult == 0)
                {
                    board[x][y] = null;
                    board[oldX][oldY] = null;
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }


    /**
     * Simulates the battle mechanic. Accepts the attacking piece and the
     * defending piece and returns a "win," "tie," or "loss."
     *
     * @param attacker
     *            The attacking GamePiece object.
     * @param defender
     *            The GamePiece object being targeted.
     * @return Returns 1 if the attacker won and -1 if the attacker lost and 0
     *         if there was no battle because the two pieces are team mates.
     */
    /*
     * public int battle(GamePiece attacker, GamePiece defender) { if
     * (attacker.getTeam() == defender.getTeam()) { return 5; } else if
     * (attacker.getRank() > 9 || defender.getRank() > 9) { // spy attacking
     * marshal if (attacker.getRank() == 10 && defender.getRank() == 1) { return
     * 1; } // flag is discovered else if (defender.getRank() == 12) { return 1;
     * } // miner attacking bomb else if (attacker.getRank() == 8 &&
     * defender.getRank() == 11) { return 1; // win } } else if
     * (attacker.getRank() < defender.getRank()) { return 1; } else if
     * (attacker.getRank() == defender.getRank()) { return 0; } return -1; }
     */

    // ----------------------------------------------------------
    /**
     * Called when the flag is captured.
     */
    public void gameOver()
    {
        isGameOver = true;
    }

    /**
     * Returns true if the game ends.
     * @return if the game ends.
     */
    public boolean getIsGameOver()
    {
        return isGameOver;
    }

    public boolean redHasSet() {
        if (redPieces.size() == 40) {
            return true;
        }
        else {
            return false;
        }
    }
}
