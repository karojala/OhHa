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

        JComponent panel1 = makeTextPanel("Omistamieni kirjojen hallinta");
        tabbedPane.addTab("Omistetut kirjat", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        panel1.setLayout(new BorderLayout());
        JButton nayta = new JButton("Näytä lista omistamani kirjoista");

        //Testausta varten väliaikaisesti tässä
        Kirjalista kirjalista = new Omistetut();
        kirjalista.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976));
        kirjalista.lisaaKirja(new Kirja("The God Delusion", "Richard Dawkins", 1980));

        JTextField tekstikentta = new JTextField();
        //tekstikentta.setText(kirjalista.toString());
        panel1.add(tekstikentta, BorderLayout.CENTER);

        //Tapahtumakuuntelija
        nayta.addActionListener(new NapinKuuntelija(tekstikentta, kirjalista.kirjalista()));
        panel1.add(nayta, BorderLayout.NORTH);

        JComponent panel2 = makeTextPanel("Haluamieni kirjojen hallinta");
        tabbedPane.addTab("Halutut kirjat", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        container.add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}