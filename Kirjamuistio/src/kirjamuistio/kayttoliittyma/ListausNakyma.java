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
 * kirjoista.
 *
 * @author Karita Ojala
 */
public class ListausNakyma implements Nakyma {

    private Kirjalista kirjalista;
    private File tiedosto;
    private JList tekstikentta;
    private ArrayList kentansisalto;
    DefaultListModel model;
    BufferedReader reader;
    private JScrollPane scroll;
    private JPanel ikkuna;
    private JPanel alanapit;

    public ListausNakyma(Kirjalista kirjalista, File tiedosto, JPanel ikkuna, JPanel alanapit) {
        this.kirjalista = kirjalista;
        this.tiedosto = tiedosto;
        this.ikkuna = ikkuna;
        this.alanapit = alanapit;
        teeLista();
        this.scroll = new JScrollPane(this.tekstikentta);
        this.kentansisalto = new ArrayList();
    }

    private void teeLista() {
        this.model = new DefaultListModel();
        this.tekstikentta = new JList(this.model);
        this.tekstikentta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tekstikentta.setLayoutOrientation(JList.VERTICAL);
        this.tekstikentta.setVisibleRowCount(-1);

        try {
            ArrayList sisalto = lukuTiedostosta();
            for (Object rivi : sisalto) {
                String tiedot = (String) rivi;
                String[] osat = tiedot.split(",");
                String nimi = osat[0];
                nimi = nimi.replace("'", "").trim();
                String kirj = osat[1].trim();
                String vuosi = osat[2].trim();
                int jvuosi = Integer.parseInt(vuosi);
                Kirja kirja = new Kirja(nimi, kirj, jvuosi);
                this.kirjalista.lisaaKirja(kirja);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void asetaLista() {
        this.model.clear();

        for (Kirja kirja : this.kirjalista.kirjalista()) {
            this.model.addElement(kirja.toString());
            this.kentansisalto.add(kirja.getNimi());
        }
    }

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

        MuokkausNakyma muokkaus = new MuokkausNakyma(this.kirjalista, this.tiedosto, this.ikkuna, this.tekstikentta, this.model, this.kentansisalto);
        
        lisaaMuokkausNappi("Näytä kirjan tiedot", this.alanapit, muokkaus);
        lisaaMuokkausNappi("Muokkaa kirjan tietoja", this.alanapit, muokkaus);
        lisaaPoistoNappi("Poista kirja", this.alanapit);
        
        this.alanapit.revalidate();
        this.alanapit.repaint();
    }

    public void lisaaMuokkausNappi(String teksti, JPanel napit, Nakyma nakyma) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new NapinKuuntelija(napit, nakyma, this.kirjalista));
        napit.add(nappi);
    }
    
    public void lisaaPoistoNappi(String teksti, JPanel napit) {
        JButton nappi = new JButton(teksti);
        nappi.addActionListener(new KirjanPoistoKuuntelija(this.kirjalista, this.tiedosto, this.tekstikentta, this.model, this.kentansisalto));
        napit.add(nappi);
    }

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
