package com.jeremiq.tictactoe.game.players;


import com.jeremiq.tictactoe.game.Board;

public interface Player {
    int getMove(Board board);
}
