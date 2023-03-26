package org.example;

public class Battleship2 extends Ship {
    private boolean[] isolated; // indica si cada posición aislada ha sido tocada

        public Battleship2(Point start, Point end) {
            super(start, end, 5);
            isolated = new boolean[3];
        }


    @Override
        public boolean getShot(Point shotPoint) {
            boolean hit = super.getShot(shotPoint);
            if (hit) {
                int index = getIsolatedIndex(shotPoint);
                if (index != -1) {
                    isolated[index] = true;
                    if (isIsolatedSunk()) {
                        setSunk(true);
                        return true;
                    }
                }
            }
            return hit;
        }

    private void setSunk(boolean b) {

    }

    private int getIsolatedIndex(Point point) {
            if (point.equals(getStart())) {
                return 0;
            } else if (point.equals(getEnd())) {
                return 2;
            } else {
                Point midPoint = new Point((getStart().getX() + getEnd().getX()) / 2,
                        (getStart().getY() + getEnd().getY()) / 2);
                if (point.equals(midPoint)) {
                    return 1;
                }
            }
            return -1;
        }

    private Point getEnd() {
            return null;
    }

    private Point getStart() {
            return null;
        }



    private boolean isIsolatedSunk() {
            for (boolean isolatedPoint : isolated) {
                if (!isolatedPoint) {
                    return false;
                }
            }
            return true;
        }
    }



