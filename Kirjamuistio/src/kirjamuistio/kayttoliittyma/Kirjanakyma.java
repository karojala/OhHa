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
        /*this.setLayout(new GridLayout(1, 1));*/
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /*TextArea tekstikentta = new JTextArea();
        this.add(tekstikentta, BorderLayout.CENTER);*/
        JLabel tayte = new JLabel("Tähän tulee nappia painamalla jotain");
        this.add(tayte, BorderLayout.CENTER);
        
        ListausNakyma listaus = new ListausNakyma(tayte, kirjalista);
        this.add(listaus);
        
        LisaysNakyma lisays = new LisaysNakyma();
        this.add(lisays);

        lisaaNappi("Näytä lista kirjoista", this, tayte, listaus);
        lisaaNappi("Lisää kirja", this, tayte, lisays);
    }

    private void lisaaNappi(String teksti, Container container, JComponent sisalto, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.setAlignmentX(Component.TOP_ALIGNMENT);
        nappi.addActionListener(new NapinKuuntelija(sisalto, nakyma, this.kirjalista));
        container.add(nappi);
    }
}
