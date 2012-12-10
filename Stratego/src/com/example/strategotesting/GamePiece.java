package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
 * /** This is the generic super class of all gamepieces.
 *
 * @author Jordan sablan (jordans9)
 * @author Brandon Dean (deanbr)
 * @author Jamie Dalrymple (jamied93)
 * @author Matt Morrison (mattm512)
 * @version Dec 2, 2012
 */
public class GamePiece
{

    private int x;
    private int y;
    private int team;
    private int rank;


    // ----------------------------------------------------------
    /**
     * Create a new GamePiece object.
     *
     * @param x
     *            The x coordinate.
     * @param y
     *            The y coordinate.
     * @param team
     *            Team 0 corresponds to the blue team and team 1 corresponds to
     *            the red team.
     * @param rank
     *            The rank of the piece.
     */
    public GamePiece(int x, int y, int team, int rank)
    {
        this.x = x;
        this.y = y;
        this.team = team;
        this.rank = rank;
    }


    /***
     * Returns the x position.
     *
     * @return x is the x position.
     */
    public int getX()
    {
        return x;
    }


    /**
     * Returns the y position.
     *
     * @return y is the y position.
     */
    public int getY()
    {
        return y;
    }


    /**
     * This method sets the x location.
     *
     * @param x
     *            is the x location.
     */
    public void setX(int x)
    {
        this.x = x;
    }


    /**
     * This method sets the Y location.
     *
     * @param y
     *            is the y location.
     */
    public void setY(int y)
    {
        this.y = y;
    }


    /**
     * This is used by subclasses to move the piece.
     *
     * @param newx
     *            is the new x location.
     * @param newy
     *            is the new y locaiton.
     */
    protected void setPosition(int newx, int newy)
    {
        this.x = newx;
        this.y = newy;
    }


    /**
     * This method returns the team.
     *
     * @return is the int value of the team.
     */
    public int getTeam()
    {
        return this.team;
    }


    /**
     * This method will return the soldier rank so the game can determine who
     * won the battle.
     *
     * @return rank is the rank.
     */
    public int getRank()
    {
        return rank;
    }


    /**
     * Simulates the battle mechanic. Accepts the attacking piece and the
     * defending piece and returns a "win," "tie," or "loss."
     *
     * @param attacker
     *            The attacking GamePiece object.
     * @param defender
     *            The GamePiece object being targeted.
     * @return Returns 1 if the attacker won and -1 if the attacker lost and 5
     *         if there was no battle because the two pieces are team mates. 7
     *         indicates that the flag has been found and the game is over. 0 if
     *         tie.
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
                return 7;
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
     * This method will handle every soldier movement type, except for Scout.
     * For now it will return -1 if the user tries to move more than one block
     * in any direction. If the move is successful it will return 0.
     *
     * @param newx
     *            is the new x location.
     * @param newy
     *            is the new y location.
     * @return Success of the move.
     */
    public int move(int newx, int newy)
    {
        if (newx != this.getX() && newy != this.getY())
        {
            return -1;
        }
        else if (newx == (this.getX() - 1) || newx == (this.getX() + 1)
            || newy == (this.getY() - 1) || newy == (this.getY() + 1))
        {

            this.setX(newx);
            this.setY(newy);
            return 0;
        }
        else
        {
            return -1;
        }
    }


    /**
     * This method will return the name of the piece type.
     *
     * @return is the name of the piece.
     */
    public String toString()
    {
        if (getRank() == 1)
        {
            return "Marshal";
        }
        else if (getRank() == 2)
        {
            return "General";
        }
        else if (getRank() == 3)
        {
            return "Colonel";
        }
        else if (getRank() == 4)
        {
            return "Major";
        }
        else if (getRank() == 5)
        {
            return "Captain";
        }
        else if (getRank() == 6)
        {
            return "Lieutenant";
        }
        else if (getRank() == 7)
        {
            return "Sergeant";
        }
        else if (getRank() == 8)
        {
            return "Miner";
        }
        else if (getRank() == 9)
        {
            return "Scout";
        }
        else if (getRank() == 10)
        {
            return "Spy";
        }
        else if (getRank() == 11)
        {
            return "Bomb";
        }
        else
        {
            return "Flag";
        }
    }


    /**
     * This method returns the shorthand names for the board.
     *
     * @return is the shorthand name.
     */
    public String toStringShort()
    {
        if (getRank() == 11)
        {
            return "B";
        }
        else if (getRank() == 12)
        {
            return "F";
        }
        else
        {
            return Integer.toString(getRank());
        }
    }

}
