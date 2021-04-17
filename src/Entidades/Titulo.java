package Entidades;

public class Titulo implements Comparable<Titulo>{

    private String titulo;
    private String descricao;
    private int qtd;
    private int tempoMax;
    private String id;

    public Titulo(String titulo, String descricao, int qtd, int tempoMax, String id){
        this.titulo= titulo;
        this.descricao= descricao;
        this.qtd= qtd;
        this.tempoMax= tempoMax;
        this.id= id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getTempoMax() {
        return tempoMax;
    }

    public void setTempoMax(int tempoMax) {
        this.tempoMax = tempoMax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Titulo: "+this.titulo+"\n"+
                "Descrição: "+this.descricao+"\n"+
                "Quantidade em estoque: "+this.qtd+"\n"+
                "Tempo máximo de empréstimo: "+this.tempoMax+"\n"+
                "Id: "+this.id;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getTitulo().compareToIgnoreCase(o.titulo);
    }
}
