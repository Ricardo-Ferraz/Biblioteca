package Entidades;

public class Professor extends Pessoa implements Comparable<Pessoa>{

    private String id;

    public Professor(String nome, String cpf, int idade, String id){
        super(nome,cpf, idade);
        this.id= id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        String aux="";
        for(int i = 0; i < titulos.size(); i++){
            aux= aux+ titulos.get(i).getTitulo() +" "+ titulos.get(i).getTempoMax()+", dias"+" \n";
        }
        return "Nome: "+this.nome+"\n"+
                "Cpf: "+this.cpf+"\n"+
                "Idade: "+this.idade+"\n"+
                "ID: "+this.id+"\n"+
                "Situação dos livros: "+aux;
    }
}
