package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int numRows;
    private final int numCols;
    private final List<Ship> ships;
    private final List<Point> shots;

    private int[][] board;

    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.ships = new ArrayList<>();
        this.shots = new ArrayList<>();
    }

    public Board() {
        this(10, 10);
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Point> getShots() {
        return shots;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean isShotInBoard(Point shotPoint) {
        int x = shotPoint.getX();
        int y = shotPoint.getY();
        return x >= 0 && x < numRows && y >= 0 && y < numCols;
    }

    public boolean isShotAlreadyTaken(Point shotPoint) {
        return shots.contains(shotPoint);
    }

    public boolean isShipHit(Point shotPoint) {
        for (Ship ship : ships) {
            if (ship.getShot(shotPoint)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAllShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getShot(Point shot1) {
        shots.add(shot1);

        if (isShipHit(shot1)) {
            board[shot1.getX()][shot1.getY()] = 1;
        } else {
            board[shot1.getX()][shot1.getY()] = 2;
        }

        printBoard();

        if (isAllShipsSunk()) {
            System.out.println("You have sunk all the ships!");
        }
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
