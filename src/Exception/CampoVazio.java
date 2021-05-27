package Exception;

import javax.swing.*;

public class CampoVazio extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Campo Vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
