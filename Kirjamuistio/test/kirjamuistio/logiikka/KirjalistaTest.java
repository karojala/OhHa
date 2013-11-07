package kirjamuistio.logiikka;

import org.junit.*;
import static org.junit.Assert.*;

public class KirjalistaTest {

    Kirja kirja;
    Kirjalista kirjalista;

    @Before
    public void setUp() {
        kirjalista = new Kirjalista();
        kirja = new Kirja("The Selfish Gene", "Richard Dawkins", 1976);
    }

    @Test
    public void kirjanTietojenTarkistusOikein() {
        Kirja kirja2 = new Kirja("", "", 0);
        assertTrue(kirjalista.tarkistaKirjanTiedot(kirja));
        assertFalse(kirjalista.tarkistaKirjanTiedot(kirja2));
    }

    @Test
    public void kirjanLisaaminenOnnistuu() {
        kirjalista.lisaaKirja(kirja);
        assertTrue(kirjalista.onkoKirja(kirja));
    }

    @Test
    public void kirjanPoistaminenOnnistuu() {
        kirjalista.lisaaKirja(kirja);
        kirjalista.poistaKirja(kirja.getNimi());
        assertFalse(kirjalista.onkoKirja(kirja));
    }

    /*
     * @Test public void samaaKirjaaEiLisataToiste() {
     * kirjalista.lisaaKirja(kirja);
    }
     */
    @Test
    public void nimiHakuToimii() {
        kirjalista.lisaaKirja(kirja);
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976", kirjalista.nimiHaku(kirja.getNimi()));
    }

    @Test
    public void kirjoittajaHakuToimii() {
        kirjalista.lisaaKirja(kirja);
        String tulos = kirjalista.kirjoittajaHaku(kirja.getKirjoittaja());
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976" + "\n", tulos);
    }

    @Test
    public void julkaisuvuosiHakuToimii() {
        kirjalista.lisaaKirja(kirja);
        String tulos = kirjalista.julkaisuvuosiHaku(kirja.getJulkaisuvuosi());
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976" + "\n", tulos);
    }
}
