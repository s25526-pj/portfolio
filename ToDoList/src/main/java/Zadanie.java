import javax.swing.*;
import java.awt.*;

public class Zadanie extends JPanel {

    public JLabel index;
    private JTextField nazwaZadania;
    private JButton doneButton;
    private String tekst;

    private boolean skonczone;

    Zadanie(){
        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(Color.blue);

        this.setLayout(new BorderLayout());

        skonczone = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index,BorderLayout.WEST);

        nazwaZadania = new JTextField(this.dodajTekst());
        nazwaZadania.setBorder(BorderFactory.createEmptyBorder());
        nazwaZadania.setBackground(Color.RED);
        this.add(nazwaZadania,BorderLayout.CENTER);

        doneButton = new JButton("DONE");
        doneButton.setPreferredSize(new Dimension(40,40));
        doneButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(doneButton,BorderLayout.EAST);

    }

    public void zmienIndex(int numer){
        this.index.setText(String.valueOf(numer + "."));
        this.revalidate();
    }

    public JButton getDone(){
        return doneButton;
    }

    public void zmienStan(){
        this.setBackground(Color.GREEN);
        nazwaZadania.setBackground(Color.GREEN);
        skonczone = true;
    }

    public boolean  sprawdzStan(){

        return skonczone;
    }

    public String dodajTekst(){

        tekst = JOptionPane.showInputDialog("Wpisz zadanie");

        return tekst;

    }

}
