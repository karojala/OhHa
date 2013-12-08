package kirjamuistio.kayttoliittyma;

import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Kirja;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * KirjanLisaajaKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on
 * toteuttaa napinpainallusominaisuus, jonka tuloksena kirjan tiedoista luodaan
 * Kirja-olio ja Kirja-olio lisätään Kirjalistaan (Omistetut tai Halutut).
 *
 * @author Karita Ojala
 */
public class KirjanLisaajaKuuntelija implements ActionListener {

    private Kirjalista kirjalista;
    private File tiedosto;
    private JTextField nimi;
    private JTextField kirj;
    private JTextField jvuosi;

    public KirjanLisaajaKuuntelija(Kirjalista kirjalista, File tiedosto, JTextField nimi, JTextField kirj, JTextField jvuosi) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.nimi = nimi;
        this.kirj = kirj;
        this.jvuosi = jvuosi;
    }

    /**
     *
     * @param e Tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String knimi = this.nimi.getText();
        String kkirj = this.kirj.getText();
        int vuosi = Integer.parseInt(this.jvuosi.getText());
        Kirja kirja = new Kirja(knimi, kkirj, vuosi);

        this.kirjalista.lisaaKirja(kirja);

        try {
            kirjoitusTiedostoon();
        } catch (IOException error) {
            System.err.println("Problem writing to the file");
        }

        this.nimi.setText("");
        this.kirj.setText("");
        this.jvuosi.setText("");
    }

    // Muutettava niin, että erilliset tekstitiedostot omistetuille ja halutuille kirjoille
    public void kirjoitusTiedostoon() throws FileNotFoundException, IOException {
        FileOutputStream is = new FileOutputStream(this.tiedosto);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(this.kirjalista.toString());
        }
    }
}
