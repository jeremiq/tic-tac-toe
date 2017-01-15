package com.jeremiq.tictactoe.game.cell;

import com.jeremiq.tictactoe.game.board.BoardMark;
import com.jeremiq.tictactoe.game.board.InvalidMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    Cell cell;
    BoardMark X;
    BoardMark O;

    @Before
    public void setUp() throws Exception {
        cell = new Cell();
        X = BoardMark.X;
        O = BoardMark.O;
    }

    @Test(expected = CellOccupiedException.class)
    public void testStateChange() throws Exception {
        assertNotEquals(X, cell.getState());
        cell.setState(X);
        assertEquals(X, cell.getState());
        cell.setState(O);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(cell.isEmpty());
        cell.setState(X);
        assertFalse(cell.isEmpty());
    }

}