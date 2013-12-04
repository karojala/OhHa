package kirjamuistio.kayttoliittyma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import kirjamuistio.logiikka.Kirjalista;

/**
 *
 * @author karojala
 */
public class Kirjanakyma extends JPanel {

    private Kirjalista kirjalista;

    public Kirjanakyma(Kirjalista kirjalista) {
        super(false);
        this.kirjalista = kirjalista;
        teeSisalto();
    }

    public void teeSisalto() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /*TextArea tekstikentta = new JTextArea();
        this.add(tekstikentta, BorderLayout.CENTER);*/
        JPanel ikkuna = new JPanel();
        ikkuna.setLayout(new BorderLayout());
        this.add(ikkuna, BorderLayout.CENTER);
        
        ListausNakyma listaus = new ListausNakyma(kirjalista, ikkuna);
        /*this.add(listaus);*/
        
        LisaysNakyma lisays = new LisaysNakyma(kirjalista, ikkuna);
        /*this.add(lisays);*/

        lisaaNappi("Näytä lista kirjoista", this, ikkuna, listaus);
        lisaaNappi("Lisää kirja", this, ikkuna, lisays);
    }

    private void lisaaNappi(String teksti, Container container, JPanel ikkuna, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.setAlignmentX(Component.LEFT_ALIGNMENT);
        nappi.addActionListener(new NapinKuuntelija(ikkuna, nakyma, this.kirjalista));
        container.add(nappi);
    }
}
