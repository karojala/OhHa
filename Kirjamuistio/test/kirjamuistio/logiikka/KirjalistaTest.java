package kirjamuistio.logiikka;

import org.junit.*;
import static org.junit.Assert.*;

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
        kirja = new Kirja("The Selfish Gene", "Richard Dawkins", 1976);
        kirjalista.lisaaKirja(kirja);
    }

    @Test
    public void kirjanTietojenTarkistusOikein() {
        Kirja kirja2 = new Kirja("", "", 0);
        assertTrue(kirjalista.tarkistaKirjanTiedot(kirja));
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
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
        assertEquals(null, tulos);
    }
    
    @Test
    public void kirjoittajaHakuTyhjallaKentalla() {
        String tulos = kirjalista.kirjoittajaHaku("");
        assertEquals(null, tulos);
    }
    
    @Test
    public void julkvuosiHakuNollalla() {
        String tulos = kirjalista.julkaisuvuosiHaku(0);
        assertEquals(null, tulos);
    }
}
