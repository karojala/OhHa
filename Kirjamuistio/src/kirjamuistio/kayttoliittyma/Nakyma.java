
package kirjamuistio.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

import kirjamuistio.logiikka.Kirjalista;

/**
 * Näkymä Kirjanäkymän sisällä
 * @author Karita Ojala
 */
public interface Nakyma {
    
    public void asetaNakyma(JComponent teksti, Kirjalista kirjalista);
    
}
