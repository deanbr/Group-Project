package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the flag game piece, a subclass of the GamePiece class.
 *
 *  @author J
 *  @version Nov 11, 2012
 */
public class Flag extends GamePiece
{

    /**
     * This will create a flag game piece.
     * @param x is the x position.
     * @param y is the y position.
     * @param team 0 represents blue, 1 represents red.
     */
    public Flag(int x, int y, int team)
    {
        super(x, y, team, 12);
    }
}
