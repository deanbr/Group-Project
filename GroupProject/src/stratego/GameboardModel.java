package stratego;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  The model for the board.
 *
 *  @author J
 *  @version Nov 10, 2012
 */
public class GameboardModel
{
    private RectangleShape[][] board;
    private int size = 10;

    public GameboardModel() {
        board = new RectangleShape[size][size];
    }



}
