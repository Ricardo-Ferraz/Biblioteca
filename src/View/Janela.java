package View;

import Entidades.*;
import Repositorios.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

    private Contador c = new Contador();

    private JTextField text = new JTextField(20);
    private JTextField text2= new JTextField(20);
    private JPasswordField senha= new JPasswordField(20);

    private Object[] entradas = {"Informe seu CPF: ", text, "Informe o ID do titulo: ", text2};
    private Object[] entradaLogin= {"Informe o User: ", text, "Informe a senha: ", senha};

    private JButton b1= new JButton("Exibir");
    private JButton b2= new JButton("Alugar");
    private JButton b3= new JButton("Situação");
    private JButton b4= new JButton("Devolução");
    private JButton b5= new JButton("Admin");

    private RepositorioLivro repLivro = new RepositorioLivro();
    private RepositorioPessoa repositorioPessoa = new RepositorioPessoa();

    private Dimension dimension = new Dimension(300,300);
    
    public Janela(){
        c.start();
        try{
            repLivro.adiciona(new Titulo("Ednaldo", "Pereira ataca o imperio do mal", 100, 20, "1"));
            repLivro.adiciona(new Titulo("O Mestre", "A volta do velho", 5, 20, "2"));
            repLivro.adiciona(new Titulo("Cuca, a vingaça do pelo", "Ele está de volta e quer sua vingança", 100, 20, "3"));
            repLivro.adiciona(new Titulo("Paula, o encontro", "Fátima chama para conversar", 100, 20, "5"));
            repLivro.adiciona(new Titulo("Naruto", "Jovem demoníaco", 100, 20, "4"));
            repLivro.adiciona(new Titulo("Pedão, o Cacíque Estrelar", "História do jovem cacíque que quer conquistar as estrelas", 100, 20, "21"));
            repLivro.adiciona(new Titulo("Guiba, Beltrão", "O menino que fez 5 cirurgias de fimose", 100, 20, "22"));
            repLivro.adiciona(new Titulo("Grongos, The Story", "Ele comba fofo", 100, 20, "29"));
            repLivro.adiciona(new Periodico("Alan, O Mãos leve", "Foi acusado injustamente", 100, 20, "24"));

            repositorioPessoa.adiciona(new Professor("Paula", "12345678910", 43, "74644903"));
            repositorioPessoa.adiciona(new Aluno("Cassio", "70738473448", 21, "2019107880"));
            repositorioPessoa.adiciona(new Pessoa("Carlos", "44455566677", 19));
            repositorioPessoa.adiciona(new Pessoa("Silvestre Estálonge", "44425566677", 19));
            repositorioPessoa.adiciona(new Pessoa("Tabela", "41455566677", 19));
        }catch (Exception e){
            e.printStackTrace();
        }
        this.setLayout(null);
        this.b1.setBounds(100, 30, 100,50);
        this.b1.addActionListener(this);
        this.b2.setBounds(300,30,100,50);
        this.b2.addActionListener(this);
        this.b3.setBounds(100, 300, 100, 50);
        this.b3.addActionListener(this);
        this.b4.setBounds(300, 300, 100, 50);
        this.b4.addActionListener(this);
        this.b5.setBounds(200, 160, 100, 50);
        this.b5.addActionListener(this);
        this.getContentPane().add(b1);
        this.getContentPane().add(b2);
        this.getContentPane().add(b3);
        this.getContentPane().add(b4);
        this.getContentPane().add(b5);
        this.getContentPane().add(c.getHora());
        this.setSize(500,500);
        this.setTitle("Edioteca");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.b1){
            JTextArea texto = new JTextArea(this.repLivro.toString());
            JScrollPane scroll = new JScrollPane(texto);
            texto.setEditable(false);
            scroll.setPreferredSize(this.dimension);
            JOptionPane.showMessageDialog(null, scroll, "Titulos cadastrados",JOptionPane.UNDEFINED_CONDITION);
        }

        else if(e.getSource() == this.b2){
            try{
               int opcao = JOptionPane.showConfirmDialog(null, this.entradas, "Informe o ID do Titulo escolhido", JOptionPane.OK_CANCEL_OPTION);
               if(opcao == JOptionPane.OK_OPTION){
                   this.repLivro.aluga(this.text2.getText());
                   this.repositorioPessoa.adicionaLivro(this.text.getText(), this.repLivro.buscaId(this.text2.getText()));
                   JOptionPane.showMessageDialog(null, "Prazo Máximo para devolução do titulo "+this.repLivro.buscaId(this.text2.getText()).getTitulo()+" é de, máximo, "+this.repLivro.buscaId(this.text2.getText()).getTempoMax()+" dias!","Titulo alugado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
               }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            this.text.setText("");
            this.text2.setText("");
        }

        else if(e.getSource() == this.b3){
            try{
                int opcao = JOptionPane.showConfirmDialog(null, this.text, "Informe seu CPF", JOptionPane.OK_CANCEL_OPTION);
                if(opcao == JOptionPane.OK_OPTION) {
                    JTextArea texto = new JTextArea(this.repositorioPessoa.buscaCpf(this.text.getText()).toString());
                    JScrollPane scroll = new JScrollPane(texto);
                    texto.setEditable(false);
                    scroll.setPreferredSize(this.dimension);
                    JOptionPane.showMessageDialog(null,scroll, "Situação", JOptionPane.UNDEFINED_CONDITION);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            this.text.setText("");
        }

        else if(e.getSource() == this.b4){
            try{
                int opcao = JOptionPane.showConfirmDialog(null, this.entradas, "Informe o ID do Titulo escolhido", JOptionPane.OK_CANCEL_OPTION);
                if(opcao == JOptionPane.OK_OPTION){
                    this.repositorioPessoa.buscaCpf(this.text.getText());
                    this.repLivro.buscaId(text2.getText());
                    this.repLivro.devolve(this.repositorioPessoa.devolucaoLivro(this.text.getText(),this.text2.getText()));
                    JOptionPane.showConfirmDialog(null, "Devolução feita com sucesso!", "Sucesso!", JOptionPane.UNDEFINED_CONDITION);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            this.text.setText("");
            this.text2.setText("");
        }

        else if(e.getSource() == this.b5){
            Admin admin= new Admin(this.repositorioPessoa, this.repLivro);
            try{
                int opcao = JOptionPane.showConfirmDialog(null, this.entradaLogin, "Informe os campos", JOptionPane.OK_CANCEL_OPTION);
                if(opcao == JOptionPane.OK_OPTION){
                    admin.checa(this.text.getText(), this.senha.getText());
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        this.text.setText("");
        this.senha.setText("");
    }
}
