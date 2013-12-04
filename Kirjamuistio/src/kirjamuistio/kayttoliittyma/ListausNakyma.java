package kirjamuistio.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

import kirjamuistio.logiikka.Kirjalista;


/**
 * Näkymä Kirjanakyman sisällä, jossa napin painalluksesta tulee näkyviin lista kirjoista. 
 * @author Karita Ojala
 */
public class ListausNakyma implements Nakyma {

    private Kirjalista kirjalista;
    private JTextArea tekstikentta;
    private JScrollPane scroll;
    private JPanel ikkuna;

    public ListausNakyma(Kirjalista kirjalista, JPanel ikkuna) {
        this.kirjalista = kirjalista;
        this.ikkuna = ikkuna;
        this.tekstikentta = new JTextArea();
        this.scroll = new JScrollPane(this.tekstikentta);
    }
    
    @Override
    public void asetaNakyma() {
        this.ikkuna.removeAll();
        this.tekstikentta.setText(this.kirjalista.toString());
        this.tekstikentta.setEditable(false);
        this.ikkuna.add(this.scroll);
        this.ikkuna.revalidate();
        this.ikkuna.repaint();
    }
}
