package kirjamuistio.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * KirjaTest-luokka testaa Kirja-luokan metodien toimintaa
 * 
 * @author Karita Ojala
 */
public class KirjaTest {

    Kirja kirja;

    @Before
    public void setUp() {
        kirja = new Kirja("The Selfish Gene", "Richard Dawkins", "1976");
    }
    
    @Test
    public void lyhytStringTulostaaOikein() {
        assertEquals("'The Selfish Gene', Richard Dawkins", kirja.lyhytString());
    }
    
    @Test
    public void toStringTulostaaOikein() {
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976", kirja.toString());
    }
}
