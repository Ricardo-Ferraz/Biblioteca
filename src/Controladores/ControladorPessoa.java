package Controladores;

import Dados.IRepositorioPessoa;
import Dados.RepositorioPessoa;

import Entidades.Aluno;
import Entidades.Pessoa;

import Entidades.Professor;
import Entidades.Titulo;
import Exception.*;

public class ControladorPessoa {

    private IRepositorioPessoa rep;

    public ControladorPessoa(){
        this.rep = new RepositorioPessoa();
    }

    public ControladorPessoa(RepositorioPessoa rep){
        this.rep = rep;
    }

    //Add Pessoa
    public void adiciona(String nome, String cpf, int idade) throws JaCadastrado, CpfInvalido, CampoVazio{ //Add
        this.rep.adiciona(new Pessoa(nome,cpf,idade));
    }

    //Add Aluno
    public void adiciona(String nome, String cpf, int idade,String matricula) throws JaCadastrado, CpfInvalido, CampoVazio{
        this.rep.adiciona(new Aluno(nome,cpf,idade,matricula));
    }

    //Add Professor
    public void adicionaP(String nome, String cpf, int idade, String id) throws JaCadastrado, CpfInvalido, CampoVazio{
        this.rep.adiciona(new Professor(nome,cpf,idade,id));
    }

    public Pessoa buscaCpf(String buscado) throws CpfNaoEncontrado {
        return this.rep.buscaCpf(buscado);
    }

    private int buscaInt(String buscado){
        return this.rep.buscaInt(buscado);
    }

    //String titulo, String descricao, int qtd, int tempoMax, String id
    public void adicionaLivro(String cpf, String titulo, String descricao, int qtd, int tempoMax, String id) throws CpfNaoEncontrado{
        this.rep.adicionaLivro(cpf, new Titulo(titulo,descricao,qtd,tempoMax,id));
    }

    //Busca livro na lista de livros de Pessoa
    public int buscaLivro(String cpf, String buscado) throws CpfNaoEncontrado, LivroNaoAlugado{
        return this.rep.buscaLivro(cpf,buscado);
    }

    public Titulo devolucaoLivro(String cpf, String buscado) throws LivroNaoEncontrado,LivroNaoAlugado,CpfNaoEncontrado{
        return this.rep.devolucaoLivro(cpf, buscado);
    }

    @Override
    public String toString(){
        return this.rep.toString();
    }
}
