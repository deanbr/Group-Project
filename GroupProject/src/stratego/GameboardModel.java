package stratego;

// -------------------------------------------------------------------------
/**
 *  The model for the board.
 *
 *  @author J
 *  @version Nov 10, 2012
 */
public class GameboardModel
{
    private GamePiece[][] board;
    private int size = 10;

    public GameboardModel() {
        board = new GamePiece[size][size];
    }



}
