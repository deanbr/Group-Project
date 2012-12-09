package com.example.strategotesting;

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
        board = new GameboardModel();
        screen = new StrategoScreen();
    }

    /**
     * Simulates the clicking of the button New Game.
     */
    public void testNewGameClicked()
    {
        click(newGame);
        assertNotNull(screen.getModel()); //is null. Is there something
        //I should be doing with the button?
    }

    /**
     * Simulates the clicking of the button End Game.
     */
    public void testEndGameClicked()
    {
        click(endGame);
        assertNotNull(screen.getModel());
    }

    /**
     * Simulates the clicking of a cell.
     */
    public void testOnTouchDown()
    {
        click(newGame);
        event.setAction(1); //ACTION_DOWN?
        event.setLocation(6, 9);
        screen.onTouchDown(event);

        //team Red setting players.
        board.setPiece(6, 9, 0, 1);
        assertTrue(board.equals(screen.getModel()));
        event.setLocation(0, 9);

        //last row (9)
        event.setLocation(1, 9);
        screen.onTouchDown(event);
        event.setLocation(2, 9);
        screen.onTouchDown(event);
        event.setLocation(3, 9);
        screen.onTouchDown(event);
        event.setLocation(4, 9);
        screen.onTouchDown(event);
        event.setLocation(5, 9);
        screen.onTouchDown(event);
        event.setLocation(7, 9);
        screen.onTouchDown(event);
        event.setLocation(8, 9);
        screen.onTouchDown(event);
        event.setLocation(9, 9);
        //9th row
        screen.onTouchDown(event);
        event.setLocation(1, 8);
        screen.onTouchDown(event);
        event.setLocation(2, 8);
        screen.onTouchDown(event);
        event.setLocation(3, 8);
        screen.onTouchDown(event);
        event.setLocation(4, 8);
        screen.onTouchDown(event);
        event.setLocation(5, 8);
        screen.onTouchDown(event);
        event.setLocation(6, 8);
        screen.onTouchDown(event);
        event.setLocation(7, 8);
        screen.onTouchDown(event);
        event.setLocation(8, 8);
        screen.onTouchDown(event);
        event.setLocation(9, 8);
        screen.onTouchDown(event);
        //8th row
        screen.onTouchDown(event);
        event.setLocation(1, 7);
        screen.onTouchDown(event);
        event.setLocation(2, 7);
        screen.onTouchDown(event);
        event.setLocation(3, 7);
        screen.onTouchDown(event);
        event.setLocation(4, 7);
        screen.onTouchDown(event);
        event.setLocation(5, 7);
        screen.onTouchDown(event);
        event.setLocation(6, 7);
        screen.onTouchDown(event);
        event.setLocation(7, 7);
        screen.onTouchDown(event);
        event.setLocation(8, 7);
        screen.onTouchDown(event);
        event.setLocation(9, 7);
        screen.onTouchDown(event);
        //7th row
        screen.onTouchDown(event);
        event.setLocation(1, 6);
        screen.onTouchDown(event);
        event.setLocation(2, 6);
        screen.onTouchDown(event);
        event.setLocation(3, 6);
        screen.onTouchDown(event);
        event.setLocation(4, 6);
        screen.onTouchDown(event);
        event.setLocation(5, 6);
        screen.onTouchDown(event);
        event.setLocation(6, 6);
        screen.onTouchDown(event);
        event.setLocation(7, 6);
        screen.onTouchDown(event);
        event.setLocation(8, 6);
        screen.onTouchDown(event);
        event.setLocation(9, 6);
        screen.onTouchDown(event);

        screen.coverPieces(); //cover up red pieces
        screen.switchTurn();
        //Blue team setting pieces
        //last row (9)
        event.setLocation(1, 0);
        screen.onTouchDown(event);
        event.setLocation(2, 0);
        screen.onTouchDown(event);
        event.setLocation(3, 0);
        screen.onTouchDown(event);
        event.setLocation(4, 0);
        screen.onTouchDown(event);
        event.setLocation(5, 0);
        screen.onTouchDown(event);
        event.setLocation(7, 0);
        screen.onTouchDown(event);
        event.setLocation(8, 0);
        screen.onTouchDown(event);
        event.setLocation(9, 0);
        //9th row
        screen.onTouchDown(event);
        event.setLocation(1, 1);
        screen.onTouchDown(event);
        event.setLocation(2, 1);
        screen.onTouchDown(event);
        event.setLocation(3, 1);
        screen.onTouchDown(event);
        event.setLocation(4, 1);
        screen.onTouchDown(event);
        event.setLocation(5, 1);
        screen.onTouchDown(event);
        event.setLocation(6, 1);
        screen.onTouchDown(event);
        event.setLocation(7, 1);
        screen.onTouchDown(event);
        event.setLocation(8, 1);
        screen.onTouchDown(event);
        event.setLocation(9, 1);
        screen.onTouchDown(event);
        //8th row
        screen.onTouchDown(event);
        event.setLocation(1, 2);
        screen.onTouchDown(event);
        event.setLocation(2, 2);
        screen.onTouchDown(event);
        event.setLocation(3, 2);
        screen.onTouchDown(event);
        event.setLocation(4, 2);
        screen.onTouchDown(event);
        event.setLocation(5, 2);
        screen.onTouchDown(event);
        event.setLocation(6, 2);
        screen.onTouchDown(event);
        event.setLocation(7, 2);
        screen.onTouchDown(event);
        event.setLocation(8, 2);
        screen.onTouchDown(event);
        event.setLocation(9, 2);
        screen.onTouchDown(event);
        //7th row
        screen.onTouchDown(event);
        event.setLocation(1, 3);
        screen.onTouchDown(event);
        event.setLocation(2, 3);
        screen.onTouchDown(event);
        event.setLocation(3, 3);
        screen.onTouchDown(event);
        event.setLocation(4, 3);
        screen.onTouchDown(event);
        event.setLocation(5, 3);
        screen.onTouchDown(event);
        event.setLocation(6, 3);
        screen.onTouchDown(event);
        event.setLocation(7, 3);
        screen.onTouchDown(event);
        event.setLocation(8, 3);
        screen.onTouchDown(event);
        event.setLocation(9, 3);
        screen.onTouchDown(event);

        screen.coverPieces(); //cover blue pieces, but wouldn't it make sense
        //for this to be handled by the switchTurn method?
        screen.switchTurn(); //Red moving piece
        screen.unCoverPieces(); //uncover red pieces
        event.setLocation(2, 3); //illegal, moving a blue piece
        screen.onTouchDown(event);
        //what to assert?
        event.setLocation(2, 8); //illegal, moving a piece not in the front
        screen.onTouchDown(event);
        //assertEquals(?);
        event.setLocation(2, 6); //legal move, should work.
        //assertEquals(?);
        screen.coverPieces(); //cover red
        screen.switchTurn();
        screen.unCoverPieces(); //uncover blue
        event.setLocation(2, 6); //illegal, moving a red piece
        screen.onTouchDown(event);
        //what to assert?
        event.setLocation(2, 0); //illegal, moving a piece not in the front
        screen.onTouchDown(event);
        //assertEquals(?);
        event.setLocation(2, 3); //legal move, should work.
        //assertEquals(?);
        screen.coverPieces(); //cover blue
        screen.switchTurn();
        screen.unCoverPieces(); //uncover red
        event.setLocation(2,5); //move ontop of blue piece
        //figure out which one will be there and assert it's there...

    }
}

