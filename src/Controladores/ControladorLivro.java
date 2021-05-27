package Controladores;

import Dados.IRepositorioLivro;
import Dados.RepositorioLivro;

import Entidades.Titulo;

import Exception.*;

public class ControladorLivro {

    private IRepositorioLivro rep;

    public ControladorLivro(){
        this.rep= new RepositorioLivro();
    }

    //public Titulo(String titulo, String descricao, int qtd, int tempoMax, String id)
    public void adiciona(String titulo, String descricao, int qtd, int tempoMax, String id) throws JaCadastrado, CampoVazio, NegativoDetectado {
        this.rep.adiciona(new Titulo(titulo,descricao,qtd,tempoMax,id));
    }

    public Titulo buscaId(String buscado) throws LivroNaoEncontrado {
        return this.rep.buscaId(buscado);
    }

    public void aluga(String buscado) throws LivroNaoEncontrado, LivroEsgotado{
        this.rep.aluga(buscado);
    }

    public void devolve(String titulo, String descricao, int qtd, int tempoMax, String id) throws LivroNaoEncontrado{
        this.rep.devolve(new Titulo(titulo,descricao,qtd,tempoMax,id));
    }

    public int buscaInt(String buscado){
        return this.rep.buscaInt(buscado);
    }

    @Override
    public String toString(){
        return this.rep.toString();
    }
}
