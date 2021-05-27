package Dados;

import Entidades.Pessoa;

import Entidades.Titulo;
import Exception.*;

public interface IRepositorioPessoa {

     void adiciona(Pessoa p) throws JaCadastrado, CpfInvalido, CampoVazio;

     Pessoa buscaCpf(String buscado) throws CpfNaoEncontrado;

     void adicionaLivro(String cpf, Titulo l) throws CpfNaoEncontrado;

     int buscaLivro(String cpf, String buscado) throws CpfNaoEncontrado, LivroNaoAlugado;

     Titulo devolucaoLivro(String cpf, String buscado) throws LivroNaoEncontrado, LivroNaoAlugado, CpfNaoEncontrado;

     int buscaInt(String buscado);
}
