package postac;

import main.PanelGry;
import main.Sterowanie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gracz extends Jednostka {

    PanelGry panelGry;
    Sterowanie sterowanie;

    public Gracz(PanelGry panelGry,Sterowanie sterowanie){

        this.panelGry = panelGry;
        this.sterowanie = sterowanie;
        ustawPodstawoweWartosci();
        ustawObrazek();

        kwadratKolizji = new Rectangle(8,16,panelGry.rozmiarPostaci-16,panelGry.rozmiarPostaci-16);

    }

    public void ustawPodstawoweWartosci(){
        pozX = 336;
        pozY = 336;
        predkosc = 4;
    }

    public void update() {

        if (sterowanie.lewo == true || sterowanie.gora == true || sterowanie.dol == true || sterowanie.prawo == true) {

            if (sterowanie.lewo == true) {
//            pozX -= predkosc;
                kierunek = "lewo";
            } else if (sterowanie.gora == true) {
//            pozY -= predkosc;
                kierunek = "gora";
            } else if (sterowanie.dol == true) {
//            pozY += predkosc;
                kierunek = "dol";
            } else if (sterowanie.prawo == true) {
//            pozX += predkosc;
                kierunek = "prawo";
            }

            kolizjaNa = false;
            panelGry.czyKoliduje.sprawdzTeren(this);

            if (kolizjaNa == false) {

                    switch (kierunek) {
                        case "lewo":
                            pozX -= predkosc;
                            break;
                        case "gora":
                            pozY -= predkosc;
                            break;
                        case "dol":
                            pozY += predkosc;
                            break;
                        case "prawo":
                            pozX += predkosc;
                            break;
                    }

                }
            }

        }


    public void ustawObrazek(){
        try {
            wygladPostaci = ImageIO.read(new File("C:/Users/mkali/IdeaProjects/PushBoxGame/res/postac.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D){

        BufferedImage i = wygladPostaci;
        graphics2D.drawImage(i,pozX,pozY,panelGry.rozmiarPostaci,panelGry.rozmiarPostaci,null);

    }


}
