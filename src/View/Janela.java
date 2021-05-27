package View;

import Controladores.ControladorLivro;
import Controladores.ControladorPessoa;
import Entidades.*;
import Dados.*;

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

    private Contador c;

    private JTextField text= new JTextField(20);;
    private JTextField text2= new JTextField(20);;
    private JPasswordField senha= new JPasswordField(20);;

    private Object[] entradas = {"Informe seu CPF: ", text, "Informe o ID do titulo: ", text2};
    private Object[] entradaLogin= {"Informe o User: ", text, "Informe a senha: ", senha};

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;


    private ControladorPessoa controladorPessoa = new ControladorPessoa();
    private ControladorLivro controladorLivro = new ControladorLivro();

    private Dimension dimension;
    
    public Janela(){
        this.c= new Contador();
        this.c.start();


        this.b1= new JButton("Exibir");
        this.b2= new JButton("Alugar");
        this.b3= new JButton("Situação");
        this.b4= new JButton("Devolução");
        this.b5= new JButton("Admin");

        this.dimension = new Dimension(300,300);

        inicial();

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
        if(e.getSource() == this.b1){ //Exibir todos os títulos
            JTextArea texto = new JTextArea(this.controladorLivro.toString());
            JScrollPane scroll = new JScrollPane(texto);
            texto.setEditable(false);
            scroll.setPreferredSize(this.dimension);
            JOptionPane.showMessageDialog(null, scroll, "Titulos cadastrados",JOptionPane.UNDEFINED_CONDITION);
        }

        else if(e.getSource() == this.b2){ //Alugar títulos
            try{
               int opcao = JOptionPane.showConfirmDialog(null, this.entradas, "Informe o ID do Titulo escolhido", JOptionPane.OK_CANCEL_OPTION);
               if(opcao == JOptionPane.OK_OPTION){
                   this.controladorLivro.aluga(this.text2.getText());
                   Titulo aux= this.controladorLivro.buscaId(this.text2.getText());
                   this.controladorPessoa.adicionaLivro(this.text.getText(), aux.getTitulo(), aux.getDescricao(), aux.getQtd(),aux.getTempoMax(), aux.getId());
                   JOptionPane.showMessageDialog(null, "Prazo Máximo para devolução do titulo "+this.controladorLivro.buscaId(this.text2.getText()).getTitulo()+" é de, máximo, "+this.controladorLivro.buscaId(this.text2.getText()).getTempoMax()+" dias!","Titulo alugado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
               }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            this.text.setText("");
            this.text2.setText("");
        }

        else if(e.getSource() == this.b3){ //Checa situação do leitor
            try{
                int opcao = JOptionPane.showConfirmDialog(null, this.text, "Informe seu CPF", JOptionPane.OK_CANCEL_OPTION);
                if(opcao == JOptionPane.OK_OPTION) {
                    JTextArea texto = new JTextArea(this.controladorPessoa.buscaCpf(this.text.getText()).toString());
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

        else if(e.getSource() == this.b4){ //Devolução de título
            try{
                int opcao = JOptionPane.showConfirmDialog(null, this.entradas, "Informe o ID do Titulo a ser devolvido", JOptionPane.OK_CANCEL_OPTION);
                if(opcao == JOptionPane.OK_OPTION){
                    this.controladorPessoa.buscaCpf(this.text.getText());
                    this.controladorLivro.buscaId(this.text2.getText());
                    Titulo aux= this.controladorPessoa.devolucaoLivro(this.text.getText(),this.text2.getText());
                    this.controladorLivro.devolve(aux.getTitulo(), aux.getDescricao(), aux.getQtd(),aux.getTempoMax(), aux.getId());
                    JOptionPane.showConfirmDialog(null, "Devolução feita com sucesso!", "Sucesso!", JOptionPane.UNDEFINED_CONDITION);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            this.text.setText("");
            this.text2.setText("");
        }

        else if(e.getSource() == this.b5){ //Abre a Janela de admin
            Admin admin= new Admin(this.controladorPessoa, this.controladorLivro);
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

    public void inicial(){
        try {
            this.controladorLivro.adiciona("Ednaldo Pereira", "A elite ataca ataca novamente", 100, 20, "1");
            this.controladorLivro.adiciona("O Mestre", "A volta do velho", 5, 20, "2");
            this.controladorLivro.adiciona("Cuca, a vingaça do pelo", "Ele está de volta e quer sua vingança", 100, 20, "3");
            this.controladorLivro.adiciona("Paula, o encontro", "Fátima chama para conversar", 100, 20, "5");
            this.controladorLivro.adiciona("Naruto", "Jovem demoníaco", 100, 20, "4");
            this.controladorLivro.adiciona("Guiba, Beltrão", "O menino que fez 5 cirurgias de fimose", 100, 20, "22");
            this.controladorLivro.adiciona("Grongos, The Story", "Ele comba fofo", 100, 20, "29");

            this.controladorPessoa.adicionaP("Paula", "12345678910", 43, "74644903");
            this.controladorPessoa.adiciona("Cassio", "77732473148", 21, "2019107880");
            this.controladorPessoa.adiciona("Carlos", "44455566677", 19);
            this.controladorPessoa.adiciona("Silvestre Estálonge", "44425566677", 60);
            this.controladorPessoa.adiciona("Tabela", "41455566677", 19);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
