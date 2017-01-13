package com.jeremiq.tictactoe.game;


public class InvalidMoveException extends Exception {
   public  InvalidMoveException(String message) {
        super(message);
    }
}
