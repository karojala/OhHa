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
        frame.setPreferredSize(new Dimension(1000, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    // Tämä pitää EHDOTTOMASTI jakaa eri metodeihin ainakin, ellei luokkiin
    private void luoKomponentit(Container container) {
        JTabbedPane tabbedPane = new JTabbedPane();

        //Testausta varten väliaikaisesti tässä
        Kirjalista kirjalista = new Omistetut();
        kirjalista.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976));
        kirjalista.lisaaKirja(new Kirja("The God Delusion", "Richard Dawkins", 1980));

        Kirjanakyma omistetut = new Kirjanakyma(kirjalista, "Omistamieni kirjojen hallinta");
        tabbedPane.addTab("Omistetut kirjat", omistetut);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        Kirjanakyma halutut = new Kirjanakyma(kirjalista, "Haluamieni kirjojen hallinta");
        tabbedPane.addTab("Halutut kirjat", halutut);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        container.add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public JFrame getFrame() {
        return frame;
    }
}