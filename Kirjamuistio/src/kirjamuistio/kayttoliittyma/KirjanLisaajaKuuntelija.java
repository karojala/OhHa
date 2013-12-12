package kirjamuistio.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JTextField;
import kirjamuistio.logiikka.Kirja;
import kirjamuistio.logiikka.Kirjalista;

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
    private JTextField isbn;

    public KirjanLisaajaKuuntelija(Kirjalista kirjalista, File tiedosto, JTextField nimi, JTextField kirj, JTextField jvuosi, JTextField isbn) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.nimi = nimi;
        this.kirj = kirj;
        this.jvuosi = jvuosi;
        this.isbn = isbn;
    }

    /**
     *
     * @param e Tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String knimi = this.nimi.getText();
        String kkirj = this.kirj.getText();
        String vuosi = this.jvuosi.getText();
        String kisbn = this.isbn.getText();
        Kirja kirja = new Kirja(knimi, kkirj, vuosi, kisbn);

        this.kirjalista.lisaaKirja(kirja);

        try {
            kirjoitusTiedostoon();
        } catch (IOException ex) {
            System.err.println("Ongelma kirjoittaessa tiedostoon");
        }

        this.nimi.setText("");
        this.kirj.setText("");
        this.jvuosi.setText("");
        this.isbn.setText("");
    }

    public void kirjoitusTiedostoon() throws FileNotFoundException, IOException {
        FileOutputStream is = new FileOutputStream(this.tiedosto);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(this.kirjalista.toString());
        } finally {
           is.close();
        }
    }
}
