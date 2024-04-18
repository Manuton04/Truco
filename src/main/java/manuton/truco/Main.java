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
        Mazo mesa = new Mazo(new ArrayList<>());

        Player player1 = new Player("");
        Player player2 = new Player("");
        int Mano;

        int round = 0;

        while (player1.getScore() < 30 && player2.getScore() < 30){

            round++;
            if (round % 2 != 0){
                Mano = 1;
            }else
                Mano = 2;


            if (player1.getScore() != 0 && player2.getScore() != 0) {
                for (Carta cartaMesa : mesa.getCartas()) {
                    mazo.devolverCarta(cartaMesa);
                }
                for (Carta carta : player1.getCartas()) {
                    mazo.devolverCarta(carta);
                }
                for (Carta carta : player2.getCartas()) {
                    mazo.devolverCarta(carta);
                }
            }
            player1.setCartas(new ArrayList<>());
            player2.setCartas(new ArrayList<>());

            for (int i = 0; i < 3; i++) {
                player1.addCarta(mazo.getRamdomCard());
                player2.addCarta(mazo.getRamdomCard());
            }



            System.out.println("Jugador 1");
            //for (Carta carta : player1.getCartas())
            //    System.out.println("Carta: " + carta.getName());
            //System.out.println();

            for (Carta carta : player1.getCartas())
                imprimirCarta(carta);
            /*System.out.println("Jugador 2");
            for (Carta carta : player2.getCartas())
                System.out.println("Carta: " + carta.getName());
            */
            player1.setScore(30);

        }

        if (player1.getScore() > player2.getScore())
            return player1;
        else
            return player2;
    }

    public static void imprimirCarta(Carta carta) {
        int largo = 9;

        String[] div = carta.getName().split(" ");
        String num = div[0];
        String palo = div[1];
        System.out.print(" ");
        for (int i = 0; i < largo; i++)
            System.out.print("_");
        System.out.println(" ");
        System.out.print("|" + num);
        for (int i = 0; i < largo - num.length(); i++)
            System.out.print(" ");
        System.out.println("|");
        System.out.print("|");
        for (int i = 0; i < largo; i++)
            System.out.print(" ");
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < (largo - palo.length()) / 2; i++)
            System.out.print(" ");
        System.out.print(palo);
        if (palo.length() % 2 != 0)
            for (int i = 0; i < (largo - palo.length()) / 2; i++)
                System.out.print(" ");
        else
            for (int i = 0; i < (largo - palo.length()) / 2 + 1; i++)
                System.out.print(" ");
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < largo; i++)
            System.out.print(" ");
        System.out.println("|");
        System.out.print("|");
        for (int i = 0; i < largo - num.length(); i++)
            System.out.print(" ");
        System.out.println(num + "|");
        System.out.print(" ");
        for (int i = 0; i < largo; i++)
            System.out.print("¯");
        System.out.println(" ");
    }
}