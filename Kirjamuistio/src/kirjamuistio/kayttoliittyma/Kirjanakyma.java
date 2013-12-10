package kirjamuistio.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
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

        ListausNakyma listaus = new ListausNakyma(this.kirjalista, this.tiedosto, ikkuna, alanapit);

        LisaysNakyma lisays = new LisaysNakyma(this.kirjalista, this.tiedosto, ikkuna);

        HakuNakyma haku = new HakuNakyma(this.kirjalista, this.tiedosto, ikkuna, alanapit);
        
        JPanel napit = new JPanel();
        napit.setLayout(new FlowLayout());
        napit.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.add(napit);

        lisaaNappi("Näytä lista kirjoista", this, napit, listaus);
        lisaaNappi("Lisää uusi kirja", this, napit, lisays);
        lisaaNappi("Hae kirjoja", this, napit, haku);

    }

    public JButton lisaaNappi(String teksti, Container container, JPanel napit, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new NapinKuuntelija(napit, nakyma, this.kirjalista));
        napit.add(nappi);
        return nappi;
    }
}
