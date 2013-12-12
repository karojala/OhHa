package kirjamuistio.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import kirjamuistio.logiikka.Kirjalista;

/**
 *
 * @author karojala
 */
public class Kirjanakyma extends JPanel {

    private Kirjalista kirjalista;
    private File tiedosto;

    public Kirjanakyma(Kirjalista kirjalista, File tiedosto) {
        super(false);
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        teeSisalto();
    }

    private void teeSisalto() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel ikkuna = new JPanel();
        ikkuna.setLayout(new BorderLayout());
        this.add(ikkuna, BorderLayout.CENTER);

        JPanel alanapit = new JPanel();
        this.add(alanapit);

        JPanel napit = new JPanel();
        this.add(napit);

        JPanel hakualue = new JPanel();
        this.add(hakualue);

        ListausNakyma listaus = new ListausNakyma(this.kirjalista, this.tiedosto, ikkuna, alanapit);
        LisaysNakyma lisays = new LisaysNakyma(this.kirjalista, this.tiedosto, ikkuna);
        HakuNakyma haku = new HakuNakyma(this.kirjalista, ikkuna, hakualue);

        lisaaNappi("Näytä kaikki kirjat", this, napit, listaus);
        lisaaNappi("Lisää uusi kirja", this, napit, lisays);
        
        listaus.asetaNakyma();
        haku.asetaNakyma();

    }

    public JButton lisaaNappi(String teksti, Container container, JPanel napit, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new NapinKuuntelija(nakyma));
        napit.add(nappi);
        return nappi;
    }
}
