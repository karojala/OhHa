package kirjamuistio.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JTextArea;
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

    /**
     * Kirjalista, joko Omistetut tai Halutut riippuen välilehdestä.
     */
    private Kirjalista kirjalista;
    /**
     * Tekstitiedosto, johon kirjalista tallennetaan (eri riippuen
     * kirjalistasta).
     */
    private File tiedosto;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan nimi.
     */
    private JTextField nimi;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan kirjoittaja.
     */
    private JTextField kirj;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan julkaisuvuosi.
     */
    private JTextField jvuosi;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan ISBN-koodi.
     */
    private JTextField isbn;
    /**
     * Tekstialue, johon ilmestyy palaute, jos jokin kenttä ei ole hyväksyttävä.
     */
    private JTextArea palaute;

    public KirjanLisaajaKuuntelija(Kirjalista kirjalista, File tiedosto, JTextField nimi, JTextField kirj, JTextField jvuosi, JTextField isbn, JTextArea palaute) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.nimi = nimi;
        this.kirj = kirj;
        this.jvuosi = jvuosi;
        this.isbn = isbn;
        this.palaute = palaute;
    }

    /**
     * Napin painalluksesta luo Kirja-olion, joka lisätään Kirjalistaan, ja
     * kirjoittaa Kirjalistan tekstitiedostoon. Lopuksi kentät tyhjennetään.
     *
     * @param e Tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.palaute.removeAll();
        System.setOut(new PrintStreamCapturer(palaute, System.out));

        luoKirja();

        try {
            kirjoitusTiedostoon();
        } catch (IOException ex) {
            System.err.println("Ongelma kirjoittaessa tiedostoon");
        }

        asetaTyhjiksi();
    }

    /**
     * Luo Kirja-olion tekstikenttien tiedoista ja lisää sen Kirjalistaan.
     *
     * @return Luotu kirja
     */
    public void luoKirja() {
        String knimi = this.nimi.getText();
        String kkirj = this.kirj.getText();
        String vuosi = this.jvuosi.getText();
        String kisbn = this.isbn.getText();
        Kirja kirja = new Kirja(knimi, kkirj, vuosi, kisbn);
        this.kirjalista.lisaaKirja(kirja);
    }

    /**
     * Asettaa tekstikentät tyhjiksi.
     */
    public void asetaTyhjiksi() {
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
