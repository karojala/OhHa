package kirjamuistio.kayttoliittyma;

import java.io.File;
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
     * JPanel, johon näkymän sisältö tulee.
     */
    private JPanel ikkuna;
    /**
     * Näkymän ulkoasu.
     */
    private SpringLayout layout;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan nimi.
     */
    private JTextField nimi;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan kirjoittaja.
     */
    private JTextField kirjoittaja;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan julkaisuvuosi.
     */
    private JTextField julkvuosi;
    /**
     * Tekstikenttä, johon kirjoitetaan kirjan ISBN-koodi.
     */
    private JTextField isbn;
    /**
     * Tekstialue, johon ilmestyy palaute, jos jokin kenttä ei ole hyväksyttävä.
     */
    private JTextArea palaute;

    public LisaysNakyma(Kirjalista kirjalista, File tiedosto, JPanel ikkuna) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.ikkuna = ikkuna;
        this.layout = new SpringLayout();

        this.nimi = new JTextField(20);
        this.kirjoittaja = new JTextField(20);
        this.julkvuosi = new JTextField(20);
        this.isbn = new JTextField(20);

        this.palaute = new JTextArea(5, 30);
    }

    /**
     * Tyhjentää ikkunan ja lisää siihen näkymän komponentit.
     */
    @Override
    public void asetaNakyma() {
        this.ikkuna.removeAll();
        this.ikkuna.setLayout(this.layout);

        lisaaKomponentti("Kirjan nimi: ", this.nimi, 5);
        lisaaKomponentti("Kirjan kirjoittaja: ", this.kirjoittaja, 35);
        lisaaKomponentti("Kirjan julkaisuvuosi: ", this.julkvuosi, 65);
        lisaaKomponentti("Kirjan ISBN: ", this.isbn, 95);
        lisaaNappi();
        lisaaPalauteAlue(175);

        this.ikkuna.revalidate();
        this.ikkuna.repaint();
    }

    /**
     * Lisää palautetekstikentän ikkunaan ja asettaa sille rajoitteet.
     *
     * @param northraja Komponenttien pohjoinen etäisyys seuraavaan
     * komponenttiin
     */
    public void lisaaPalauteAlue(int northraja) {
        this.ikkuna.add(this.palaute);
        this.palaute.setEditable(false);
        this.layout.putConstraint(SpringLayout.WEST, palaute, 5, SpringLayout.WEST, this.ikkuna);
        this.layout.putConstraint(SpringLayout.NORTH, palaute, northraja, SpringLayout.NORTH, this.ikkuna);
    }

    /**
     * Luo JLabelin, lisää sen ja siihen liittyvän tekstikentän ikkunaan ja
     * asettaa ulkoasun vaatimat rajat niille.
     *
     * @param teksti JLabeliin tuleva teksti
     * @param kentta JTextField, johon kirjoitetaan tieto
     * @param northraja Komponenttien pohjoinen etäisyys seuraavaan
     * komponenttiin
     */
    public void lisaaKomponentti(String teksti, JTextField kentta, int northraja) {
        JLabel label = new JLabel(teksti);
        this.ikkuna.add(label);
        this.ikkuna.add(kentta);
        asetaRajat(this.layout, label, kentta, northraja);
    }

    /**
     * Luo ja lisää "Valmis"-napin, jota painamalla kirjan tiedoista luodaan
     * Kirja-olio Kirjalistaan.
     */
    public void lisaaNappi() {
        JButton nappi = new JButton("Valmis");
        nappi.addActionListener(new KirjanLisaajaKuuntelija(this.kirjalista, this.tiedosto, this.nimi, this.kirjoittaja, this.julkvuosi, this.isbn, this.palaute));
        this.ikkuna.add(nappi);
        this.layout.putConstraint(SpringLayout.WEST, nappi, 5, SpringLayout.WEST, this.ikkuna);
        this.layout.putConstraint(SpringLayout.NORTH, nappi, 135, SpringLayout.NORTH, this.ikkuna);
    }

    /**
     * Komponenttien SpringLayout rajat (etäisyydet toisiinsa eri suunnissa).
     *
     * @param layout Näkymän SpringLayout
     * @param component Komponentti 1 (label)
     * @param component2 Komponentti 2 (tekstikenttä)
     * @param northraja Komponenttien pohjoinen etäisyys seuraavaan
     * komponenttiin
     */
    public void asetaRajat(SpringLayout layout, JComponent component, JComponent component2, int northraja) {
        layout.putConstraint(SpringLayout.WEST, component, 5, SpringLayout.WEST, this.ikkuna);
        layout.putConstraint(SpringLayout.NORTH, component, northraja, SpringLayout.NORTH, this.ikkuna);
        layout.putConstraint(SpringLayout.WEST, component2, 5, SpringLayout.EAST, component);
        layout.putConstraint(SpringLayout.NORTH, component2, northraja, SpringLayout.NORTH, this.ikkuna);
    }
}
