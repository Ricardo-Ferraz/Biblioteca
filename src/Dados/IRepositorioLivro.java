package Dados;

import Entidades.Titulo;

import Exception.*;

public interface IRepositorioLivro {

     void adiciona(Titulo l) throws JaCadastrado, CampoVazio, NegativoDetectado;

     Titulo buscaId(String buscado) throws LivroNaoEncontrado;

     void aluga(String buscado) throws LivroNaoEncontrado, LivroEsgotado;

     void devolve(Titulo l) throws LivroNaoEncontrado;

     int buscaInt(String buscado);
}
