package kirjamuistio.kayttoliittyma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Tekstikentän testailua varten tällä hetkellä
import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Omistetut;
import kirjamuistio.logiikka.Kirja;

/**
 * Käyttöliittymä-luokka toimii ohjelman graafisen käyttöliittymän keskuksena
 *
 * @author Karita Ojala
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    /**
     * Ajaa graafisen käyttöliittymän
     */
    @Override
    public void run() {
        frame = new JFrame("Kirjamuistio");
        frame.setPreferredSize(new Dimension(600, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luodaan osat/palaset, mm. välilehdet, JFrameen
     * @param container
     */
    private void luoKomponentit(Container container) {
        JTabbedPane tabbedPane = new JTabbedPane();

        //Testausta varten väliaikaisesti tässä
        Kirjalista omistetutlista = new Omistetut();
        omistetutlista.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976));
        omistetutlista.lisaaKirja(new Kirja("The God Delusion", "Richard Dawkins", 1980));

        Kirjalista halututlista = new Omistetut();
        halututlista.lisaaKirja(new Kirja("Abarat", "Clive Barker", 2000));
        halututlista.lisaaKirja(new Kirja("Pride and Prejudice", "Jane Austen", 1813));

        // Luodaan välilehdet eli tabit omistetuille ja halutuille kirjoille
        Kirjanakyma omistetut = new Kirjanakyma(omistetutlista);
        tabbedPane.addTab("Omistetut kirjat", omistetut);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        Kirjanakyma halutut = new Kirjanakyma(halututlista);
        tabbedPane.addTab("Halutut kirjat", halutut);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        container.add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public JFrame getFrame() {
        return frame;
    }
}