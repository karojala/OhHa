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
public class LisaysNakyma implements Nakyma {

    private Kirjalista kirjalista;
    private JPanel ikkuna;
    
    private JTextField nimi;
    private JTextField kirjoittaja;
    private JTextField julkvuosi;

    public LisaysNakyma(Kirjalista kirjalista, JPanel ikkuna) {
        this.kirjalista = kirjalista;
        this.ikkuna = ikkuna;
        
        this.nimi = new JTextField("Kirjan nimi: ", 5);
        this.kirjoittaja = new JTextField("Kirjan kirjoittaja: ", 5);
        this.julkvuosi = new JTextField("Kirjan julkaisuvuosi: ", 5);
    }

    @Override
    public void asetaNakyma() {
        this.ikkuna.removeAll();
        this.ikkuna.setLayout(new BoxLayout(this.ikkuna, BoxLayout.Y_AXIS));
        this.ikkuna.add(this.nimi, Component.TOP_ALIGNMENT);
        this.ikkuna.add(this.kirjoittaja, Component.TOP_ALIGNMENT);
        this.ikkuna.add(this.julkvuosi, Component.TOP_ALIGNMENT);
        lisaysNappi(this.ikkuna);
        this.ikkuna.revalidate();
        this.ikkuna.repaint();
    }
    
    private void lisaysNappi(JPanel ikkuna) {
        JButton nappi = new JButton("Valmis");
        nappi.setAlignmentY(Component.CENTER_ALIGNMENT);
        nappi.addActionListener(new KirjanLisaajaKuuntelija(this.kirjalista));
        ikkuna.add(nappi);
    }
}
