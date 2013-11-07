package kirjamuistio.logiikka;

import org.junit.*;
import static org.junit.Assert.*;

public class KayttajaTest {

    Kayttaja kayttaja;

    @Before
    public void SetUp() {
        kayttaja = new Kayttaja("Bibliofiili", "utopia");
    }

    @Test
    public void salasananVaihtoToimii() {
        kayttaja.setSalasana("utopia", "yksisarvinen");
        assertEquals("yksisarvinen", kayttaja.getSalasana());
    }
    
    @Test
    public void merkkijononTarkistusOikein() {
        assertTrue(kayttaja.sallittuMerkkijono("perhonen"));
        assertFalse(kayttaja.sallittuMerkkijono("lol"));
        assertFalse(kayttaja.sallittuMerkkijono("superyksisarvinen"));
    }
}