package kirjamuistio.kayttoliittyma;

import java.awt.BorderLayout;
import java.io.BufferedReader;
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
    private JList tekstikentta;
    DefaultListModel model;
    BufferedReader reader;
    private JScrollPane scroll;
    private JPanel ikkuna;

    public ListausNakyma(Kirjalista kirjalista, JPanel ikkuna) {
        this.kirjalista = kirjalista;
        this.ikkuna = ikkuna;
        teeLista();
        this.scroll = new JScrollPane(this.tekstikentta);
    }

    private void teeLista() {
        this.model = new DefaultListModel();
        this.tekstikentta = new JList(this.model);
        this.tekstikentta.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.tekstikentta.setLayoutOrientation(JList.VERTICAL);
        this.tekstikentta.setVisibleRowCount(-1);
    }
    
    private void asetaLista() {
        this.model.clear();
        
        for (Kirja kirja : this.kirjalista.kirjalista()) {
            this.model.addElement(kirja.toString());
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
    }
}
