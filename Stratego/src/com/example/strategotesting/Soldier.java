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
            this.setX(newx);
            this.setY(newy);
            return 0;
        }
        else {
            return -1;
        }
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
