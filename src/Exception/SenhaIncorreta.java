package Exception;

import javax.swing.*;

public class SenhaIncorreta extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Senha Incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
