package Exception;

import javax.swing.JOptionPane;

public class CpfNaoEncontrado extends Exception{

    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Cpf não registrado!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
