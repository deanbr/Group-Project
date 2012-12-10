package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
 * /** This is the flag game piece, a subclass of the GamePiece class.
 *
 * @author Jordan sablan (jordans9)
 * @author Brandon Dean (deanbr)
 * @author Jamie Dalrymple (jamied93)
 * @author Matt Morrison (mattm512)
 * @version Nov 11, 2012
 */
public class Flag
    extends GamePiece
{

    /**
     * This will create a flag game piece.
     *
     * @param x
     *            is the x position.
     * @param y
     *            is the y position.
     * @param team
     *            0 represents blue, 1 represents red.
     */
    public Flag(int x, int y, int team)
    {
        super(x, y, team, 12);
    }


    /**
     * This is the move method for the bomb.
     *
     * @return it should always be -1 as a flag can't move.
     * @param x
     *            is the x location.
     * @param y
     *            is the y location.
     */
    public int move(int x, int y)
    {
        return -1;
    }


    /**
     * Simulates the battle mechanic. Accepts the attacking piece and the
     * defending piece and returns a "win," "tie," or "loss."
     *
     * @param attacker
     *            The attacking GamePiece object.
     * @param defender
     *            The GamePiece object being targeted.
     * @return returns a junk value of -5 as it should never move.
     */
    public int battle(GamePiece attacker, GamePiece defender)
    {
        return -5;
    }
}
