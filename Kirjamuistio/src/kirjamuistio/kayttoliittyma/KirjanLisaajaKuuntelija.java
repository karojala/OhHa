package kirjamuistio.kayttoliittyma;

import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Kirja;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * KirjanLisaajaKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on
 * toteuttaa napinpainallusominaisuus, jonka tuloksena kirja lisätään listaan. 
 * TÄLLÄ HETKELLÄ TARPEETON. 
 * @author Karita Ojala
 */
public class KirjanLisaajaKuuntelija implements ActionListener {

    private Kirjalista kirjalista;
    
    public KirjanLisaajaKuuntelija(Kirjalista kirjalista, Kirja kirja) {
        this.kirjalista = kirjalista;
    }
    
    /**
     * 
     * @param e Tapahtuma
     */
    public void actionPerformed(ActionEvent e) {
        
    }
}
