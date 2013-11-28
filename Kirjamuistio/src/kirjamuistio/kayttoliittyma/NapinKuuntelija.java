
package kirjamuistio.kayttoliittyma;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import kirjamuistio.kayttoliittyma.ListausNakyma;
import kirjamuistio.logiikka.Kirjalista;
        
/**
 * NapinKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on toteuttaa
 * napinpainallusominaisuus, jonka tuloksena käyttöliittymän ikkunaan ilmestyy
 * lista kirjoista
 * @author Karita Ojala
 */
public class NapinKuuntelija implements ActionListener {
    
    private JComponent sisalto;
    private Nakyma nakyma;
    private Kirjalista kirjalista;
    
    public NapinKuuntelija(JComponent sisalto, Nakyma nakyma, Kirjalista kirjalista) {
        this.sisalto = sisalto;
        this.nakyma = nakyma;
        this.kirjalista = kirjalista;
    }
    
    /**
     * Napin painalluksen jälkeen asettaa tekstikentän tekstiksi halutun tekstin
     * @param e Tapahtuma
     */
    public void actionPerformed(ActionEvent e) {
        this.nakyma.asetaNakyma(sisalto, kirjalista);
    }
    
}
