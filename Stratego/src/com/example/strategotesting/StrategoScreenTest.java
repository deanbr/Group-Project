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
    private GameboardModel board;
    private ShapeView shapeView;
    private float cellSize;
    private Button newGame;
    private Button endGame;

    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public StrategoScreenTest()
    {
        super(StrategoScreen.class);
    }

    /**
     *
     */
    public void setUp()
    {
        cellSize = Math.min(getScreen().getWidth(), getScreen().getHeight()) / 10;
    }

    /**
     * Simulates the clicking of the button New Game.
     */
    public void testNewGameClicked()
    {
        click(newGame);
        assertNull(getScreen().getModel().getPiece(0, 0));
    }

    /**
     * Simulates the clicking of the button End Game.
     */
    public void testEndGameClicked()
    {
        click(endGame);
        assertNull(getScreen().getModel().getPiece(0, 0));
    }

    /**
     * Tests the clicking of a cell.
     */
    public void testOnTouchDown()
    {
        click(newGame);
        clickCell(0, 0); //in blue territory, illegal
        assertNull(getScreen().getModel().getPiece(0, 0));//RED CAN'T SET THERE

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
        assertEquals("Flag", getScreen().getModel().getPiece(9, 9).toString());

        //set blue pieces
        clickCell(0, 0); //row 1
        clickCell(0, 0); //Tries to set piece in occupied place.
        clickCell(1, 0);
        assertNotSame("General", getScreen().getModel().getPiece(0, 0).toString());
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
        assertEquals("Bomb", getScreen().getModel().getPiece(8, 3).toString());

        GamePiece temp = getScreen().getModel().getPiece(0, 6);
        clickCell(0, 6);//Red move
        clickCell(0, 5);

        assertEquals(temp, getScreen().getModel().getPiece(0, 5));
        waitingFoYouSon();

        clickCell(0, 3);//Blue move
        clickCell(0, 4);
        waitingFoYouSon();

        clickCell(0, 5);//Red Move assaulting a lower level he will win.
        clickCell(0, 4);
        waitingFoYouSon();

        temp = getScreen().getModel().getPiece(0, 2);
        clickCell(0, 2);//Blue trying to move to a space already occupied by blue
        clickCell(0, 1);// it will not work.
        assertNotSame(temp, getScreen().getModel().getPiece(0, 1));
        clickCell(0, 2);
        clickCell(0, 3);
        waitingFoYouSon();

        clickCell(0, 4);//Red Move again assaulting blue piece.
        clickCell(0, 3);//Will win again.
        waitingFoYouSon();
        clickCell(0, 1);//Blue Move
        clickCell(0, 2);
        waitingFoYouSon();
        clickCell(0, 3);//Red Move
        clickCell(0, 4);
        waitingFoYouSon();
        clickCell(0, 2);//Blue Move
        clickCell(0, 3);
        waitingFoYouSon();
        clickCell(0, 4);//Red Move
        clickCell(1, 4);
        waitingFoYouSon();
        clickCell(0, 3);//Blue Move
        clickCell(0, 4);
        waitingFoYouSon();
        clickCell(1, 4);//Red Move
        clickCell(2, 4);
        waitingFoYouSon();
        clickCell(0, 4);//Blue move
        clickCell(1, 4);
        waitingFoYouSon();
        clickCell(2, 4);//Red move
        clickCell(3, 4);
        waitingFoYouSon();
        clickCell(1, 4);//Blue move
        clickCell(2, 4);
        waitingFoYouSon();
        clickCell(3, 4);//Red move
        clickCell(4, 4);
        waitingFoYouSon();
        clickCell(2, 4);//Blue Move
        clickCell(3, 4);
        waitingFoYouSon();
        clickCell(4, 4);//Red move
        clickCell(5, 4);
        waitingFoYouSon();
        clickCell(3, 4);//Blue move
        clickCell(4, 4);
        waitingFoYouSon();
        clickCell(5, 4);//Red Move
        clickCell(6, 4);
        waitingFoYouSon();
        clickCell(4, 4);//Blue move
        clickCell(5, 4);
        waitingFoYouSon();
        clickCell(6, 4);//Red move
        clickCell(7, 4);
        waitingFoYouSon();
        clickCell(5, 4);//Blue move
        clickCell(6, 4);
        waitingFoYouSon();
        clickCell(7, 4);//Red move
        clickCell(8, 4);
        waitingFoYouSon();
        clickCell(6, 4);//Blue move
        clickCell(7, 4);
        waitingFoYouSon();
        clickCell(8, 4);//Red move
        clickCell(9, 4);
        waitingFoYouSon();
        //Now red is set to take the flag, but first test mine interaction.

        clickCell(0, 0);//Blue move
        clickCell(0, 1);
        waitingFoYouSon();
        clickCell(3, 6);//Red Move
        clickCell(3, 5);
        waitingFoYouSon();
        clickCell(0, 1);//Blue move
        clickCell(0, 2);
        waitingFoYouSon();
        clickCell(3, 5);//Red move
        clickCell(3, 4);
        waitingFoYouSon();
        clickCell(0, 2);//Blue move
        clickCell(0, 3);
        waitingFoYouSon();
        clickCell(3, 4);//Red moves to mine and loses.
        clickCell(3, 3);
        waitingFoYouSon();
        assertNull(getScreen().getModel().getPiece(3, 4));
        assertEquals("Bomb", getScreen().getModel().getPiece(3, 3).toString());

        temp = getScreen().getModel().getPiece(0, 3);
        clickCell(0, 3);//Blue move
        clickCell(9, 9);//Illegal square selected piece reset.
        clickCell(0, 3);
        clickCell(0, 4);
        assertEquals(temp, getScreen().getModel().getPiece(0, 4));
        waitingFoYouSon();

        clickCell(9, 4);//Red move
        clickCell(9, 3);//Takes flag for the win.
        assertEquals(true, getScreen().getModel().getIsGameOver());
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
     * This method is necessary for GUI tests to run as we have a wait function
     * built into the GUI that prevents moves for a certain period of time, so
     * the user may switch.
     */
    private void waitingFoYouSon() {
        try {
            java.lang.Thread.currentThread().sleep(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}