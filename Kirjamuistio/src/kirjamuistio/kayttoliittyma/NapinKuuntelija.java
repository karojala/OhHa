
package kirjamuistio.kayttoliittyma;

import kirjamuistio.logiikka.Omistetut;

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
    
    public void actionPerformed(ActionEvent e) {
        tekstikentta.setText(this.haluttuTeksti.toString());
    }
    
}
