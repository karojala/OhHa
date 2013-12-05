package kirjamuistio.kayttoliittyma;

import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Kirja;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * KirjanLisaajaKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on
 * toteuttaa napinpainallusominaisuus, jonka tuloksena kirjan tiedoista luodaan
 * Kirja-olio ja Kirja-olio lisätään Kirjalistaan (Omistetut tai Halutut). 
 * @author Karita Ojala
 */
public class KirjanLisaajaKuuntelija implements ActionListener {

    private Kirjalista kirjalista;
    
    private JTextField nimi;
    private JTextField kirj;
    private JTextField jvuosi;
    
    public KirjanLisaajaKuuntelija(Kirjalista kirjalista, JTextField nimi, JTextField kirj, JTextField jvuosi) {
        this.kirjalista = kirjalista;
        this.nimi = nimi;
        this.kirj = kirj;
        this.jvuosi = jvuosi;
    }
    
    /**
     * 
     * @param e Tapahtuma
     */
    public void actionPerformed(ActionEvent e) {
        String knimi = this.nimi.getText();
        String kkirj = this.kirj.getText();
        int vuosi = Integer.parseInt(this.jvuosi.getText());
        Kirja kirja = new Kirja(knimi, kkirj, vuosi);
        this.kirjalista.lisaaKirja(kirja);
        this.nimi.setText("");
        this.kirj.setText("");
        this.jvuosi.setText("");
    }
}
