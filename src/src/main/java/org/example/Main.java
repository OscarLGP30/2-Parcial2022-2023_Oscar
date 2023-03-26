package org.example;

import java.util.Scanner;

public class Main {
    private static Point randomPoint;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configuración de barcos del primer jugador
        System.out.println("Jugador 1: Introduce la configuración de tus barcos");
        Board board1 = new Board();
        // Pedir al usuario la configuración de sus barcos
        

        // Configuración de barcos del segundo jugador
        System.out.println("Jugador 2: Introduce la configuración de tus barcos");
        Board board2 = new Board();
        // Pedir al usuario la configuración de sus barcos
        // ...

        // Comenzar el juego
        boolean gameFinished = false;
        while (!gameFinished) {
            // Turno del jugador 1
            Point shot1 = getRandomPoint();
            board2.getShot(shot1);
            System.out.println("Jugador 1 ataca en la posición " + shot1.toString() + ":");
            board2.printBoard();
            if (board2.allShipsSunk()) {
                System.out.println("¡Jugador 1 ha ganado!");
                gameFinished = true;
                break;
            }

            // Turno del jugador 2
            Point shot2 = getRandomPoint();
            board1.getShot(shot2);
            System.out.println("Jugador 2 ataca en la posición " + shot2.toString() + ":");
            board1.printBoard();
            if (board1.allShipsSunk()) {
                System.out.println("¡Jugador 2 ha ganado!");
                gameFinished = true;
                break;
            }
        }
    }

    private static Point getRandomPoint() {
        // Generar un punto aleatorio en el tablero
        return randomPoint;
    }
}

