import javax.swing.*;
import java.awt.*;

public class Lista extends JPanel {
    Lista(){
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);
        this.setLayout(layout);
        this.setBackground(Color.YELLOW);
    }

    public void numeruj(){
        Component[] listaItemow = this.getComponents();

        for (int i = 0; i < listaItemow.length; i++) {
            if (listaItemow[i] instanceof Zadanie){
                ((Zadanie)listaItemow[i]).zmienIndex(i+1);
            }
        }

    }

    public void usunSkonczoneZadanie(){
        for (Component component : getComponents()) {
            if (component instanceof Zadanie){
                if (((Zadanie)component).sprawdzStan()){
                    remove(component);
                    numeruj();
                }
            }
        }
    }

}
