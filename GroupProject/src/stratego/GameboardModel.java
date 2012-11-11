package stratego;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
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
