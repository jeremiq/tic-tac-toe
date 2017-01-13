package com.jeremiq.tictactoe.game.players;


import com.jeremiq.tictactoe.game.Board;

import java.util.Arrays;
import java.util.Collections;

public class RandomPlayer implements Player {

    @Override
    public int getMove(Board board) {
        Object[] possibleMoves = getPossibleMoves(board);
        Collections.shuffle(Arrays.asList(possibleMoves));
        return (int) possibleMoves[0];
    }

    Object[] getPossibleMoves(Board board) {
        return board.freeCellCoordinates()
                    .stream()
                    .map(coordinates ->  board.getMoveFromCoordinates(coordinates)).toArray();
    }


}
