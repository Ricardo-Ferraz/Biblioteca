package Exception;

import javax.swing.*;

public class LivroNaoAlugado extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Esse Livro não foi alugado por você!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
