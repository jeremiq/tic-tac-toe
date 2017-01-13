package com.jeremiq.tictactoe.game;

import com.jeremiq.tictactoe.game.cell.CellState;
import com.jeremiq.tictactoe.game.players.Player;

public class Game {
    GameState currentState = GameState.PLAYING;
    CellState currentMark = CellState.X;
    Player player1;
    Player player2;
    Player currentPlayer;


    public Game(Board board, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        do {
            try {
                playRound(board);
            } catch (InvalidMoveException ime) {
                System.out.println(ime.getMessage() + " Try again.");
                }
        } while (currentState == GameState.PLAYING);
    }

    private void playRound(Board board) throws InvalidMoveException {
        board.render();
        int playerMove = currentPlayer.getMove(board);
        board.setCell(playerMove, currentMark);
        updateGameState(board);
    }

    private void updateGameState(Board board) {
        if (board.hasWinner()) {
            System.out.println("\nPlayer " + currentMark + " has won.");
            board.render();
            currentState = GameState.WON;
        }

        if (!board.hasWinner() && board.isFull()) {
            System.out.println("\nIt's a tie!");
            currentState = GameState.TIE;
        }
        if (!board.hasWinner() && !board.isFull()) {
            swapPlayer();
        }
    }

    private void swapPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        currentMark = (currentMark == CellState.X) ? CellState.O : CellState.X;
    }


}
