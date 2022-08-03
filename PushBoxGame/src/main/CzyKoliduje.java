package main;

import postac.Jednostka;

public class CzyKoliduje {

    PanelGry panelGry;

    public CzyKoliduje(PanelGry panelGry){
        this.panelGry = panelGry;
    }

    public void sprawdzTeren(Jednostka jednostka){

        int lewaStronaKwadratuKolizji = jednostka.pozX + jednostka.kwadratKolizji.x;
        int prawaStronaKwadratuKolizji = jednostka.pozX + jednostka.kwadratKolizji.x + jednostka.kwadratKolizji.width;
        int goraKwadratuKolizji = jednostka.pozY + jednostka.kwadratKolizji.y;
        int dolKwadratuKolizji = jednostka.pozY + jednostka.kwadratKolizji.y + jednostka.kwadratKolizji.height;

        int kolizjaZLewejStrony = lewaStronaKwadratuKolizji/panelGry.rozmiarPostaci;
        int kolizjaZPrawejStrony = prawaStronaKwadratuKolizji/panelGry.rozmiarPostaci;
        int kolizjaZGory = goraKwadratuKolizji/panelGry.rozmiarPostaci;
        int kolizjaZDolu = dolKwadratuKolizji/panelGry.rozmiarPostaci;

        int element1, element2;

        switch (jednostka.kierunek){
            case "gora":
                kolizjaZGory = (goraKwadratuKolizji - jednostka.predkosc)/ panelGry.rozmiarPostaci;
                element1 = panelGry.zarzadzanieElementami.mapa[kolizjaZGory][kolizjaZLewejStrony];
                element2 = panelGry.zarzadzanieElementami.mapa[kolizjaZGory][kolizjaZPrawejStrony];
                if (panelGry.zarzadzanieElementami.blok[element1].kolizja == true || panelGry.zarzadzanieElementami.blok[element2].kolizja == true){
                    jednostka.kolizjaNa = true;
                }
                break;
            case "dol":
                kolizjaZDolu = (dolKwadratuKolizji - jednostka.predkosc)/ panelGry.rozmiarPostaci;
                element1 = panelGry.zarzadzanieElementami.mapa[kolizjaZDolu][kolizjaZLewejStrony];
                element2 = panelGry.zarzadzanieElementami.mapa[kolizjaZDolu][kolizjaZPrawejStrony];
                if (panelGry.zarzadzanieElementami.blok[element1].kolizja == true || panelGry.zarzadzanieElementami.blok[element2].kolizja == true){
                    jednostka.kolizjaNa = true;
                }
                break;
            case "lewo":
                kolizjaZLewejStrony = (lewaStronaKwadratuKolizji - jednostka.predkosc)/ panelGry.rozmiarPostaci;
                element1 = panelGry.zarzadzanieElementami.mapa[kolizjaZGory][kolizjaZLewejStrony];
                element2 = panelGry.zarzadzanieElementami.mapa[kolizjaZDolu][kolizjaZLewejStrony];
                if (panelGry.zarzadzanieElementami.blok[element1].kolizja == true || panelGry.zarzadzanieElementami.blok[element2].kolizja == true){
                    jednostka.kolizjaNa = true;
                }
                break;
            case "prawo":
                kolizjaZPrawejStrony = (prawaStronaKwadratuKolizji - jednostka.predkosc)/ panelGry.rozmiarPostaci;
                element1 = panelGry.zarzadzanieElementami.mapa[kolizjaZGory][kolizjaZPrawejStrony];
                element2 = panelGry.zarzadzanieElementami.mapa[kolizjaZDolu][kolizjaZPrawejStrony];
                if (panelGry.zarzadzanieElementami.blok[element1].kolizja == true || panelGry.zarzadzanieElementami.blok[element2].kolizja == true){
                    jednostka.kolizjaNa = true;
                }
                break;
        }
    }
}
