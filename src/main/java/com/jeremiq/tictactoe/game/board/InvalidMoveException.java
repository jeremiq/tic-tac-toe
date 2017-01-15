package com.jeremiq.tictactoe.game.board;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}
