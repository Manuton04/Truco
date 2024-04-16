package manuton.truco;

public class Carta {

    private int valor;
    private final String name;

    public Carta(String name, int valor){
        this.name = name;
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public String getName(){
        return name;
    }
}
