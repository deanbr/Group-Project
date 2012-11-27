package stratego;

// -------------------------------------------------------------------------
/**
 * The model for the board based on a 2D GamePiece array.
 *
 * @author Brandon Dean, Jordan Sablan, Matt Morrison, Jaime Dalrymple
 * @version Nov 10, 2012
 */
public class GameboardModel
{
    private GamePiece[][] board;
    private int           size = 10;
    private boolean       isGameOver;


    // ----------------------------------------------------------
    /**
     * A 2D array simulating the 10x10 board is created.
     */
    public GameboardModel()
    {
        board = new GamePiece[10][10];
        isGameOver = false;
    }


    /**
     * Simulates the battle mechanic. Accepts the attacking piece and the
     * defending piece and returns a "win," "tie," or "loss."
     *
     * @param attacker The attacking GamePiece object.
     * @param defender  The GamePiece object being targeted.
     * @return Returns 1 if the attacker won and -1 if the attacker lost and 0
     *         if there was no battle because the two pieces are team mates.
     */
    public int battle(GamePiece attacker, GamePiece defender)
    {
        if (attacker.getTeam() == defender.getTeam())
        {
            return 0;
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


    // ----------------------------------------------------------
    /**
     * Called when the flag is captured.
     */
    public void gameOver()
    {
        isGameOver = true;
    }

}
