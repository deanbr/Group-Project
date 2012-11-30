package com.example.strategotesting;


/**
 * // -------------------------------------------------------------------------
/**
 *  The test class for the GameboardModel class which tests its methods.
 *
 *  @author Brandon
 *  @version Nov 26, 2012
 */

public class GameBoardModelTest
    extends student.TestCase
{

    private GameboardModel board;
    private Soldier attacker;
    private GamePiece defender;

    /**
     * Required setUp method to revert all fields to defaults after each test.
     */
    public void setUp() {
        board = new GameboardModel();
    }

    public void testBattle() {
       // board.setPiece(1, 1, 0, 1); //marshall
       // board.setPiece(1, 2, 1, 5); //captain
        Soldier marshall = new Soldier(1, 1, 0, 1);
        Soldier captain = new Soldier(1, 2, 1, 5);

        assertEquals(1, marshall.battle(marshall, captain));
    }

}
