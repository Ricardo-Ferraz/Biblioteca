package Entidades;

public class Periodico extends Titulo implements Comparable<Titulo>{

    public Periodico(String titulo, String descricao, int qtd, int tempoMax, String id){
        super(titulo, descricao, qtd, tempoMax, id);
    }
}
