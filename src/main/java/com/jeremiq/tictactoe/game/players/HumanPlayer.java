package com.jeremiq.tictactoe.game.players;

import com.jeremiq.tictactoe.game.Board;

import java.util.Scanner;


public class HumanPlayer implements Player {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getMove(Board board) {
        String input;
        do {
            promptMove();
            input = scanner.next();
        } while (!isValidMove(input));
        return Integer.parseInt(input);
    }

    boolean isValidMove(String input) {
        try {
            int move = Integer.parseInt(input);
            if (move <= 0 || move > 9) {
                System.out.println("Input must be between 1 and 9.");
                return false;
            }
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Input must be a number (0-9).");
            return false;
        }

    }

    private void promptMove() {
        System.out.print("\nEnter your next getMove (1-9): ");
    }

}
