package com.example.strategotesting;

/**
 * // -------------------------------------------------------------------------
 * /** The test class for the GameboardModel class which tests its methods.
 *
 * @author Brandon
 * @version Nov 26, 2012
 */

public class GameBoardModelTest
    extends student.TestCase
{

    private GameboardModel board;


    /**
     * Required setUp method to revert all fields to defaults after each test.
     */
    public void setUp()
    {
        board = new GameboardModel();
    }

    /**
     * Tests pieces being set and removed from the arraylist of pieces.
     */
    public void testSetAndRemovePieces()
    {
        board.setPiece(1, 1, 0, 1);
        assertEquals(1, board.getPiece(1, 1).getRank());
        assertEquals(0, board.getPiece(1, 1).getTeam());
        assertEquals(1, board.getPiece(1, 1).getX());
        assertEquals(1, board.getPiece(1, 1).getY());
        assertEquals(1, board.returnBluePieces().size());
        board.setPiece(2, 1, 1, 4);
        assertEquals(1, board.returnRedPieces().size());
        board.movement(board.getPiece(1, 1), 2, 1);
        assertNull(board.returnRedPieces().size());

    }


    /**
     * Tests a simple battle scenario.
     */
    public void testBattle()
    {
        board.setPiece(1, 1, 0, 1); // marshall
        board.setPiece(1, 2, 1, 5); // captain
        board.setPiece(0, 1, 1, 11);
        board.setPiece(1, 3, 0, 12);
        board.setPiece(7, 7, 0, 10);
        board.setPiece(7, 8, 1, 1);
        board.setPiece(8, 8, 1, 5);
        assertEquals(
            1,
            board.getPiece(1, 1).battle(
                board.getPiece(1, 1),
                board.getPiece(1, 2)));
        assertEquals(
            -5,
            board.getPiece(0, 1).battle(
                board.getPiece(0, 1),
                board.getPiece(1, 1)));
        assertEquals(
            -5,
            board.getPiece(1, 3).battle(
                board.getPiece(1, 3),
                board.getPiece(1, 2)));
        assertEquals(
            1,
            board.getPiece(7, 7).battle(
                board.getPiece(7, 7),
                board.getPiece(7, 8)));
        assertEquals(
            5,
            board.getPiece(8, 8).battle(
                board.getPiece(8, 8),
                board.getPiece(7, 8)));
    }


    /**
     * Tests movement for different game pieces.
     */
    public void testMovement()
    {
        board.setPiece(2, 2, 0, 9);
        board.setPiece(4, 4, 0, 3);
        board.setPiece(2, 6, 1, 5);
        board.setPiece(8, 8, 1, 11);
        board.setPiece(9, 9, 1, 12);
        board.setPiece(1, 7, 1, 4);
        board.setPiece(0, 7, 0, 4);
        board.setPiece(9, 8, 0, 9);
        assertEquals(-1, board.movement(board.getPiece(4, 4), 3, 3));
        assertEquals(0, board.movement(board.getPiece(4, 4), 3, 4));
        assertEquals(-1, board.movement(board.getPiece(2, 2), 5, 5));
        assertEquals(0, board.movement(board.getPiece(2, 2), 2, 5));
        assertEquals(-2, board.movement(board.getPiece(2, 5), 2, 7));
        assertEquals(-1, board.movement(board.getPiece(8, 8), 8, 9));
        assertEquals(-1, board.movement(board.getPiece(9, 9), 8, 9));
        assertEquals(1, board.movement(board.getPiece(1, 7), 0, 7));
    }

}
