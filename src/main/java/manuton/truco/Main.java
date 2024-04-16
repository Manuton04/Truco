package manuton.truco;

import manuton.truco.Carta;

import java.util.ArrayList;


public class Main {



    public static void main(String[] args) {
        System.out.println("Juego de truco");
        System.out.println();
        System.out.println("Bienvenido a la partida");

        Player Ganador = JuegoTruco();
    }

    public static Player JuegoTruco(){

        Mazo mazo = new Mazo("truco");

        Player player1 = new Player("");
        Player player2 = new Player("");

        while (player1.getScore() < 30 && player2.getScore() < 30){
            if (player1.getScore() != 0 && player2.getScore() != 0) {
                for (Carta carta : player1.getCartas()) {
                    mazo.devolverCarta(carta);
                }
                for (Carta carta : player2.getCartas()) {
                    mazo.devolverCarta(carta);
                }
            }
            player1.setCarta(new ArrayList<>());
            player2.setCarta(new ArrayList<>());

            for (int i = 0; i < 3; i++) {
                player1.addCarta(mazo.getRamdomCard());
                player2.addCarta(mazo.getRamdomCard());
            }

            System.out.println("Jugador 1");
            for (Carta carta : player1.getCartas())
                System.out.println("Carta: " + carta.getName());
            System.out.println();
            System.out.println("Jugador 2");
            for (Carta carta : player2.getCartas())
                System.out.println("Carta: " + carta.getName());
            player1.setScore(30);

        }

        if (player1.getScore() > player2.getScore())
            return player1;
        else
            return player2;
    }
}