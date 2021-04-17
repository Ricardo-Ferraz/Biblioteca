package Repositorios;

import Entidades.Titulo;
import Entidades.Pessoa;
import Exception.JaCadastrado;
import Exception.CpfInvalido;
import Exception.CampoVazio;
import Exception.CpfNaoEncontrado;
import Exception.LivroNaoEncontrado;

import java.util.Collections;
import java.util.LinkedList;

public class RepositorioPessoa {

    private LinkedList<Pessoa> pessoas;

    public RepositorioPessoa() {
        this.pessoas = new LinkedList<>();
    }

    public void adiciona(Pessoa p) throws JaCadastrado, CpfInvalido, CampoVazio{
        int i= buscaInt(p.getCpf());

        if(p.getCpf().equals("") || p.getNome().equals("") || p.getIdade()==0 ){
            throw new CampoVazio();
        }

        if(p.getCpf().length() > 11 || p.getCpf().length() < 11){
            throw new CpfInvalido();
        }

        if(i == -1){
            this.pessoas.add(p);
            Collections.sort(pessoas);
        }
        else{
            throw new JaCadastrado();
        }
    }

    public Pessoa buscaCpf(String buscado) throws CpfNaoEncontrado {
        int i= buscaInt(buscado);
        if(i != -1){
            return pessoas.get(i);
        }
        else{
            throw new CpfNaoEncontrado();
        }
    }

    private int buscaInt(String buscado){
        for(int i= 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getCpf().equalsIgnoreCase(buscado)){
                return i;
            }
        }
        return -1;
    }

    public void adicionaLivro(String cpf, Titulo l) throws CpfNaoEncontrado{
        int i= buscaInt(cpf);
        if(i != -1){
            pessoas.get(i).getLivros().add(l);
            Collections.sort(pessoas.get(i).getLivros());
        }
        else{
            throw new CpfNaoEncontrado();
        }
    }

    public int buscaLivro(String cpf, String buscado){
        for(int i=0; i < pessoas.size(); i++){
            if(pessoas.get(i).getCpf().equalsIgnoreCase(cpf)){
                for(int j=0; j < pessoas.get(i).getLivros().size(); j++){
                    if(pessoas.get(j).getLivros().get(j).getId().equalsIgnoreCase(buscado)){
                        return i;
                    }
                    else{

                    }
                }
            }
            else{

            }
        }
        return -1;
    }

    public Titulo devolucaoLivro(String cpf, String buscado) throws LivroNaoEncontrado{
        int i= buscaLivro(cpf, buscado);
        int j= buscaInt(cpf);
        if(j != -1){
            Titulo aux= pessoas.get(j).getLivros().get(i);
            pessoas.get(j).getLivros().remove(i);
            return aux;
        }
        else{
            throw new LivroNaoEncontrado();
        }
    }

    @Override
    public String toString(){
        String aux="";
        for(int i= 0; i < pessoas.size(); i++){
            aux= aux + pessoas.get(i).toString()+"\n"+"\n";
        }
        return aux;
    }
}
