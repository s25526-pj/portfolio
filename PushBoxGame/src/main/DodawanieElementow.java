package main;

import skrzynki.MiejsceSkrzyni;
import skrzynki.Skrzynia;

public class DodawanieElementow {

    PanelGry panel;

    public DodawanieElementow(PanelGry panel){
        this.panel = panel;
    }

    public void ustawElement(){
        panel.skrzynie[0] = new Skrzynia();
        panel.skrzynie[0].pozX = 6 * panel.rozmiarPostaci;
        panel.skrzynie[0].pozY = 8 * panel.rozmiarPostaci;

        panel.skrzynie[1] = new MiejsceSkrzyni();
        panel.skrzynie[1].pozX = 12 * panel.rozmiarPostaci;
        panel.skrzynie[1].pozY = 4 * panel.rozmiarPostaci;


    }

}
