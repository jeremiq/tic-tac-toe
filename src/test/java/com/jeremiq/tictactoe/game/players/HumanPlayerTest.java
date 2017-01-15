package com.jeremiq.tictactoe.game.players;


import com.jeremiq.tictactoe.game.board.BoardMark;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HumanPlayerTest  {
    HumanPlayer humanPlayer = new HumanPlayer(BoardMark.X, System.in);
    @Test
    public void testIsValidMove() throws Exception {
        assertTrue(humanPlayer.isValidMove("9"));
        assertFalse(humanPlayer.isValidMove("10000"));
    }

}