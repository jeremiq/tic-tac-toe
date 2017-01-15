package com.jeremiq.tictactoe.game.players;

import com.jeremiq.tictactoe.game.board.Board;
import com.jeremiq.tictactoe.game.board.BoardMark;

public abstract class Player {
    private BoardMark mark;

    public Player(BoardMark mark) {
        this.mark = mark;
    }

    public BoardMark getMark() {
        return mark;
    }

    ;

    public abstract int getMove(Board board);
}
