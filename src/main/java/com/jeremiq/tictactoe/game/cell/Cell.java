package com.jeremiq.tictactoe.game.cell;

public class Cell {
    private static final String EMPTY = " ";
    private  static final String X = "X";
    private static final String O = "O";
    private CellState state;

    public Cell() {
        setState(CellState.EMPTY);
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public boolean isEmpty() {
        return state == CellState.EMPTY;
    }

    public void render() {
        switch (this.state) {
            case EMPTY:
                System.out.print(EMPTY);
                break;
            case X:
                System.out.print(X);
                break;
            case O:
                System.out.print(O);
                break;
        }
    }
}
