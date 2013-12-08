
package kirjamuistio.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import kirjamuistio.logiikka.Kirjalista;
        
/**
 * NapinKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on toteuttaa
 * napinpainallusominaisuus, jonka tuloksena käyttöliittymän ikkunaan ilmestyy
 * lista kirjoista tai näkymä, josta voi lisätä kirjan kirjalistaan. 
 * @author Karita Ojala
 */
public class NapinKuuntelija implements ActionListener {
    
    private Nakyma nakyma;
    private Kirjalista kirjalista;
    private JPanel ikkuna;
    
    public NapinKuuntelija(JPanel ikkuna, Nakyma nakyma, Kirjalista kirjalista) {
        this.nakyma = nakyma;
        this.kirjalista = kirjalista;
        this.ikkuna = ikkuna;
    }
    
    /**
     * Napin painalluksen jälkeen suorittaa jonkin toiminnon. 
     * @param e Tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.nakyma.asetaNakyma();
    }
    
}
