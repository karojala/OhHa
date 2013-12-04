
package kirjamuistio.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

import kirjamuistio.logiikka.Kirjalista;

/**
 * Rajapinta. Näkymä Kirjanäkymän sisällä. 
 * @author Karita Ojala
 */
public interface Nakyma {
    
    /**
     * Asettaa graafiseen käyttöliittymään keskelle välilehden sisälle JPaneliin näkymän.
     * Näkymä voi olla joko kirjojen listaus- tai lisäysnäkymä. 
     * @param teksti
     * @param kirjalista Kyseessä oleva kirjalista (omistetut tai halutut) 
     */
    public void asetaNakyma();
    
}
