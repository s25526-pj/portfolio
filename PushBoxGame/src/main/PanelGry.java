package main;

import elementy.ZarzadzanieElementami;
import postac.Gracz;
import skrzynki.SkrzyniaMaster;

import javax.swing.*;
import java.awt.*;

public class PanelGry extends JPanel implements Runnable {

    final int originalSize = 16; //Rozmiar postaci
    final int skala = 3;         //Skalowanie postaci

    public final int rozmiarPostaci = originalSize * skala;
    public final int maksymalnaWysokoscMapy = 12;  //wierszy
    public final int maksymalnaSzerokoscMapy = 16; //kolumn
    public final int szerokoscEkranu = rozmiarPostaci*maksymalnaSzerokoscMapy; //768 pixeli
    public final int wysokoscEkranu = rozmiarPostaci*maksymalnaWysokoscMapy;   //576 pixeli
     int pozycjaStartuX = szerokoscEkranu/2;
     int pozycjaStartuY = wysokoscEkranu/2;
     int predkoscRuchu = 8;
     int fps = 60;

    ZarzadzanieElementami zarzadzanieElementami =  new ZarzadzanieElementami(this);
    DodawanieElementow dodawanieElementow = new DodawanieElementow(this);
    Sterowanie sterowanie = new Sterowanie();
    public CzyKoliduje czyKoliduje = new CzyKoliduje(this);
    Gracz gracz = new Gracz(this,sterowanie);
    public SkrzyniaMaster[] skrzynie = new SkrzyniaMaster[2];
    Thread gra;


    PanelGry(){

        this.setPreferredSize(new Dimension(szerokoscEkranu,wysokoscEkranu));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.addKeyListener(sterowanie);
        this.setFocusable(true);


    }

    public void ustawPozElementu(){
        dodawanieElementow.ustawElement();
    }

    public void startGry(){
        gra = new Thread(this);
        gra.start();
    }

    @Override
    public void run() {

        double czekajNaRysowanie = 1000000000/fps;
        double nastepneRysowanie = System.nanoTime() + czekajNaRysowanie;

        while (gra != null){


            update();

            repaint();


            try {

                double pozostalyCzasDoRysowania =nastepneRysowanie - System.nanoTime();
                pozostalyCzasDoRysowania = pozostalyCzasDoRysowania/1000000;

                if (pozostalyCzasDoRysowania < 0){
                    pozostalyCzasDoRysowania = 0;
                }

                Thread.sleep((long)pozostalyCzasDoRysowania);

                nastepneRysowanie += czekajNaRysowanie;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void update(){

        gracz.update();

    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;

        zarzadzanieElementami.draw(graphics2D);

        for (int i = 0; i < skrzynie.length; i++) {
            if (skrzynie[i] != null){
                skrzynie[i].draw(graphics2D,this);
            }
        }

        gracz.draw(graphics2D);

        graphics2D.dispose();

    }

}
