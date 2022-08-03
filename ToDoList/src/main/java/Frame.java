import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

    private Tytul tytul;
    private Lista lista;
    private DolnyPanel dolnyPanel;

    private JButton addTask;
    private JButton clearTask;

    Frame(){
        this.setTitle("TODO LIST");
        this.setSize(400,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        tytul = new Tytul();
        lista = new Lista();
        dolnyPanel = new DolnyPanel();
        this.add(tytul, BorderLayout.NORTH);

        this.add(lista,BorderLayout.CENTER);

        this.add(dolnyPanel,BorderLayout.SOUTH);

        addTask = dolnyPanel.getAddTask();
        clearTask = dolnyPanel.getClearTask();

        dodajSluchaczy();

    }

    public void dodajSluchaczy(){
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Zadanie zadanie = new Zadanie();
               // zadanie.dodajTekst();
                lista.add(zadanie);
                lista.numeruj();

                zadanie.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        zadanie.zmienStan();
                        revalidate();
                    }
                });

                clearTask.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        lista.usunSkonczoneZadanie();
                        revalidate();
                    }
                });
                repaint();
                revalidate();
            }
        });
    }

}
