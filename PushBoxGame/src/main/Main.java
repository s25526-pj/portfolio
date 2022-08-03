package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PushBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        PanelGry panelGry = new PanelGry();
        frame.add(panelGry);
        frame.pack();

        panelGry.ustawPozElementu();
        panelGry.startGry();

    }
}
