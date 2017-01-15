package com.jeremiq.tictactoe.game.players;

import com.jeremiq.tictactoe.game.board.Board;
import com.jeremiq.tictactoe.game.board.BoardMark;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RandomPlayerTest {
    Board board = new Board();
    RandomPlayer player = new RandomPlayer(BoardMark.O);

    @Test
    public void testGetPossibleMoves() throws Exception {
        assertEquals(board.freeCellCoordinates().size(), player.getPossibleMoves(board).length);
    }

}