package Entidades;

public class Aluno extends Pessoa implements Comparable<Pessoa>{

    private String matricula;

    public Aluno(String nome, String cpf, int idade, String matricula){
        super(nome, cpf, idade);
        this.matricula= matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
                "Matricula: "+this.matricula+"\n"+
                "Situação dos livros: "+aux;
    }
}
