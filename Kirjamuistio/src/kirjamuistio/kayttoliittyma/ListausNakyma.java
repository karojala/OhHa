package kirjamuistio.kayttoliittyma;

import java.awt.*;
import java.io.*;
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

    public void teeLista() {
        this.model = new DefaultListModel();
        this.tekstikentta = new JList(this.model);
        this.tekstikentta.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.tekstikentta.setLayoutOrientation(JList.VERTICAL);
        this.tekstikentta.setVisibleRowCount(-1);
    }
    
    public void asetaLista() {
        this.model.clear();
        
        for (Kirja kirja : this.kirjalista.kirjalista()) {
            this.model.addElement(kirja.toString());
        }
    }

    /*public void haeTiedostosta() {
        File tiedosto = new File("kirjalista.txt");
        try {
            this.reader = new BufferedReader(new FileReader(tiedosto));
            String teksti;
            
            while ((teksti = reader.readLine()) != null) {
                this.model.addElement(teksti);
                System.out.println(teksti);
            }
            this.tekstikentta.setModel(model);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    @Override
    public void asetaNakyma() {
        this.ikkuna.removeAll();
        this.ikkuna.setLayout(new BorderLayout());
        /*this.tekstikentta.setText(this.kirjalista.toString());
        this.tekstikentta.setEditable(false);*/
        asetaLista();
        this.ikkuna.add(this.scroll);
        this.ikkuna.revalidate();
        this.ikkuna.repaint();
    }
}
