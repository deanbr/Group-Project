package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the spy game piece class. Note that the battle method is different
 * as a spy can defeat a Marshal.
 *
 *  @author J
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

   /* @Override
    public int battle(int enemyRank, int enemyX, int enemyY) {
        if(enemyX != getX() && enemyY != getY()) {
            return -1;
        }
        else if (enemyRank == 10) {
            move(enemyX, enemyY);
            return 0;
        }
        else if (enemyRank > getRank()) {
            return -2;
        }
        else if (enemyRank == getRank()) {
            return -3;
        }
        else {
            move(enemyX, enemyY);
            return 0;
        }
    }*/
}
