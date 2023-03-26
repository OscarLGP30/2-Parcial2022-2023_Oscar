package org.example;
import java.util.Scanner;



public class Battleship {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Creamos dos usuarios y les asignamos sus respectivos tableros
            User user1 = new User("Player 1");
            user1.setBoard(new Board(10, 10));
            User user2 = new User("Player 2");
            user2.setBoard(new Board(10, 10));

            // Colocamos los barcos del usuario 1
            System.out.println("Player 1, place your ships:");
            user1.placeShips();

            // Colocamos los barcos del usuario 2
            System.out.println("Player 2, place your ships:");
            user2.placeShips();

            // Comenzamos el juego
            User currentPlayer = user1;
            while (!user1.hasLost() && !user2.hasLost()) {
                // Cambiamos de jugador
                if (currentPlayer == user1) {
                    currentPlayer = user2;
                } else {
                    currentPlayer = user1;
                }

                // Mostramos el tablero del jugador actual
                System.out.println(currentPlayer.getName() + ", it's your turn!");
                currentPlayer.getBoard().printBoard();

                // Preguntamos al jugador dónde quiere disparar
                System.out.println("Enter coordinates for your shot:");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point shotPoint = new Point(x, y);

                // Disparamos
                currentPlayer.fireShot(shotPoint);
            }

            // Mostramos quién ha ganado
            if (user1.hasLost()) {
                System.out.println(user2.getName() + " has won the game!");
            } else {
                System.out.println(user1.getName() + " has won the game!");
            }
            System.out.println("Thanks for playing!");
            // llamamos al metodo printShipsAndShotsWithStatusAndHitsAndDirectionAndPointsAndUser
            user1.ShipsAndShotsWithStatusAndHitsAndDirectionAndPointsAndUser();
            user2.ShipsAndShotsWithStatusAndHitsAndDirectionAndPointsAndUser();


        }
    }
