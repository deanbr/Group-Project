package stratego;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the spy game piece class. Note that the battle method is different
 * as a spy can defeat a Marshal.
 *
 *  @author J
 *  @version Nov 10, 2012
 */
public class Spy
    extends Soldier
{

    /**
     * This will create a spy game piece.
     * @param x is the x position.
     * @param y is the y position.
     * @param rank is the rank.
     */
    public Spy(int x, int y, int rank) {
        super(x, y, rank);
    }

    @Override
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
    }
}
