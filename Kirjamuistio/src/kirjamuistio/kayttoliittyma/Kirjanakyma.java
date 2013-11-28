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
    
    public Kirjanakyma(Kirjalista kirjalista, String nimi) {
        super(false);
        this.kirjalista = kirjalista;
        teeSisalto(nimi);
    }
    
    public void teeSisalto(String nimi) {
        JLabel filler = new JLabel(nimi);
        filler.setHorizontalAlignment(JLabel.CENTER);
        /*this.setLayout(new GridLayout(1, 1));*/
        this.setLayout(new BorderLayout());
        this.add(filler);

        ListausNakyma listaus = new ListausNakyma();
        
        JTextField tekstikentta = new JTextField();
        this.add(tekstikentta, BorderLayout.CENTER);

        //Napit yläreunaan
        JButton nayta = new JButton("Näytä lista kirjoista");
        JButton lisaa = new JButton("Lisää kirja");
        //Tapahtumakuuntelijat
        nayta.addActionListener(new NapinKuuntelija(tekstikentta, kirjalista.kirjalista()));
        this.add(nayta, BorderLayout.NORTH);
        lisaa.addActionListener(new NapinKuuntelija(tekstikentta, kirjalista.kirjalista()));
        this.add(lisaa, BorderLayout.NORTH);
    }
}
