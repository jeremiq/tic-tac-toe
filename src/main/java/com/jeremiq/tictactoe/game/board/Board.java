package com.jeremiq.tictactoe.game.board;


import com.jeremiq.tictactoe.game.cell.Cell;
import com.jeremiq.tictactoe.game.cell.CellCoordinates;
import com.jeremiq.tictactoe.game.cell.CellOccupiedException;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Board {
    private static final String columnDelimiter = "|";
    private static final String rowDelimiter = "-----";
    private static final String emptyCell = " ";

    private static final int rowCount = 3;
    private static final int columnCount = 3;
    Cell[][] cells = new Cell[rowCount][columnCount];


    public Board() {
        clear();
    }

    public Collection<CellCoordinates> freeCellCoordinates() {
        Collection<CellCoordinates> freeCellCoordinates = new HashSet<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (cells[i][j].getState() == null) {
                    freeCellCoordinates.add(new CellCoordinates(i, j));
                }
            }
        }
        return freeCellCoordinates;
    }

    public Boolean hasWinner() {
        return hasWinningColumn() || hasWinningRow() || hasWinningDiagonal();
    }


    public Boolean isFull() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (cells[i][j].getState() == null)
                    return false;
            }
        }
        return true;
    }

    Boolean hasWinningRow() {
        return IntStream.range(0, rowCount)
                .mapToObj(rowNumber -> (cells[rowNumber][0].getState() != null
                        && cells[rowNumber][0].getState() == cells[rowNumber][1].getState()
                        && cells[rowNumber][0].getState() == cells[rowNumber][2].getState())
                )
                .reduce(false, (a, b) -> a || b);
    }

    Boolean hasWinningColumn() {
        return IntStream.range(0, columnCount)
                .mapToObj(columnNumber -> (cells[0][columnNumber].getState() != null
                        && cells[0][columnNumber].getState() == cells[1][columnNumber].getState()
                        && cells[0][columnNumber].getState() == cells[2][columnNumber].getState())
                )
                .reduce(false, (a, b) -> a || b);

    }

    Boolean hasWinningDiagonal() {
        Boolean primaryDiagonal = (cells[1][1].getState() != null &&
                cells[0][0].getState() == cells[1][1].getState() &&
                cells[1][1].getState() == cells[2][2].getState());
        Boolean antiDiagonal = (cells[1][1].getState() != null &&
                cells[1][1].getState() == cells[2][0].getState() &&
                cells[1][1].getState() == cells[0][2].getState());
        return primaryDiagonal || antiDiagonal;
    }


    public void setCell(int move, BoardMark boardMark) throws CellOccupiedException, InvalidMoveException {
        Cell cell = getCell(move, cells);
        cell.setState(boardMark);
    }

    public int getMoveFromCoordinates(CellCoordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        switch (x) {
            case 0:
                return y + 1;
            case 1:
                return y + 4;
            case 2:
                return y + 7;
        }
        return -1;
    }

    private CellCoordinates getCellCoordinates(int move) throws InvalidMoveException {
        CellCoordinates coordinates = new CellCoordinates(-1, -1);
        if (move < 1 || move > 9) {
            throw new InvalidMoveException("Move " + move + " is invalid. Moves must be between 1 and 9, inclusive.");
        }

        if (move >= 1 && move <= 3) {
            coordinates.setX(0);
            coordinates.setY(move - 1);
        }
        if (move > 3 && move <= 6) {
            coordinates.setX(1);
            coordinates.setY(move - 4);
        }
        if (move > 6 && move <= 9) {
            coordinates.setX(2);
            coordinates.setY(move - 7);
        }
        return coordinates;
    }

    private Cell getCell(int move, Cell[][] cells) throws InvalidMoveException {
        CellCoordinates coordinates = getCellCoordinates(move);
        return cells[coordinates.getX()][coordinates.getY()];
    }

    public void render() {
        for (int i = 0; i < rowCount; i++) {
            System.out.println();
            if (i > 0) {
                System.out.println(rowDelimiter);
            }
            for (int j = 0; j < columnCount; j++) {
                if (j > 0) {
                    System.out.print(columnDelimiter);
                }
                System.out.print(cells[i][j].getState() == null ? emptyCell: cells[i][j].getState());
            }
        }
        System.out.println();
    }


    private void clear() {
        IntStream.range(0, rowCount).
                forEach(i -> IntStream.range(0, columnCount)
                        .forEach(j -> cells[i][j] = new Cell()));
    }
}
