package manuton.truco;

import java.util.ArrayList;
import java.util.List;

public class Mazo{
    private List<Carta> cartas;

    public Mazo(String juego){
        if (!juego.equals("truco"))
            return;

        List<Carta> mazo = new ArrayList<>();
        List<String> palos = List.of("Oro", "Copa", "Espada", "Basto");
        // System.out.println("Creando Cartas");
        for (String palo : palos){
            for (int i = 1; i <= 12; i++){
                String name = i + " " + palo;
                if (juego.equals("truco")){
                    if (i == 8 || i == 9)
                        continue;
                    mazo.add(new Carta(name, 0));
                }
                // System.out.println(name);
            }
        }
        // System.out.println();

        this.cartas = setValores(mazo, juego);
        this.cartas = cartas;
    }

    private List<Carta> setValores(List<Carta> cartas, String juego){
        if (!juego.equals("truco"))
            return cartas;
        for (Carta carta : cartas){
            if (carta.getName().contains("4"))
                carta.setValor(1);
            else if (carta.getName().contains("5"))
                carta.setValor(2);
            else if (carta.getName().contains("6"))
                carta.setValor(3);
            else if (carta.getName().contains("7")){
                if (carta.getName().contains("Oro"))
                    carta.setValor(11);
                else if (carta.getName().contains("Espada")) {
                    carta.setValor(12);
                } else
                    carta.setValor(4);
                carta.setValor(4);
            }else if (carta.getName().contains("10"))
                carta.setValor(5);
            else if (carta.getName().contains("11"))
                carta.setValor(6);
            else if (carta.getName().contains("12"))
                carta.setValor(7);
            else if (carta.getName().contains("1"))
                if (carta.getName().contains("Basto"))
                    carta.setValor(13);
                else if (carta.getName().contains("Espada")) {
                    carta.setValor(14);
                } else
                    carta.setValor(8);
            else if (carta.getName().contains("2"))
                carta.setValor(9);
            else if (carta.getName().contains("3"))
                carta.setValor(10);
        }
        return cartas;
    }

    public Carta getRamdomCard(){
        int index = (int) (Math.random() * cartas.size());
        this.cartas.remove(index -1);
        return cartas.get(index -1);
    }

    public Mazo getMazo(){
        return this;
    }

    public Mazo setMazo(List<Carta> cartas){
        this.cartas = cartas;
        return this;
    }

    public Mazo devolverCarta(Carta carta){
        this.cartas.add(carta);
        return this;
    }
}
