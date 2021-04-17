package Exception;

import javax.swing.JOptionPane;

public class JaCadastrado extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
