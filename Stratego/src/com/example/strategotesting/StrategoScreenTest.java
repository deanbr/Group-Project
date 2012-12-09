package com.example.strategotesting;

import sofia.graphics.ShapeView;
import android.view.MotionEvent;
import android.widget.Button;

// -------------------------------------------------------------------------
/**
 *  Tests that the {@link StrategoScreen} class works properly.
 *
 *  @author Jamie
 *  @version Dec 7, 2012
 */
public class StrategoScreenTest
extends student.AndroidTestCase<StrategoScreen>
{
    //~ Fields ----------------------------------------------------------
    private Button newGame;
    private Button endGame;
    private GameboardModel board;
    private StrategoScreen screen;
    private MotionEvent event;
    private ShapeView shapeView;
    private float cellSize;

    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public StrategoScreenTest()
    {
        super(StrategoScreen.class);
    }

    public void setUp()
    {
        int size = 10;
        //board = new GameboardModel();
        screen = new StrategoScreen();
        cellSize = Math.min(screen.getWidth(), screen.getHeight()) / size;
    }

    /**
     * Simulates the clicking of the button New Game.
     */
    public void testNewGameClicked()
    {
        click(newGame);
        assertNull(screen.getModel());
    }

    /**
     * Simulates the clicking of the button End Game.
     */
    public void testEndGameClicked()
    {
        click(endGame);
        assertNull(screen.getModel());
    }

    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }

    /**
     * Simulates clicking the middle of the specified cell in the maze. This is
     * equivalent to calling: touchDownCell(x, y); touchUp();
     */
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }

    /**
     * Tests the clicking of a cell.
     */
    public void testOnTouchDown()
    {
        click(newGame);
        clickCell(0, 0); //in blue territory, illegal
        assertNull(screen.getModel());
        clickCell(0, 7);
        assertNotNull(screen.getModel());

        //set rest of red pieces
        clickCell(0, 6); //row 7
        clickCell(1, 6);
        clickCell(2, 6);
        clickCell(3, 6);
        clickCell(4, 6);
        clickCell(5, 6);
        clickCell(6, 6);
        clickCell(7, 6);
        clickCell(8, 6);
        clickCell(9, 6);
        clickCell(0, 7); //row 8
        clickCell(1, 7);
        clickCell(2, 7);
        clickCell(3, 7);
        clickCell(4, 7);
        clickCell(5, 7);
        clickCell(6, 7);
        clickCell(7, 7);
        clickCell(8, 7);
        clickCell(9, 7);
        clickCell(0, 8); //row 9
        clickCell(1, 8);
        clickCell(2, 8);
        clickCell(3, 8);
        clickCell(4, 8);
        clickCell(5, 8);
        clickCell(6, 8);
        clickCell(7, 8);
        clickCell(8, 8);
        clickCell(9, 8);
        clickCell(0, 9); //row 10
        clickCell(1, 9);
        clickCell(2, 9);
        clickCell(3, 9);
        clickCell(4, 9);
        clickCell(5, 9);
        clickCell(6, 9);
        clickCell(7, 9);
        clickCell(8, 9);
        clickCell(9, 9);

        //set blue pieces
        clickCell(0, 0); //row 1
        clickCell(1, 0);
        clickCell(2, 0);
        clickCell(3, 0);
        clickCell(4, 0);
        clickCell(5, 0);
        clickCell(6, 0);
        clickCell(7, 0);
        clickCell(8, 0);
        clickCell(9, 0);
        clickCell(0, 1); //row 2
        clickCell(1, 1);
        clickCell(2, 1);
        clickCell(3, 1);
        clickCell(4, 1);
        clickCell(5, 1);
        clickCell(6, 1);
        clickCell(7, 1);
        clickCell(8, 1);
        clickCell(9, 1);
        clickCell(0, 2); //row 3
        clickCell(1, 2);
        clickCell(2, 2);
        clickCell(3, 2);
        clickCell(4, 2);
        clickCell(5, 2);
        clickCell(6, 2);
        clickCell(7, 2);
        clickCell(8, 2);
        clickCell(9, 2);
        clickCell(0, 3); //row 4
        clickCell(1, 3);
        clickCell(2, 3);
        clickCell(3, 3);
        clickCell(4, 3);
        clickCell(5, 3);
        clickCell(6, 3);
        clickCell(7, 3);
        clickCell(8, 3);
        clickCell(9, 3);

        board = screen.getModel();
        clickCell(0, 4); //nothing in this spot, board shouldn't change
        assertTrue(board.equals(screen.getModel()));
        clickCell(0, 2); //blue piece, board shouldn't change
        assertTrue(board.equals(screen.getModel()));
        clickCell(0, 9); //can't move this piece, board shouldn't change
        assertTrue(board.equals(screen.getModel()));
        clickCell(0, 6); //legal move, board should change
        assertFalse(board.equals(screen.getModel()));

        //blue's turn
        board = screen.getModel();
        clickCell(4, 5); //nothing in this spot
        assertTrue(board.equals(screen.getModel()));
        clickCell(0, 8); //red piece
        assertTrue(board.equals(screen.getModel()));
        clickCell(3, 2); //can't move this piece
        assertTrue(board.equals(screen.getModel()));
        clickCell(0, 3); //legal move
        assertFalse(board.equals(screen.getModel()));

        //red attacks blue
        board = screen.getModel();
        clickCell(0, 5);
        assertFalse(board.equals(screen.getModel()));
    }
}

