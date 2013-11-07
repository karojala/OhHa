package kirjamuistio.logiikka;

import org.junit.*;
import static org.junit.Assert.*;

public class KirjaTest {

    Kirja kirja;

    @Before
    public void setUp() {
        kirja = new Kirja("The Selfish Gene", "Richard Dawkins", 1976);
    }
    
    @Test
    public void toStringTulostaaOikein() {
        assertEquals("'The Selfish Gene', Richard Dawkins, 1976", kirja.toString());
    }
}
