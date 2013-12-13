package kirjamuistio.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.*;
import kirjamuistio.logiikka.Kirja;
import kirjamuistio.logiikka.Kirjalista;

/**
 * Näkymä Kirjanakyman sisällä, jossa napin painalluksesta tulee näkyviin lista
 * kirjoista. Sisältää myös ensimmäisen nappirivin.
 *
 * @author Karita Ojala
 */
public class ListausNakyma implements Nakyma {

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
     * JList, jossa kirjalista on esillä.
     */
    private JList tekstikentta;
    /**
     * JListin malli.
     */
    DefaultListModel model;
    /**
     * Bufferoiva lukija suurien tekstitiedostojen käsittelyyn.
     */
    BufferedReader reader;
    /**
     * JScrollPane, jonka sisällä JList on. Skrollattava alue.
     */
    private JScrollPane scroll;
    /**
     * JPanel, johon JList, JScrollPane yms. tulevat.
     */
    private JPanel ikkuna;
    /**
     * JPanel toimintonapeille.
     */
    private JPanel alanapit;
    /**
     * JPanel hakutoiminnolle.
     */
    private JPanel hakualue;

    public ListausNakyma(Kirjalista kirjalista, File tiedosto, JPanel ikkuna, JPanel alanapit, JPanel hakualue) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.ikkuna = ikkuna;
        this.alanapit = alanapit;
        this.hakualue = hakualue;
        teeLista();
        this.scroll = new JScrollPane(this.tekstikentta);
    }

    /**
     * Luo mallin ja JListin, joka käyttää mallia. Asettaa JListin näkyvyyteen,
     * valinnan laajuuteen yms. liittyviä ominaisuuksia. Käyttää tekstitiedoston
     * lukumetodia JListin sisällön hakemiseen.
     */
    private void teeLista() {
        this.model = new DefaultListModel();
        this.tekstikentta = new JList(this.model);
        this.tekstikentta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tekstikentta.setLayoutOrientation(JList.VERTICAL);
        this.tekstikentta.setVisibleRowCount(-1);

        try {
            ArrayList sisalto = lukuTiedostosta();
            for (Object rivi : sisalto) {
                kirjanLuonti(rivi);
            }
        } catch (IOException e) {
            System.err.println("Ongelma lukiessa tiedostosta");
        }
    }

    /**
     * Jakaa rivin sisältämän tiedon osiin, poistaa turhat osat ja luo tiedoista
     * Kirja-olion, jonka lisää Kirjalistaan.
     *
     * @param rivi
     */
    public void kirjanLuonti(Object rivi) {
        String tiedot = (String) rivi;
        String[] osat = tiedot.split("#");
        String nimi = osat[0];
        nimi = nimi.replace("'", "").trim();
        String kirj = osat[1].trim();
        
        String vuosi = null;
        if (osat.length > 2) {
            vuosi = osat[2].trim();
        }
        
        String isbn = null;
        if (osat.length > 3) {
            isbn = osat[3].trim();
        } 

        Kirja kirja = null;
        if (isbn != null && !vuosi.isEmpty()) {
            kirja = new Kirja(nimi, kirj, vuosi, isbn);
        } else if (vuosi != null) {
            kirja = new Kirja(nimi, kirj, vuosi);
        } else if (vuosi == null) {
            kirja = new Kirja(nimi, kirj);
        }

        this.kirjalista.lisaaKirja(kirja);
    }

    /**
     * Pyyhkii mallin tyhjäksi aikaisemmasta materiaalista ja lisää siihen
     * kaikki Kirjalistan sisältämien kirjojen lyhyet String-edustukset.
     */
    public void asetaLista() {
        this.model.clear();

        for (Kirja kirja : this.kirjalista.kirjalista()) {
            this.model.addElement(kirja.lyhytString());
        }
    }

    /**
     * Tyhjentää ikkunan ja asettaa siihen listan. Tyhjentää alanappi-osion, luo
     * "ala"näkymät ja laittaa siihen napit, joita painamalla niihin päästään.
     */
    @Override
    public void asetaNakyma() {
        this.ikkuna.removeAll();
        this.ikkuna.setLayout(new BorderLayout());

        asetaLista();

        this.ikkuna.add(this.scroll);
        this.ikkuna.revalidate();
        this.ikkuna.repaint();

        this.alanapit.removeAll();
        this.alanapit.setLayout(new FlowLayout());
        this.alanapit.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        this.hakualue.removeAll();
        
        
        MuokkausNakyma muokkaus = new MuokkausNakyma(this.kirjalista, this.tiedosto, this.ikkuna, this.tekstikentta, this.model);
        TietoNakyma tieto = new TietoNakyma(this.kirjalista, this.ikkuna, this.tekstikentta);
        HakuNakyma haku = new HakuNakyma(this.kirjalista, this.ikkuna, this.hakualue, this.model);

        lisaaPerusNappi("Näytä kirjan tiedot", this.alanapit, tieto);
        lisaaPerusNappi("Muokkaa kirjan tietoja", this.alanapit, muokkaus);
        lisaaPoistoNappi("Poista kirja", this.alanapit);
        haku.asetaNakyma();
    }

    /**
     * Luo ja lisää ns yleistä kuuntelijaa käyttävän perusnapin.
     *
     * @param teksti Napin teksti
     * @param napit JPanel, johon nappi laitetaan
     * @param nakyma Näkymä, jonka nappi aukaisee
     */
    public void lisaaPerusNappi(String teksti, JPanel napit, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new NapinKuuntelija(nakyma));
        napit.add(nappi);
    }

    /**
     * Luo ja lisää PoistoNäkymän avaavan napin.
     *
     * @param teksti Napin teksti
     * @param napit JPanel, johon nappi lisätään
     */
    public void lisaaPoistoNappi(String teksti, JPanel napit) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new KirjanPoistoKuuntelija(this.kirjalista, this.tiedosto, this.tekstikentta, this.model));
        napit.add(nappi);
    }

    /**
     * Lukee tekstitiedostosta rivi riviltä sisällön ja lisää jokaisen rivin
     * erikseen ArrayListiin.
     *
     * @return Tiedoston sisältö ArrayListissä
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ArrayList lukuTiedostosta() throws FileNotFoundException, IOException {
        ArrayList sisalto = new ArrayList();
        try (BufferedReader r = Files.newBufferedReader(this.tiedosto.toPath(), StandardCharsets.UTF_8)) {
            String rivi;
            while ((rivi = r.readLine()) != null) {
                sisalto.add(rivi);
            }
        }
        return sisalto;
    }
}
