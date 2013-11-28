package kirjamuistio.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import kirjamuistio.logiikka.Kirjalista;

/**
 * Näkymä Kirjanakyman sisällä, jossa napin painalluksesta tulee näkyviin
 * tekstikenttiä, joihin täytetään kirjan tiedot ja lopulta nappia painamalla
 * lisätään Kirja-olio kirjalistaan annetuilla tiedoilla.
 *
 * @author Karita Ojala
 */
public class LisaysNakyma extends JPanel implements Nakyma {

    private JTextField nimi;
    private JTextField kirjoittaja;
    private JTextField julkvuosi;

    public LisaysNakyma() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.nimi = new JTextField(10);
        this.kirjoittaja = new JTextField(10);
        this.julkvuosi = new JTextField(10);
    }

    @Override
    public void asetaNakyma(JComponent tekstikentta, Kirjalista kirjalista) {
        this.add(this.nimi, Component.TOP_ALIGNMENT);
        this.add(this.kirjoittaja, Component.TOP_ALIGNMENT);
        this.add(this.julkvuosi, Component.TOP_ALIGNMENT);
    }
}
