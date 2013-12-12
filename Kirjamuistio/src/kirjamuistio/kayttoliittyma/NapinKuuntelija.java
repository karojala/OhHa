
package kirjamuistio.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
/**
 * NapinKuuntelija on tapahtumakuuntelija, joka kuuntelee nappia, jota painammalla
 * käyttöliittymän ikkunaan asetetaan näkymä. 
 * @author Karita Ojala
 */
public class NapinKuuntelija implements ActionListener {
    
    private Nakyma nakyma;
    
    public NapinKuuntelija(Nakyma nakyma) {
        this.nakyma = nakyma;
    }
    
    /**
     * Napin painalluksen jälkeen asettaa näkymän.
     * @param e Tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.nakyma.asetaNakyma();
    }
    
}
