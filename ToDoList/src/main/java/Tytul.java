import javax.swing.*;
import java.awt.*;

public class Tytul extends JPanel {

    Tytul(){
        this.setPreferredSize(new Dimension(400,80));
        this.setBackground(Color.BLUE);
        JLabel tekstTytul = new JLabel("TO DO LIST");
        tekstTytul.setFont(new Font("Sans-serif",Font.BOLD,20));
        tekstTytul.setPreferredSize(new Dimension(150,80));
        tekstTytul.setHorizontalAlignment(JLabel.CENTER);

        this.add(tekstTytul);

    }

}
