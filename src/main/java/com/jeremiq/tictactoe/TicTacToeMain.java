package com.jeremiq.tictactoe;


import com.jeremiq.tictactoe.game.Game;
import com.jeremiq.tictactoe.game.board.Board;
import com.jeremiq.tictactoe.game.board.BoardMark;
import com.jeremiq.tictactoe.game.players.HumanPlayer;
import com.jeremiq.tictactoe.game.players.RandomPlayer;

public class TicTacToeMain {

    public static void main(String[] args) {
        // TODO add configurable selection of automated opponent.
        // TODO add live restart 'play-again' option at the end of each game.
        new Game(new Board(), new HumanPlayer(BoardMark.X, System.in), new RandomPlayer(BoardMark.O));
    }
}