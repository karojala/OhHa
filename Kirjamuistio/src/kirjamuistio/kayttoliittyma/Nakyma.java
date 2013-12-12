package kirjamuistio.kayttoliittyma;

/**
 * Rajapinta/abstrakti luokka. Näkymä-oliot ovat Kirjanäkymän sisällä. 
 * @author Karita Ojala
 */
public interface Nakyma {
    
    /**
     * Asettaa graafiseen käyttöliittymään keskelle välilehden sisälle JPaneliin näkymän.
     * Metodi asettaa erilaisen näkymän riippuen implementoivasta luokasta. 
     */
    public void asetaNakyma();
    
}
