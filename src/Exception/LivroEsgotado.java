package Exception;

import javax.swing.*;

public class LivroEsgotado extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Livro esgostado!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
