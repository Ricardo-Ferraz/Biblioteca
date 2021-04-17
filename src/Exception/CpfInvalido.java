package Exception;

import javax.swing.*;

public class CpfInvalido extends Exception {

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Cpf não inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
