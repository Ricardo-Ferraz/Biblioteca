package View;

import javax.swing.JLabel;
import java.util.Calendar;

public class Contador extends Thread{

    private JLabel hora;
    private Calendar horario;

    public Contador(){
        horario= Calendar.getInstance();
        hora= new JLabel(horario.getTime().getHours()+":"+horario.getTime().getMinutes());
        hora.setLayout(null);
        hora.setBounds(235, 400, 150, 50);
    }

    @Override
    public void run() {
        while(true) {
            try {
                horario= Calendar.getInstance();
                hora.setText(horario.getTime().getHours()+":"+horario.getTime().getMinutes());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public JLabel getHora(){
        return hora;
    }

}
