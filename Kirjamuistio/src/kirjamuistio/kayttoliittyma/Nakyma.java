package kirjamuistio.kayttoliittyma;

/**
 * Rajapinta. Näkymä Kirjanäkymän sisällä. 
 * @author Karita Ojala
 */
public interface Nakyma {
    
    /**
     * Asettaa graafiseen käyttöliittymään keskelle välilehden sisälle JPaneliin näkymän.
     * @param teksti
     * @param kirjalista Kyseessä oleva kirjalista (omistetut tai halutut) 
     */
    public void asetaNakyma();
    
}
