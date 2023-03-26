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

    public boolean getShot(Point shotPoint) {
        if (direction == CardinalPoints.NORTH || direction == CardinalPoints.SOUTH) {
            if (shotPoint.getX() == startPoint.getX() && shotPoint.getY() >= startPoint.getY() && shotPoint.getY() <= endPoint.getY()) {
                hits++;
            }
        } else {
            if (shotPoint.getY() == startPoint.getY() && shotPoint.getX() >= startPoint.getX() && shotPoint.getX() <= endPoint.getX()) {
                hits++;
            }
        }
        return false;
    }

    public boolean isHit(Point point) {
        if (direction == CardinalPoints.NORTH || direction == CardinalPoints.SOUTH) {
            return point.getX() == startPoint.getX() && point.getY() >= startPoint.getY() && point.getY() <= endPoint.getY();
        } else {
            return point.getY() == startPoint.getY() && point.getX() >= startPoint.getX() && point.getX() <= endPoint.getX();
        }
    }

    public Object getHits() {
        return hits;
    }

    public int getLength() {
        return size;
    }

    public void place() {

    }

    public void setBoard(Board board) {

    }
}

