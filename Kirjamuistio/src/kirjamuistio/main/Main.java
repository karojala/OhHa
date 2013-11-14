package kirjamuistio.main;

import kirjamuistio.logiikka.Halutut;
import kirjamuistio.logiikka.Kirja;
import kirjamuistio.logiikka.Kirjalista;
import kirjamuistio.logiikka.Omistetut;
import kirjamuistio.kayttoliittyma.Kayttoliittyma;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
        // Tämä toteutetaan myöhemmin käyttöliittymässä
        /*Kirjalista omistetut = new Omistetut();
        omistetut.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976, "Populaaritiede", "978-0-19-929115-1"));
        omistetut.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976));
        omistetut.lisaaKirja(new Kirja("The God Delusion", "Richard Dawkins", 1980));
        omistetut.lisaaKirja(new Kirja("Statistical Methods For Psychology", "David C. Howell", 2012));
        
        Kirjalista halutut = new Halutut();
        halutut.lisaaKirja(new Kirja("Abarat", "Clive Barker", 2000, "Nuorten fantasia"));
        halutut.lisaaKirja(new Kirja("Pride and Prejudice", "Jane Austen", 1813, "Klassikot"));
        
        System.out.println(omistetut);
        System.out.println(halutut);*/
        
    }
}
