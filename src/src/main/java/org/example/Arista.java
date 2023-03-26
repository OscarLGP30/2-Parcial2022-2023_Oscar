package org.example;

public class Arista {
    private Point start;
    private Point end;

    public Arista(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Arista(String destino, double distancia) {
        this.start = new Point(0, 0);
        this.end = new Point(0, 0);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public boolean equals(Arista other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    public Point getDestino() {
        return end;
    }

    public double getDistancia() {
        return 0;
    }
}
