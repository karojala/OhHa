package kirjamuistio.logiikka;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * KirjalistaTest-luokka testaa Kirjalista-luokan metodien toimintaa
 *
 * @author Karita Ojala
 */
public class KirjalistaTest {

    Kirja kirja;
    Kirjalista kirjalista;

    @Before
    public void setUp() {
        kirjalista = new Omistetut();
        kirja = new Kirja("The Selfish Gene", "Richard Dawkins", "1976");
        kirjalista.lisaaKirja(kirja);
    }

    @Test
    public void kirjanTietojenTarkistusOikein() {
        assertTrue(kirjalista.tarkistaKirjanTiedot(kirja));
    }

    @Test
    public void kirjanNimenTarkistusVaarin() {
        Kirja kirja2 = new Kirja("", "Ben Aaronovitch", "2013");
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
    }

    @Test
    public void kirjanKirjoittajanTarkistusVaarin() {
        Kirja kirja2 = new Kirja("Broken Homes", "", "2013");
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
    }

    @Test
    public void kirjanJulkvuodenTarkistusVaarin1() {
        Kirja kirja2 = new Kirja("Broken Homes", "Ben Aaronovitch", "");
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
    }

    @Test
    public void kirjanJulkvuodenTarkistusVaarin2() {
        Kirja kirja2 = new Kirja("Broken Homes", "Ben Aaronovitch", "0");
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
    }

    @Test
    public void kirjanJulkvuodenTarkistusVaarin3() {
        Kirja kirja2 = new Kirja("Broken Homes", "Ben Aaronovitch", "2100");
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
    }

    @Test
    public void getKirjaToimii() {
        assertEquals(kirjalista.getKirja("The Selfish Gene"), kirja);
    }
    
    @Test
    public void kirjanLisaaminenOnnistuu() {
        assertTrue(kirjalista.onkoKirja(kirja));
    }

    @Test
    public void kirjanPoistaminenOnnistuu() {
        kirjalista.poistaKirja(kirja.getNimi());
        assertFalse(kirjalista.onkoKirja(kirja));
    }

    @Test
    public void nimiHakuToimii() {
        String tulos = kirjalista.nimiHaku(kirja.getNimi());
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976" + "\n", tulos);
    }

    @Test
    public void kirjoittajaHakuToimii() {
        String tulos = kirjalista.kirjoittajaHaku(kirja.getKirjoittaja());
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976" + "\n", tulos);
    }

    @Test
    public void julkaisuvuosiHakuToimii() {
        String tulos = kirjalista.julkaisuvuosiHaku(kirja.getJulkaisuvuosi());
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976" + "\n", tulos);
    }

    @Test
    public void nimiHakuTyhjallaKentalla() {
        String tulos = kirjalista.nimiHaku("");
        assertEquals("Nimihakua ei voi tehdä tyhjällä kentällä", tulos);
    }

    @Test
    public void nimiHakuEiLoydy() {
        String tulos = kirjalista.nimiHaku("Liisa Ihmemaassa");
        assertEquals("Hakemallasi nimellä ei löytynyt yhtäkään kirjaa", tulos);
    }

    @Test
    public void kirjoittajaHakuTyhjallaKentalla() {
        String tulos = kirjalista.kirjoittajaHaku("");
        assertEquals("Kirjoittajahakua ei voi tehdä tyhjällä kentällä", tulos);
    }

    @Test
    public void kirjoittajaHakuEiLoydy() {
        String tulos = kirjalista.kirjoittajaHaku("Albert Einstein");
        assertEquals("Hakemallasi kirjoittajalla ei löytynyt yhtäkään kirjaa", tulos);
    }

    @Test
    public void julkvuosiHakuTyhjallaKentalla() {
        String tulos = kirjalista.julkaisuvuosiHaku("");
        assertEquals("Julkaisuvuosihakua ei voi tehdä tyhjällä kentällä", tulos);
    }

    @Test
    public void julkvuosiHakuNollalla() {
        String tulos = kirjalista.julkaisuvuosiHaku("0");
        assertEquals("Hakemallasi julkaisuvuodella ei löytynyt yhtäkään kirjaa", tulos);
    }

    @Test
    public void julkvuosiHakuTulevaisuudessa() {
        String tulos = kirjalista.julkaisuvuosiHaku("2100");
        assertEquals("Hakemallasi julkaisuvuodella ei löytynyt yhtäkään kirjaa", tulos);
    }

    @Test
    public void julkvuosiHakuEiLoydy() {
        String tulos = kirjalista.julkaisuvuosiHaku("1950");
        assertEquals("Hakemallasi julkaisuvuodella ei löytynyt yhtäkään kirjaa", tulos);
    }
}
