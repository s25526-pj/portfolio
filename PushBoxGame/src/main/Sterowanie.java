package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Sterowanie implements KeyListener {

    public boolean lewo,prawo,gora,dol;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int kodKlawisza = e.getKeyCode();

        if (kodKlawisza == KeyEvent.VK_A){
            lewo = true;
        }
        if (kodKlawisza == KeyEvent.VK_W){
            gora = true;
        }
        if (kodKlawisza == KeyEvent.VK_S){
            dol = true;
        }
        if (kodKlawisza == KeyEvent.VK_D){
            prawo = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int kodKlawisza = e.getKeyCode();

        if (kodKlawisza == KeyEvent.VK_A){
            lewo = false;
        }
        if (kodKlawisza == KeyEvent.VK_W){
            gora = false;
        }
        if (kodKlawisza == KeyEvent.VK_S){
            dol = false;
        }
        if (kodKlawisza == KeyEvent.VK_D){
            prawo = false;
        }

    }
}
