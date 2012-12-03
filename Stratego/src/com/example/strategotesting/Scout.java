package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the scout game piece, note that the move method allows movement in
 * for more than 1 square.
 *
 *  @author J
 *  @version Nov 11, 2012
 */
public class Scout extends GamePiece
{

    // ----------------------------------------------------------
    /**
     * A new object is created that draws on elements from the soldier
     * superclass.
     * @param x The x coordinate of the piece's starting position.
     * @param y The y coordinate of the piece's starting position.
     * @param team 0 represents blue, 1 represents red.
     */
    public Scout(int x, int y, int team)
    {
        super(x, y, team, 9);
    }

    /**
     * This method will handle movement for the Scout.
     * For now it will return -1 if the user tries to move diagonally or tries
     * to make another illegal move.
     * If the move is successful it will return 0.
     * @param newx is the new x location.
     * @param newy is the new y location.
     * @return Success of the move.
     */
    public int move(int newx, int newy) {
        if(newx > 9 || newy > 9) {
            return -1;
        }
        else if(newx != getX() && newy != getY()) {
            return -1;
        }
        else {
            setPosition(newx, newy);
            return 0;
        }
    }
}
