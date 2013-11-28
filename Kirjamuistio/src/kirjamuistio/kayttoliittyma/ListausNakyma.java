package kirjamuistio.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

/**
 * Näkymä Kirjanakyman sisällä, jossa napin painalluksesta tulee näkyviin lista kirjoista. 
 * @author Karita Ojala
 */
public class ListausNakyma extends JPanel {

    private JTextField tekstikentta;

    public ListausNakyma() {
        this.tekstikentta = new JTextField();
        this.add(tekstikentta, BorderLayout.CENTER);
    }
}
