package org.example;

public class Ship {
    private Point startPoint;
    private Point endPoint;
    private CardinalPoints direction;
    private int size;
    private int hits;

    public Ship(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        if (startPoint.getX() == endPoint.getX()) {
            this.direction = CardinalPoints.NORTH;
            this.size = Math.abs(startPoint.getY() - endPoint.getY()) + 1;
        } else if (startPoint.getY() == endPoint.getY()) {
            this.direction = CardinalPoints.EAST;
            this.size = Math.abs(startPoint.getX() - endPoint.getX()) + 1;
        } else {
            throw new IllegalArgumentException("Ship must be placed horizontally or vertically.");
        }

        this.hits = 0;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public int getSize() {
        return size;
    }

    public boolean isSunk() {
        return hits >= size;
    }

    public void getShot(Point shotPoint) {
        if (direction == CardinalPoints.NORTH || direction == CardinalPoints.SOUTH) {
            if (shotPoint.getX() == startPoint.getX() && shotPoint.getY() >= startPoint.getY() && shotPoint.getY() <= endPoint.getY()) {
                hits++;
            }
        } else {
            if (shotPoint.getY() == startPoint.getY() && shotPoint.getX() >= startPoint.getX() && shotPoint.getX() <= endPoint.getX()) {
                hits++;
            }
        }
    }
}

