package elementy;

import main.PanelGry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class ZarzadzanieElementami {

    PanelGry panel;
    public Element[] blok;
    public int[][] mapa;

    public ZarzadzanieElementami(PanelGry panel){
        this.panel = panel;

        blok = new Element[2];
        mapa = new int[panel.maksymalnaWysokoscMapy][panel.maksymalnaSzerokoscMapy];

        ustawWyglad();
        stworzMape();
    }

    public void stworzMape() {
        try {

            File plikMapy = new File("C:/Users/mkali/IdeaProjects/PushBoxGame/res/mapa.txt");
            FileReader fileReader = new FileReader(plikMapy);
            BufferedReader mapReader = new BufferedReader(fileReader);

            for (int row = 0; row < 12; row++) {
                String czytaLinie = mapReader.readLine();
                for (int col = 0; col < 16; col++) {
                    String[] split = czytaLinie.split(" ");
                    int rodzajBloku = Integer.parseInt(split[col]);
                    mapa[row][col] = rodzajBloku;
                }

            }

            mapReader.close();

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void ustawWyglad(){

        try {

                blok[0] = new Element();
                blok[0].obrazek = ImageIO.read(new File("C:/Users/mkali/IdeaProjects/PushBoxGame/res/sciany.png"));
                blok[0].kolizja = true;

                blok[1] = new Element();
                blok[1].obrazek = ImageIO.read(new File("C:/Users/mkali/IdeaProjects/PushBoxGame/res/floor01.png"));


        }
        catch (IOException exception){
            exception.printStackTrace();
        }

    }

    public void draw(Graphics2D graphics2D){

        int kolumny = 0;
        int wiersze = 0;
        int x = 0;
        int y = 0;

        while (kolumny < panel.maksymalnaSzerokoscMapy && wiersze < panel.maksymalnaWysokoscMapy){

            int rodzajBloku = mapa[wiersze][kolumny];

            graphics2D.drawImage(blok[rodzajBloku].obrazek,x,y,panel.rozmiarPostaci, panel.rozmiarPostaci, null);
            kolumny++;
            x += panel.rozmiarPostaci;

            if (kolumny == panel.maksymalnaSzerokoscMapy){
                kolumny = 0;
                x = 0;
                wiersze++;
                y += panel.rozmiarPostaci;
            }

        }

    }

}
