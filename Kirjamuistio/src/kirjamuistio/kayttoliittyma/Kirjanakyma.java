package kirjamuistio.kayttoliittyma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import kirjamuistio.logiikka.Kirjalista;

/**
 *
 * @author karojala
 */
public class Kirjanakyma extends JPanel {

    private Kirjalista kirjalista;
    private File tiedosto;

    public Kirjanakyma(Kirjalista kirjalista, File tiedosto) {
        super(false);
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        teeSisalto();
    }

    public void teeSisalto() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel ikkuna = new JPanel();
        ikkuna.setLayout(new BorderLayout());
        this.add(ikkuna, BorderLayout.CENTER);

        ListausNakyma listaus = new ListausNakyma(kirjalista, ikkuna);
        
        LisaysNakyma lisays = new LisaysNakyma(kirjalista, tiedosto, ikkuna);
        
        PoistoNakyma poisto = new PoistoNakyma(kirjalista, tiedosto, ikkuna);

        lisaaNappi("Näytä lista kirjoista", this, ikkuna, listaus);
        lisaaNappi("Lisää uusi kirja", this, ikkuna, lisays);
        lisaaNappi("Poista kirjoja", this, ikkuna, poisto);
    }

    public JButton lisaaNappi(String teksti, Container container, JPanel ikkuna, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.setAlignmentX(Component.LEFT_ALIGNMENT);
        nappi.addActionListener(new NapinKuuntelija(ikkuna, nakyma, this.kirjalista));
        container.add(nappi);
        return nappi;
    }
}
