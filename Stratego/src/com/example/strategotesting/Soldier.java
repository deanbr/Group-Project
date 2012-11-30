package com.example.strategotesting;

/**
 // -------------------------------------------------------------------------
/**
 *  This is the superclass of soldier, and all game pieces will extend it.
 *  The Marshall, General, Colonel, Major, Captain, Liutenant, and Sergeant
 *  pieces rely solely one this subclass.
 *
 *  @author J
 *  @version Nov 10, 2012
 */
public class Soldier extends GamePiece
{

    /**
     * This will initialize a soldier object.
     * @param x is the original x position.
     * @param y is the original y position.
     * @param team Enter 0 for blue, 1 for red.
     * @param rank is the rank of the soldier.
     */
    public Soldier(int x, int y, int team, int rank) {
        super(x, y, team, rank);
    }



    /**
     * This method will handle every soldier movement type, except for Scout.
     * For now it will return -1 if the user tries to move more than one block
     * in any direction. If the move is successful it will return 0.
     * @param newx is the new x location.
     * @param newy is the new y location.
     * @return Success of the move.
     */
    public int move(int newx, int newy) {
        if(newx != this.getX() && newy != this.getY()) {
            return -1;
        }
        else if (newx == (this.getX() - 1) || newx == (this.getX() + 1) ||
            newy == (this.getY() - 1) || newy == (this.getY() + 1)){

           /* if(board[newx][newy] != -1) {
                battle = new Battle(this, b)
            }
            */

            this.setX(newx);
            this.setY(newy);
            return 0;
        }
        else {
            return -1;
        }
    }


    /**
     * Simulates the battle mechanic. Accepts the attacking piece and the
     * defending piece and returns a "win," "tie," or "loss."
     *
     * @param attacker The attacking GamePiece object.
     * @param defender  The GamePiece object being targeted.
     * @return Returns 1 if the attacker won and -1 if the attacker lost and 5
     *         if there was no battle because the two pieces are team mates.
     */
    public int battle(GamePiece attacker, GamePiece defender)
    {
        if (attacker.getTeam() == defender.getTeam())
        {
            return 5;
        }
        else if (attacker.getRank() > 9 || defender.getRank() > 9)
        {
            // spy attacking marshal
            if (attacker.getRank() == 10 && defender.getRank() == 1)
            {
                return 1;
            }
            // flag is discovered
            else if (defender.getRank() == 12)
            {
                return 1;
            }
            // miner attacking bomb
            else if (attacker.getRank() == 8 && defender.getRank() == 11)
            {
                return 1; // win
            }
        }
        else if (attacker.getRank() < defender.getRank())
        {
            return 1;
        }
        else if (attacker.getRank() == defender.getRank())
        {
            return 0;
        }
        return -1;
    }


    /**
     * This method handles battle interactions.
     * @param enemyRank is the rank of the enemy piece.
     * @param enemyX is the x position of the enemy.
     * @param enemyY is the y position of the enemy.
     * @return is the outcome of the battle.
     *//*
    public int battle(int enemyRank, int enemyX, int enemyY) {
        if(enemyX != this.getX() && enemyY != this.getY()) {
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
    }*/

}
