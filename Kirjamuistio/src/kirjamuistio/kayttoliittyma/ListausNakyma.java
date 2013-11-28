package kirjamuistio.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

import kirjamuistio.logiikka.Kirjalista;


/**
 * Näkymä Kirjanakyman sisällä, jossa napin painalluksesta tulee näkyviin lista kirjoista. 
 * @author Karita Ojala
 */
public class ListausNakyma extends JPanel implements Nakyma {

    private JTextArea tekstikentta;
    private Kirjalista kirjalista;
    private JComponent sisalto;

    public ListausNakyma(JComponent tayte, Kirjalista kirjalista) {
        this.tekstikentta = new JTextArea();
        this.kirjalista = kirjalista;
        this.sisalto = tayte;
    }
    
    @Override
    public void asetaNakyma(JComponent tekstikentta, Kirjalista kirjalista) {
        //Täyteolion poisto ja tilalle tekstikenttä. 
        this.add(tekstikentta);
        this.tekstikentta.setText(kirjalista.toString());
    }
}
