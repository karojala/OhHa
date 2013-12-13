package kirjamuistio.kayttoliittyma;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import kirjamuistio.logiikka.Kirjalista;

/**
 * Kirjanäkymä on käyttäliittymän näkymistä perustavin.
 *
 * @author Karita Ojala
 */
public class Kirjanakyma extends JPanel {

    /**
     * Kirjalista, joko Omistetut tai Halutut riippuen välilehdestä.
     */
    private Kirjalista kirjalista;
    /**
     * Tekstitiedosto, johon kirjalista tallennetaan (eri riippuen
     * kirjalistasta).
     */
    private File tiedosto;

    public Kirjanakyma(Kirjalista kirjalista, File tiedosto) {
        super(false);
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        teeSisalto();
    }

    /**
     * Tekee Kirjanäkymän sisällön. Luo Kirjanäkymän sisälle JPanelit, joihin
     * tulee erilaista sisältöä riippuen nappien painalluksista yms. Asettaa
     * alkunäkymän.
     */
    private void teeSisalto() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel ikkuna = new JPanel();
        ikkuna.setLayout(new BorderLayout());
        this.add(ikkuna, BorderLayout.CENTER);

        // Ensimmäinen nappirivistö
        JPanel alanapit = new JPanel();
        this.add(alanapit);

        // Toinen nappirivistö
        JPanel napit = new JPanel();
        this.add(napit);

        // Hakutoiminnolle tarkoitettu alue
        JPanel hakualue = new JPanel();
        this.add(hakualue);

        ListausNakyma listaus = new ListausNakyma(this.kirjalista, this.tiedosto, ikkuna, alanapit, hakualue);
        LisaysNakyma lisays = new LisaysNakyma(this.kirjalista, this.tiedosto, ikkuna);

        lisaaNappi("Näytä kaikki kirjat", napit, listaus);
        lisaaNappi("Lisää uusi kirja", napit, lisays);

        listaus.asetaNakyma();
    }
    /**
     * Tekee JButtoneita.
     *
     * @param teksti Napissa näkyvä teksti
     * @param napit JPanel, johon nappi laitetaan
     * @param nakyma Nakymä, joka avautuu nappia painamalla
     */
    public void lisaaNappi(String teksti, JPanel napit, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new NapinKuuntelija(nakyma));
        napit.add(nappi);
    }
}
