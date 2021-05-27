package Exception;

import javax.swing.*;

public class UsuarioIncorreto extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Usuário administrador Incorreto!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
