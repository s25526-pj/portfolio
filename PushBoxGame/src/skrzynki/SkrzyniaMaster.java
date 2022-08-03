package skrzynki;

import main.PanelGry;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SkrzyniaMaster {
    public BufferedImage wyglad;
    public String kierunek;
    public boolean kolizja = false;
    public int pozX, pozY;

    public void draw(Graphics2D graphics2D, PanelGry panel){

        graphics2D.drawImage(panel.skrzynie[0].wyglad,panel.skrzynie[0].pozX,panel.skrzynie[0].pozY,panel.rozmiarPostaci,panel.rozmiarPostaci,null);
        graphics2D.drawImage(panel.skrzynie[1].wyglad,panel.skrzynie[1].pozX,panel.skrzynie[1].pozY,panel.rozmiarPostaci,panel.rozmiarPostaci,null);

    }

}
