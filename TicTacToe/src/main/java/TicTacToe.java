import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame ramka = new JFrame();
    JPanel tytul = new JPanel();
    JPanel plansza = new JPanel();
    JLabel textField = new JLabel();
    JButton[] przyciski = new JButton[9];
    JButton odNowa = new JButton();
    boolean ktoryGracz;


    TicTacToe(){

        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(500,500);
        ramka.getContentPane().setBackground(Color.BLUE);
        ramka.setLayout(new BorderLayout());
        ramka.setVisible(true);

        textField.setBackground(Color.YELLOW);
        textField.setForeground(Color.BLACK);
        textField.setText("CZESC");
        textField.setFont(new Font("Times New Roman",Font.BOLD,40));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);

        tytul.setLayout(new BorderLayout());
        tytul.setBounds(0,0,500,50);

        tytul.add(textField);
        ramka.add(tytul,BorderLayout.NORTH);

        plansza.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            przyciski[i] = new JButton();
            plansza.add(przyciski[i]);
            przyciski[i].setFont(new Font("MV Boli",Font.BOLD,70));
            przyciski[i].setFocusable(false);
            przyciski[i].addActionListener(this);
            przyciski[i].setBackground(Color.lightGray);
        }

        ramka.add(plansza);

        firstTurn();

        ramka.add(odNowa,BorderLayout.SOUTH);
        odNowa.setText("Zagraj ponownie");
        odNowa.setFocusable(false);
        odNowa.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == odNowa){
            restartGry();
        }

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == przyciski[i]){
                if (ktoryGracz){
                    if (Objects.equals(przyciski[i].getText(), "")){
                        przyciski[i].setForeground(Color.RED);
                        przyciski[i].setText("X");
                        ktoryGracz = false;
                        textField.setText("O Turn");
                        check();
                    }
                }
                else {
                    if (Objects.equals(przyciski[i].getText(), "")) {
                        przyciski[i].setForeground(Color.GREEN);
                        przyciski[i].setText("O");
                        ktoryGracz = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }

    }

    public void restartGry(){
        for (int i = 0; i < 9; i++) {
            przyciski[i].setBackground(Color.lightGray);
            przyciski[i].setText("");
            przyciski[i].setEnabled(true);
        }
    }

    public void firstTurn(){
        if (random.nextInt(2)==0){
            ktoryGracz = true;
            textField.setText("X Turn");
        }
        else {
            ktoryGracz = false;
            textField.setText("O Turn");
        }
    }

    public void check(){
        if (Objects.equals(przyciski[0].getText(), "X") && Objects.equals(przyciski[1].getText(), "X") && Objects.equals(przyciski[2].getText(), "X")){
            xWins(0,1,2);
        }
        if (Objects.equals(przyciski[3].getText(), "X") && Objects.equals(przyciski[4].getText(), "X") && Objects.equals(przyciski[5].getText(), "X")){
            xWins(3,4,5);
        }
        if (Objects.equals(przyciski[6].getText(), "X") && Objects.equals(przyciski[7].getText(), "X") && Objects.equals(przyciski[8].getText(), "X")){
            xWins(6,7,8);
        }
        if (Objects.equals(przyciski[0].getText(), "X") && Objects.equals(przyciski[3].getText(), "X") && Objects.equals(przyciski[6].getText(), "X")){
            xWins(0,3,6);
        }
        if (Objects.equals(przyciski[1].getText(), "X") && Objects.equals(przyciski[4].getText(), "X") && Objects.equals(przyciski[7].getText(), "X")){
            xWins(1,4,7);
        }
        if (Objects.equals(przyciski[2].getText(), "X") && Objects.equals(przyciski[5].getText(), "X") && Objects.equals(przyciski[8].getText(), "X")){
            xWins(2,5,8);
        }
        if (Objects.equals(przyciski[0].getText(), "X") && Objects.equals(przyciski[4].getText(), "X") && Objects.equals(przyciski[8].getText(), "X")){
            xWins(0,4,8);
        }
        if (Objects.equals(przyciski[2].getText(), "X") && Objects.equals(przyciski[4].getText(), "X") && Objects.equals(przyciski[6].getText(), "X")){
            xWins(2,4,6);
        }
        if (Objects.equals(przyciski[0].getText(), "O") && Objects.equals(przyciski[1].getText(), "O") && Objects.equals(przyciski[2].getText(), "O")){
            oWins(0,1,2);
        }
        if (Objects.equals(przyciski[3].getText(), "O") && Objects.equals(przyciski[4].getText(), "O") && Objects.equals(przyciski[5].getText(), "O")){
            oWins(3,4,5);
        }
        if (Objects.equals(przyciski[6].getText(), "O") && Objects.equals(przyciski[7].getText(), "O") && Objects.equals(przyciski[8].getText(), "O")){
            oWins(6,7,8);
        }
        if (Objects.equals(przyciski[0].getText(), "O") && Objects.equals(przyciski[3].getText(), "O") && Objects.equals(przyciski[6].getText(), "O")){
            oWins(0,3,6);
        }
        if (Objects.equals(przyciski[1].getText(), "O") && Objects.equals(przyciski[4].getText(), "O") && Objects.equals(przyciski[7].getText(), "O")){
            oWins(1,4,7);
        }
        if (Objects.equals(przyciski[2].getText(), "O") && Objects.equals(przyciski[5].getText(), "O") && Objects.equals(przyciski[8].getText(), "O")){
            oWins(2,5,8);
        }
        if (Objects.equals(przyciski[0].getText(), "O") && Objects.equals(przyciski[4].getText(), "O") && Objects.equals(przyciski[8].getText(), "O")){
            oWins(0,4,8);
        }
        if (Objects.equals(przyciski[2].getText(), "O") && Objects.equals(przyciski[4].getText(), "O") && Objects.equals(przyciski[6].getText(), "O")){
            oWins(2,4,6);
        }


    }

    public void xWins(int a, int b, int c){

        for (int i = 0; i < 9; i++) {
            przyciski[i].setEnabled(false);
        }

        przyciski[a].setBackground(Color.GREEN);
        przyciski[b].setBackground(Color.GREEN);
        przyciski[c].setBackground(Color.GREEN);
        textField.setText("X WINS!!!");
    }

    public void oWins(int a, int b, int c){

        for (int i = 0; i < 9; i++) {
            przyciski[i].setEnabled(false);
        }

        przyciski[a].setBackground(Color.GREEN);
        przyciski[b].setBackground(Color.GREEN);
        przyciski[c].setBackground(Color.GREEN);
        textField.setText("O WINS!!!");

    }
}
