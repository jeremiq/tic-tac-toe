package com.jeremiq.tictactoe.game.cell;

import com.jeremiq.tictactoe.game.board.BoardMark;

public class Cell {
    private BoardMark state;

    public BoardMark getState() {
        return state;
    }

    public void setState(BoardMark state) throws CellOccupiedException {
        if (this.isEmpty()) {
            this.state = state;
        } else {
            throw new CellOccupiedException("Cell is already occupied.");
        }
    }
    public boolean isEmpty() {
        return state == null;
    }
}
