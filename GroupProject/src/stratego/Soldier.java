package stratego;

/**
 // -------------------------------------------------------------------------
/**
 *  This is the superclass of soldier all game pieces will extend it.
 *
 *  @author J
 *  @version Nov 10, 2012
 */
public class Soldier
{
    private int x;
    private int y;
    private int rank;

    /**
     * This will initialize a soldier object.
     * @param x is the original x position.
     * @param y is the original y position.
     * @param rank is the rank of the soldier.
     */
    public Soldier(int x, int y, int rank) {
        this.x = x;
        this.y = y;
        this.rank = rank;
    }

    /***
     *Returns the x position.
     *@return x is the x position.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y position.
     * @return y is the y position.
     */
    public int getY() {
        return y;
    }

    /**
     * This method will return the soldier rank so the game can determine who
     * won the battle.
     * @return rank is the rank.
     */
    public int getRank() {
        return rank;
    }

    /**
     * This method will handle every soldier movement type, but one.
     * For now it will return -1 if the user tries to move more than one block
     * in any direction. If the move is successful it will return 0.
     * @param newx is the new x location.
     * @param newy is the new y location.
     * @return Success of the move.
     */
    public int move(int newx, int newy) {
        if(newx != this.x && newy != this.y) {
            return -1;
        }
        else {
            this.x = newx;
            this.y = newy;
            return 0;
        }
    }

    /**
     * This method handles battle interactions.
     * @param enemyRank is the rank of the enemy piece.
     * @param enemyX is the x position of the enemy.
     * @param enemyY is the y position of the enemy.
     * @return is the outcome of the battle.
     */
    public int battle(int enemyRank, int enemyX, int enemyY) {
        if(enemyX != this.x && enemyY != this.y) {
            return -1;
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
