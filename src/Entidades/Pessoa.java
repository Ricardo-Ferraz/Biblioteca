package Entidades;

import java.util.LinkedList;

public class Pessoa implements Comparable<Pessoa>{

    protected String nome;
    protected String cpf;
    protected int idade;
    protected LinkedList<Titulo> titulos;

    public Pessoa(String nome, String cpf, int idade){
        this.nome= nome;
        this.cpf= cpf;
        this.idade= idade;
        titulos = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LinkedList<Titulo> getLivros() {
        return titulos;
    }

    public void setLivros(LinkedList<Titulo> titulos) {
        this.titulos = titulos;
    }

    @Override
    public String toString(){
        String aux="";
        for(int i = 0; i < titulos.size(); i++){
            aux= aux+ titulos.get(i).getTitulo() +" "+ titulos.get(i).getTempoMax()+" dias"+" \n";
        }
        return "Nome: "+this.nome+"\n"+
                "Cpf: "+this.cpf+"\n"+
                "Idade: "+this.idade+"\n"+
                "Situação dos livros: "+aux;
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.getNome().compareToIgnoreCase(o.nome);
    }
}
