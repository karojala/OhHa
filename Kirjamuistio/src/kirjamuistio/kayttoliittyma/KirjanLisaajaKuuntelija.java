package kirjamuistio.kayttoliittyma;

import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Kirja;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * KirjanLisaajaKuuntelija on tapahtumakuuntelija, jonka tarkoituksena on
 * toteuttaa napinpainallusominaisuus, jonka tuloksena kirjan tiedoista luodaan
 * Kirja-olio ja Kirja-olio lisätään Kirjalistaan (Omistetut tai Halutut).
 *
 * @author Karita Ojala
 */
public class KirjanLisaajaKuuntelija implements ActionListener {

    private Kirjalista kirjalista;
    private JTextField nimi;
    private JTextField kirj;
    private JTextField jvuosi;

    public KirjanLisaajaKuuntelija(Kirjalista kirjalista, JTextField nimi, JTextField kirj, JTextField jvuosi) {
        this.kirjalista = kirjalista;
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
            kirjoitusTiedostoon(kirja.toString());
        } catch (IOException error) {
            System.err.println("Problem writing to the file kirjalista.txt");
        }
        this.nimi.setText("");
        this.kirj.setText("");
        this.jvuosi.setText("");
    }

    // Muutettava niin, että erilliset tekstitiedostot omistetuille ja halutuille kirjoille
    public void kirjoitusTiedostoon(String teksti) throws FileNotFoundException, IOException {
            File statText = new File("kirjalista.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(teksti);
            w.close();
    }
}
