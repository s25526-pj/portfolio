import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator implements ActionListener {

    JFrame frame = new JFrame("Kalkulator");
    JPanel ekranWyniku = new JPanel();
    JPanel ekranKlawiszy = new JPanel();
    JLabel textWynik = new JLabel();
    JButton[] przyciskiNumerow = new JButton[10];
    JButton[] dzialania = new JButton[8];
    JButton dodawanie, odejmowanie, mnozenie, dzielenie, dziesietne, rownaSie, ujemna, wyczysc;
    Font font = new Font("Times New Roman",Font.BOLD,20);

    double num1 = 0, num2 = 0, wynik = 0;
    char jakieDzialanie;

    Kalkulator(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320,570);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textWynik.setText("");
        textWynik.setFont(font);
        textWynik.setOpaque(true);

        ekranWyniku.setLayout(new BorderLayout());
        ekranWyniku.setPreferredSize(new Dimension(320,135));

        ekranWyniku.add(textWynik);
        frame.add(ekranWyniku,BorderLayout.NORTH);

        dodawanie = new JButton("+");
        odejmowanie = new JButton("-");
        mnozenie = new JButton("x");
        dzielenie = new JButton("/");
        dziesietne = new JButton(".");
        rownaSie = new JButton("=");
        ujemna = new JButton("(-)");
        wyczysc = new JButton("CE");

        dzialania[0] = dodawanie;
        dzialania[1] = odejmowanie;
        dzialania[2] = mnozenie;
        dzialania[3] = dzielenie;
        dzialania[4] = dziesietne;
        dzialania[5] = rownaSie;
        dzialania[6] = ujemna;
        dzialania[7] = wyczysc;

        for (int i = 0; i < 8; i++) {
            dzialania[i].addActionListener(this);
            dzialania[i].setFont(font);
            dzialania[i].setFocusable(false);
            dzialania[i].setPreferredSize(new Dimension(100,60));
        }

        for (int i = 0; i < 10; i++) {
            przyciskiNumerow[i] = new JButton(String.valueOf(i));
            przyciskiNumerow[i].addActionListener(this);
            przyciskiNumerow[i].setFocusable(false);
            przyciskiNumerow[i].setPreferredSize(new Dimension(100,60));
        }

        GridLayout gridLayout = new GridLayout(6,3);
        ekranKlawiszy.setLayout(gridLayout);

        ekranKlawiszy.add(dodawanie);
        ekranKlawiszy.add(odejmowanie);
        ekranKlawiszy.add(wyczysc);
        ekranKlawiszy.add(mnozenie);
        ekranKlawiszy.add(dzielenie);
        ekranKlawiszy.add(ujemna);
        ekranKlawiszy.add(przyciskiNumerow[7]);
        ekranKlawiszy.add(przyciskiNumerow[8]);
        ekranKlawiszy.add(przyciskiNumerow[9]);
        ekranKlawiszy.add(przyciskiNumerow[4]);
        ekranKlawiszy.add(przyciskiNumerow[5]);
        ekranKlawiszy.add(przyciskiNumerow[6]);
        ekranKlawiszy.add(przyciskiNumerow[1]);
        ekranKlawiszy.add(przyciskiNumerow[2]);
        ekranKlawiszy.add(przyciskiNumerow[3]);
        ekranKlawiszy.add(dziesietne);
        ekranKlawiszy.add(przyciskiNumerow[0]);
        ekranKlawiszy.add(rownaSie);

        ekranKlawiszy.setPreferredSize(new Dimension(320,400));
        frame.add(ekranKlawiszy,BorderLayout.SOUTH);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == przyciskiNumerow[i]){
                textWynik.setText(textWynik.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dziesietne){
            textWynik.setText(textWynik.getText().concat("."));
        }
        if (e.getSource() == dodawanie){
            num1 = Double.parseDouble(textWynik.getText());
            jakieDzialanie = '+';
            textWynik.setText("");
        }
        if (e.getSource() == odejmowanie){
            num1 = Double.parseDouble(textWynik.getText());
            jakieDzialanie = '-';
            textWynik.setText("");
        }
        if (e.getSource() == mnozenie){
            num1 = Double.parseDouble(textWynik.getText());
            jakieDzialanie = 'x';
            textWynik.setText("");
        }
        if (e.getSource() == dzielenie){
            num1 = Double.parseDouble(textWynik.getText());
            jakieDzialanie = '/';
            textWynik.setText("");
        }
        if (e.getSource() == rownaSie){
            num2 = Double.parseDouble(textWynik.getText());
            switch (jakieDzialanie){
                case '+':
                    wynik = num1 + num2;
                    break;
                case '-':
                    wynik = num1 - num2;
                    break;
                case 'x':
                    wynik = num1*num2;
                    break;
                case '/':
                    wynik = num1/num2;
                    break;
            }
            textWynik.setText(String.valueOf(wynik));
        }
        if (e.getSource() == wyczysc){
            num1=0;
            num2=0;
            textWynik.setText("");
        }
        if (e.getSource() == ujemna){
            double temp = Double.parseDouble(textWynik.getText());
            temp*=-1;
            textWynik.setText(String.valueOf(temp));
        }
    }
}
