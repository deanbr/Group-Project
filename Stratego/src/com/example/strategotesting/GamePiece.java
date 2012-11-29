package com.example.strategotesting;

public class GamePiece
{

    private int x;
    private int y;
    private int team;
    private int rank;

    // ----------------------------------------------------------
    /**
     * Create a new GamePiece object.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param team Team 0 corresponds to the blue team and team 1 corresponds to the
     * red team.
     */
    public GamePiece(int x, int y, int team, int rank) {
        this.x = x;
        this.y = y;
        this.team = team;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * This is used by subclasses to move the piece.
     */
    protected void setPosition(int newx, int newy) {
        this.x = newx;
        this.y = newy;
    }

    public int getTeam() {
        return this.team;
    }

    /**
     * This method will return the soldier rank so the game can determine who
     * won the battle.
     * @return rank is the rank.
     */
    public int getRank() {
        return rank;
    }

}
