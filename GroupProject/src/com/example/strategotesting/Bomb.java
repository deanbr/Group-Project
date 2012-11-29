package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the Bomb class, a subclass of GamePiece.
 *
 *  @author J
 *  @version Nov 11, 2012
 */
public class Bomb extends GamePiece
{

    /**
     * This will create a bomb game piece.
     * @param x is the x position.
     * @param y is the y position.
     * @param team 0 represents blue, 1 represents red.
     */
    public Bomb(int x, int y, int team) {
        super(x, y, team, 11);
    }

}
