package manuton.truco;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int Score;
    private List<Carta> carta;

    public Player(String name){
        this.name = name;
        this.Score = 0;
        this.carta = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return Score;
    }

    public void setScore(int Score){
        this.Score = Score;
    }

    public List<Carta> getCartas(){
        return carta;
    }

    public void setCarta(List<Carta> carta){
        this.carta = carta;
    }

    public void setCarta (Carta carta, int index){
        this.carta.set(index, carta);
    }

    public void addCarta(Carta carta){
        this.carta.add(carta);
    }

    public void addScore(int Score){
        this.Score += Score;
    }

    public void removeScore(int Score){
        this.Score -= Score;
    }

}
