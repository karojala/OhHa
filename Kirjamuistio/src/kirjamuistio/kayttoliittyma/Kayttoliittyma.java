package kirjamuistio.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import kirjamuistio.logiikka.Halutut;
import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Omistetut;

/**
 * Käyttöliittymä-luokka toimii ohjelman graafisen käyttöliittymän keskuksena
 *
 * @author Karita Ojala
 */
public class Kayttoliittyma implements Runnable {

    /**
     * Frame, eli ikkuna, johon käyttöliittymä käynnistyy. 
     */
    private JFrame frame;

    /**
     * Ajaa graafisen käyttöliittymän. Luo ikkunan, asettaa sen koon, 
     * luo komponentit sen sisälle, kokoaa sen ja asettaa näkyväksi. 
     */
    @Override
    public void run() {
        frame = new JFrame("Kirjamuistio");
        frame.setPreferredSize(new Dimension(600, 600));

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

        Kirjalista omistetutlista = new Omistetut();
        Kirjalista halututlista = new Halutut();
        
        // Luodaan välilehdet eli tabit omistetuille ja halutuille kirjoille
        File omtied = new File("omistetutkirjat.txt");
        Kirjanakyma omistetut = new Kirjanakyma(omistetutlista, omtied);
        tabbedPane.addTab("Omistetut kirjat", omistetut);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        File haltied = new File("halututkirjat.txt");
        Kirjanakyma halutut = new Kirjanakyma(halututlista, haltied);
        tabbedPane.addTab("Halutut kirjat", halutut);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        container.add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public JFrame getFrame() {
        return frame;
    }
}