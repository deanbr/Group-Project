package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the spy game piece class. Note that the battle method is different
 * as a spy can defeat a Marshal. This class could be removed, unfortunately
 * it had legacy code that was removed later it is here now to avoid type
 * errors.
 *
 * @author Jordan sablan (jordans9)
 * @author Brandon Dean (deanbr)
 * @author Jamie Dalrymple (jamied93)
 * @author Matt Morrison (mattm512)
 *  @version Nov 10, 2012
 */
public class Spy extends GamePiece
{

    /**
     * This will create a spy game piece.
     * @param x is the x position.
     * @param y is the y position.
     * @param team 0 represents blue, 1 represents red.
     */
    public Spy(int x, int y, int team) {
        super(x, y, team, 10);
    }

}
