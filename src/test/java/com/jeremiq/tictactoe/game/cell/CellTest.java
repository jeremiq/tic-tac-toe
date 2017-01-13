package com.jeremiq.tictactoe.game.cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CellTest {
    Cell cell = new Cell();

    @Test
    public void testStateChange() throws Exception {
        CellState testState = CellState.X;
        cell.setState(testState);
        assertEquals(testState, cell.getState());
    }

    @Test
    public void testIsEmpty() throws Exception {
        cell.setState(CellState.EMPTY);
        assertTrue(cell.isEmpty());

    }

}