package kirjamuistio.kayttoliittyma;

import java.awt.*;
import java.io.*;
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
    private File tiedosto;
    private JPanel ikkuna;
    private SpringLayout layout;
    private JTextField nimi;
    private JTextField kirjoittaja;
    private JTextField julkvuosi;

    public LisaysNakyma(Kirjalista kirjalista, File tiedosto, JPanel ikkuna) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.ikkuna = ikkuna;
        this.layout = new SpringLayout();

        this.nimi = new JTextField(20);
        this.kirjoittaja = new JTextField(20);
        this.julkvuosi = new JTextField(20);
    }

    @Override
    public void asetaNakyma() {
        this.ikkuna.removeAll();
        this.ikkuna.setLayout(this.layout);

        lisaaKomponentti("Kirjan nimi: ", this.nimi, 5);
        lisaaKomponentti("Kirjan kirjoittaja: ", this.kirjoittaja, 35);
        lisaaKomponentti("Kirjan julkaisuvuosi: ", this.julkvuosi, 65);
        lisaaNappi();

        this.ikkuna.revalidate();
        this.ikkuna.repaint();
    }
    
    public void lisaaKomponentti(String teksti, JTextField kentta, int northraja) {
        JLabel label = new JLabel(teksti);
        this.ikkuna.add(label);
        this.ikkuna.add(kentta);
        asetaRajat(this.layout, label, kentta, northraja);
    }
    
    public void lisaaNappi() {
        JButton nappi = new JButton("Valmis");
        nappi.addActionListener(new KirjanLisaajaKuuntelija(this.kirjalista, this.tiedosto, this.nimi, this.kirjoittaja, this.julkvuosi));
        this.ikkuna.add(nappi);
        this.layout.putConstraint(SpringLayout.WEST, nappi, 5, SpringLayout.WEST, this.ikkuna);
        this.layout.putConstraint(SpringLayout.NORTH, nappi, 105, SpringLayout.NORTH, this.ikkuna);
    }
    
    public void asetaRajat(SpringLayout layout, JComponent component, JComponent component2, int northraja) {
        layout.putConstraint(SpringLayout.WEST, component, 5, SpringLayout.WEST, this.ikkuna);
        layout.putConstraint(SpringLayout.NORTH, component, northraja, SpringLayout.NORTH, this.ikkuna);
        layout.putConstraint(SpringLayout.WEST, component2, 5, SpringLayout.EAST, component);
        layout.putConstraint(SpringLayout.NORTH, component2, northraja, SpringLayout.NORTH, this.ikkuna);
    }
}
