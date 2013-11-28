
package kirjamuistio.kayttoliittyma;

import kirjamuistio.logiikka.Kirjalista;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
        
/**
 * NapinKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on toteuttaa
 * napinpainallusominaisuus, jonka tuloksena käyttöliittymän ikkunaan ilmestyy
 * lista kirjoista
 * @author Karita Ojala
 */
public class NapinKuuntelija implements ActionListener {
    
    private JTextField tekstikentta;
    private ArrayList haluttuTeksti;
    
    public NapinKuuntelija(JTextField teksti, ArrayList haluttuTeksti) {
        this.tekstikentta = teksti;
        this.haluttuTeksti = haluttuTeksti;
    }
    
    /**
     * Napin painalluksen jälkeen asettaa tekstikentän tekstiksi halutun tekstin
     * @param e Tapahtuma
     */
    public void actionPerformed(ActionEvent e) {
        tekstikentta.setText(this.haluttuTeksti.toString());
    }
    
}
