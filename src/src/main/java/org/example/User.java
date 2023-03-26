package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Ship> ships;
    private List<Point> shots;

    private  Board board;

    public User(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void addShot(Point shot) {
        shots.add(shot);
    }

    public boolean hasShip(Point point) {
        for (Ship ship : ships) {
            if (ship.isHit(point)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasShot(Point point) {
        for (Point shot : shots) {
            if (shot.equals(point)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasLost() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }

        return true;
    }

    public void getShot(Point shot) {
        for (Ship ship : ships) {
            ship.getShot(shot);
        }
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Point> getShots() {
        return shots;
    }

    public void printShips() {
        for (Ship ship : ships) {
            System.out.println(ship);
        }
    }

    public void printShots() {
        for (Point shot : shots) {
            System.out.println(shot);
        }
    }

    public void printShipsAndShots() {
        for (Ship ship : ships) {
            System.out.println(ship);
        }

        for (Point shot : shots) {
            System.out.println(shot);
        }
    }

    public void printShipsAndShotsWithStatus() {
        for (Ship ship : ships) {
            System.out.println(ship + " " + (ship.isSunk() ? "sunk" : "not sunk"));
        }

        for (Point shot : shots) {
            System.out.println(shot);
        }
    }

    public void printShipsAndShotsWithStatusAndHits() {
        for (Ship ship : ships) {
            System.out.println(ship + " " + (ship.isSunk() ? "sunk" : "not sunk") + " " + ship.getHits() + "/" + ship.getSize());
        }

        for (Point shot : shots) {
            System.out.println(shot);
        }
    }

    public void printShipsAndShotsWithStatusAndHitsAndDirection() {
        for (Ship ship : ships) {
            System.out.println(ship + " " + (ship.isSunk() ? "sunk" : "not sunk") + " " + ship.getHits() + "/" + ship.getSize() + " " + ship.getDirection());
        }

        for (Point shot : shots) {
            System.out.println(shot);
        }
    }

    public void printShipsAndShotsWithStatusAndHitsAndDirectionAndPoints() {
        for (Ship ship : ships) {
            System.out.println(ship + " " + (ship.isSunk() ? "sunk" : "not sunk") + " " + ship.getHits() + "/" + ship.getSize() + " " + ship.getDirection() + " " + ship.getStartPoint() + " " + ship.getEndPoint());
        }

        for (Point shot : shots) {
            System.out.println(shot);
        }
    }

    public void ShipsAndShotsWithStatusAndHitsAndDirectionAndPointsAndUser() {
        for (Ship ship : ships) {
            System.out.println(ship + " " + (ship.isSunk() ? "sunk" : "not sunk") + " " + ship.getHits() + "/" + ship.getSize() + " " + ship.getDirection() + " " + ship.getStartPoint() + " " + ship.getEndPoint() + " " + name);
        }

        for (Point shot : shots) {
            System.out.println(shot);
        }
    }



    public void placeShips() {
        for (Ship ship : ships) {
            ship.place();
        }
    }

    public void setBoard(Board board) {
        for (Ship ship : ships) {
            ship.setBoard(board);
        }
    }



    public void fireShot(Point shotPoint) {
        addShot(shotPoint);
    }


    public Board getBoard() {
        return board;
    }
}




