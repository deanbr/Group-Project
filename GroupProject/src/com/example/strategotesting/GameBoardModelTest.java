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

    GameboardModel board;
    Soldier attacker;
    GamePiece defender;

    /**
     * Required setUp method to revert all fields to defaults after each test.
     */
    public void setUp() {
        board = new GameboardModel();
    }

    public void testBattle() {
        attacker = new Soldier(1, 1, 0, 1); // marshall
        defender = new Soldier(1, 2, 1, 5); // captain

        assertEquals(1, board.battle(attacker, defender));
    }

}
