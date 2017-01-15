package com.jeremiq.tictactoe.game.board;

import com.jeremiq.tictactoe.game.board.Board;
import com.jeremiq.tictactoe.game.board.BoardMark;
import com.jeremiq.tictactoe.game.board.InvalidMoveException;
import com.jeremiq.tictactoe.game.cell.CellCoordinates;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class BoardTest {
    Board board = new Board();
    BoardMark O = BoardMark.O;
    BoardMark X = BoardMark.X;

    @Before
    public void setUp() {
        this.board = new Board();
    }

    @Test
    public void testFreeCellCoordinates() throws Exception {
        assertEquals(9, board.freeCellCoordinates().size());
        board.setCell(5, O);
        assertEquals(8, board.freeCellCoordinates().size());

    }

    @Test
    public void testHasWinner() throws Exception {
        board.setCell(1, O);
        board.setCell(2, O);
        board.setCell(3, O);
        assertTrue(board.hasWinner());
    }

    @Test
    public void testIsFull() throws Exception {
        board.setCell(1, O);
        board.setCell(2, O);
        board.setCell(3, O);
        board.setCell(4, O);
        assertFalse(board.isFull());
        board.setCell(5, O);
        board.setCell(6, O);
        board.setCell(7, O);
        board.setCell(8, O);
        board.setCell(9, O);
        assertTrue(board.isFull());
    }

    @Test
    public void testHasWinningRow() throws Exception {
        assertFalse(board.hasWinningRow());
        board.setCell(4, X);
        board.setCell(5, X);
        board.setCell(6, O);
        assertFalse(board.hasWinningRow());
        board.setCell(1, X);
        assertFalse(board.hasWinningRow());
        board.setCell(2, X);
        assertFalse(board.hasWinningRow());
        board.setCell(3, X);
        assertTrue(board.hasWinningRow());
    }

    @Test
    public void testHasWinningColumn() throws Exception {
        assertFalse(board.hasWinningColumn());
        board.setCell(2, X);
        board.setCell(5, X);
        board.setCell(8, O);
        assertFalse(board.hasWinningColumn());
        board.setCell(1, X);
        assertFalse(board.hasWinningColumn());
        board.setCell(4, X);
        assertFalse(board.hasWinningColumn());
        board.setCell(7, X);
        assertTrue(board.hasWinningColumn());
    }

    @Test
    public void testHasWinningDiagonal() throws Exception {
        assertFalse(board.hasWinningDiagonal());
        board.setCell(3, X);
        board.setCell(5, X);
        board.setCell(7, O);
        assertFalse(board.hasWinningDiagonal());
        board.setCell(1, X);
        assertFalse(board.hasWinningDiagonal());
        board.setCell(9, X);
        assertTrue(board.hasWinningDiagonal());
    }

    @Test
    public void testHasWinningAntiDiagonal() throws Exception {
        assertFalse(board.hasWinningDiagonal());
        board.setCell(1, X);
        board.setCell(5, X);
        board.setCell(9, O);
        assertFalse(board.hasWinningDiagonal());
        board.setCell(3, X);
        assertFalse(board.hasWinningDiagonal());
        board.setCell(7, X);
        assertTrue(board.hasWinningDiagonal());

    }

    @Test
    public void testSetCell() throws Exception {
        BoardMark X = BoardMark.X;
        board.setCell(5, X);
        assertEquals(X, board.cells[1][1].getState());

    }

    @Test(expected = InvalidMoveException.class)
    public void testSetInvalidCell() throws Exception {
        board.setCell(100, X);
    }

    @Test
    public void testGetMoveFromCoordinates() throws Exception {
        assertEquals(1, board.getMoveFromCoordinates(new CellCoordinates(0, 0)));
        assertEquals(2, board.getMoveFromCoordinates(new CellCoordinates(0, 1)));
        assertEquals(3, board.getMoveFromCoordinates(new CellCoordinates(0, 2)));

        assertEquals(4, board.getMoveFromCoordinates(new CellCoordinates(1, 0)));
        assertEquals(5, board.getMoveFromCoordinates(new CellCoordinates(1, 1)));
        assertEquals(6, board.getMoveFromCoordinates(new CellCoordinates(1, 2)));

        assertEquals(7, board.getMoveFromCoordinates(new CellCoordinates(2, 0)));
        assertEquals(8, board.getMoveFromCoordinates(new CellCoordinates(2, 1)));
        assertEquals(9, board.getMoveFromCoordinates(new CellCoordinates(2, 2)));
    }

}