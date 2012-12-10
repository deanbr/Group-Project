package com.example.strategotesting;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The model for the board based on a 2D GamePiece array.
 *
 * @author Jordan sablan (jordans9)
 * @author Brandon Dean (deanbr)
 * @author Jamie Dalrymple (jamied93)
 * @author Matt Morrison (mattm512)
 * @version Nov 10, 2012
 */
public class GameboardModel
{
    private GamePiece[][]        board;
    private ArrayList<GamePiece> bluePieces;
    private ArrayList<GamePiece> redPieces;
    private int                  size = 10;
    private boolean              isGameOver;


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
     *
     * @return True if the set is successful, false if it is not.
     * @param x
     *            The desired x coordinate of the piece.
     * @param y
     *            The desired y coordinate of the piece.
     * @param team
     *            The team of the piece.
     * @param rank
     *            The rank of the piece.
     */
    public boolean setPiece(int x, int y, int team, int rank)
    {
        GamePiece newPiece;
        if (rank == 9)
        {
            newPiece = new Scout(x, y, team);
        }
        else if (rank == 10)
        {
            newPiece = new Spy(x, y, team);
        }
        else if (rank == 11)
        {
            newPiece = new Bomb(x, y, team);
        }
        else if (rank == 12)
        {
            newPiece = new Flag(x, y, team);
        }
        else
        {
            newPiece = new GamePiece(x, y, team, rank);
        }

        if (board[x][y] == null)
        {
            board[x][y] = newPiece;
            if (team == 0)
            {
                bluePieces.add(newPiece);
            }
            else
            {
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
     * This method returns the piece at the location.
     *
     * @param x
     *            is the x location.
     * @param y
     *            is the y location.
     * @return is the GamePiece at the location.
     */
    public GamePiece getPiece(int x, int y)
    {
        return board[x][y];
    }


    /**
     * Handles the movement on the gameboard.
     *
     * @return 0 if the move was successful,-1 if the move was unsuccessful, and
     *         1 if the move resulted in a battle where both pieces died. -2 if
     *         the move resulted in a loss.
     * @param mover
     *            The soldier moving.
     * @param x
     *            The intended x coordinate of the move.
     * @param y
     *            The intended y coordinate of the move.
     */
    public int movement(GamePiece mover, int x, int y)
    {
        int oldX = mover.getX();
        int oldY = mover.getY();
        int result;
        if (mover.getRank() == 9)
        {
            int movedCoord;
            int finalDestination;
            boolean movedCoordIsX = true;
            if((x == oldX && y != oldY)) {
                movedCoord = oldY;
                finalDestination = y;
                movedCoordIsX = false;
            }
            else {
                movedCoord = oldX;
                finalDestination = x;
            }
            if(finalDestination < movedCoord) {
                int temp = movedCoord;
                movedCoord = finalDestination;
                finalDestination = temp;
            }
            else {
                movedCoord++;
                finalDestination++;
            }
            if(movedCoordIsX) {
                for (int i = movedCoord; i < finalDestination; i++)
                {
                    if (board[i][y] != null)
                    {
                        return -1;
                    }
                }
            }
            else {
                for (int j = movedCoord; j < finalDestination; j++)
                {
                    if (board[x][j] != null)
                    {
                        return -1;
                    }
                }
            }
        }
        result = mover.move(x, y);
        if (result == 0)
        {
            if (board[x][y] != null)
            {
                int battleResult = mover.battle(mover, board[x][y]);
                if (battleResult == 1)
                {
                    removeFromPieceArrays(x, y);
                    board[x][y] = mover;
                    board[oldX][oldY] = null;
                    return 0;
                }
                else if (battleResult == -1)
                {
                    removeFromPieceArrays(oldX, oldY);
                    board[oldX][oldY] = null;
                    return -2;
                }
                else if (battleResult == 0)
                {
                    removeFromPieceArrays(oldX, oldY);
                    removeFromPieceArrays(x, y);
                    board[x][y] = null;
                    board[oldX][oldY] = null;
                    return 1;
                }
                else if (battleResult == 7)
                {
                    isGameOver = true;
                    return 0;
                }
                else
                {
                    mover.setX(oldX);
                    mover.setY(oldY);
                    return -1;
                }
            }
            else
            {
                board[oldX][oldY] = null;
                board[x][y] = mover;
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }


    /**
     * This method removes an object from the piece arraylists so it will
     * properly update the board.
     *
     * @param x
     *            is the x location.
     * @param y
     *            is the y location.
     */
    private void removeFromPieceArrays(int x, int y)
    {
        if (bluePieces.contains(board[x][y]))
        {
            bluePieces.remove(board[x][y]);
        }
        else
        {
            redPieces.remove(board[x][y]);
        }
    }

    /**
     * Returns true if the game ends.
     *
     * @return if the game ends.
     */
    public boolean getIsGameOver()
    {
        return isGameOver;
    }


    /**
     * This method returns the arraylist containing the bluepieces.
     *
     * @return is the list of pieces
     */
    public ArrayList<GamePiece> returnBluePieces()
    {
        if (bluePieces.size() != 0)
        {
            return bluePieces;
        }
        else
        {
            return null;
        }
    }


    /**
     * This method returns the arraylist containing the red pieces.
     *
     * @return is the list of pieces.
     */
    public ArrayList<GamePiece> returnRedPieces()
    {
        if (redPieces.size() != 0)
        {
            return redPieces;
        }
        else
        {
            return null;
        }
    }
}
