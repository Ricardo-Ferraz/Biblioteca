package Exception;

import javax.swing.*;

public class NegativoDetectado extends Exception{
    @Override
    public void printStackTrace(){
        JOptionPane.showMessageDialog(null, "Um valor negativo foi dectetado!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
