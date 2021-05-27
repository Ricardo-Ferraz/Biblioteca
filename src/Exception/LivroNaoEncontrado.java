package Exception;

import javax.swing.JOptionPane;

public class LivroNaoEncontrado extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Livro não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
