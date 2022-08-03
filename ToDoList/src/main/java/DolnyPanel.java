import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DolnyPanel extends JPanel {

    private JButton addTask;
    private JButton clearTask;
    Border pusty = BorderFactory.createEmptyBorder();

    DolnyPanel(){
        this.setPreferredSize(new Dimension(400,60));


        addTask = new JButton("Dodaj zadanie");
        addTask.setFont(new Font("Sans-serif",Font.PLAIN,20));
        addTask.setBorder(pusty);
        this.add(addTask);

        this.add(Box.createHorizontalStrut(5));

        clearTask = new JButton("Usuń zadanie");
        clearTask.setFont(new Font("Sans-serif",Font.PLAIN,20));
        clearTask.setBorder(pusty);
        this.add(clearTask);
    }

    public JButton getAddTask(){
        return addTask;
    }
    public JButton getClearTask(){
        return clearTask;
    }

}
