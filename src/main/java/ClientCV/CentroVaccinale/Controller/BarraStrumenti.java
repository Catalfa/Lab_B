package ClientCV.CentroVaccinale.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BarraStrumenti {

    private JButton bottoneSignIn;
    private JButton bottoneGoBack;

    private JButton bottoneLogin;
    private TextListener textListener;
    BarraStrumenti() {
        bottoneSignIn = new  JButton( "Sign in");
        bottoneGoBack = new JButton("Go back");
        bottoneLogin = new JButton("Login");

        bottoneSignIn.addActionListener(this::actionPerformed);
        bottoneGoBack.addActionListener(this::actionPerformed);
        bottoneLogin.addActionListener(this::actionPerformed);

       // setLayout(new FlowLayout(FlowLayout.LEFT));

       // add(bottoneSignIn);
       // add(bottoneGoBack);
       // add(bottoneLogin);

    }

    public void setTextListener(TextListener textListener){
        this.textListener = textListener;

    }

    public void actionPerformed(ActionEvent e) {               //collegamento che permette scrivere del testo schiacciando bottone
        if (textListener != null){
            JButton premuto = (JButton) e.getSource();

            if(premuto == bottoneSignIn) {
                textListener.testoEmesso("Sign in \n");
            } else if (premuto == bottoneGoBack){
                textListener.testoEmesso("Go back \n");
            } else if (premuto == bottoneLogin){
                textListener.testoEmesso("Login \n");
            }
        }
    }
}
