package kirjamuistio.logiikka;

import java.util.ArrayList;

/**
 * Kirjalista on rajapinta/abstrakti luokka, joka määrittelee joukon metodeja toteutettavaksi
 * sen implementoiville luokille. 
 * Nämä metodit muodostavat kirjamuistion ydinosuuden.
 *
 * @author Karita Ojala
 */
public interface Kirjalista {

    /**
     * Metodi tarkistaa, että kirjalle on syötetty nimi, kirjoittaja ja oikeassa
     * muodossa oleva julkaisuvuosi
     *
     * @param kirja Luotu kirja
     * @return Ovatko kirjan tiedot ok, true tai false
     */
    public boolean tarkistaKirjanTiedot(Kirja kirja);

    /**
     * Kirjan getteri, joka siistii syötteen ja tarkistaa onko Kirjalistassa
     * vastaavan String-muotoista avainta, ja jos on, palauttaa sen arvon. Jos 
     * kirjaa ei löydy, tulostaa sen mukaisen syötteen. 
     * @param nimi Kirjan nimi
     * @return Kirja tai null
     */
    public Kirja getKirja(String nimi);
    /**
     * Kirjan lisäysmetodi, joka ensin tarkistaa kirjan tiedot toisen metodin
     * avulla, jonka jälkeen kirjan nimi haetaan siistityn version avulla.
     * Kirjaa ei voi lisätä, jos se on jo listassa. Jos kirjaa ei ole listassa,
     * kirja lisätään HashMapiin avaimenaan siistitty nimi ja arvona kirja-olio
     * itse.
     *
     * @param kirja Lisättävä kirja
     */
    public void lisaaKirja(Kirja kirja);

    /**
     * Metodi, joka poistaa nimeä vastaavan kirjan. Kirja hakee siistityn nimen
     * avulla avaimen, jonka poistaa arvoineen. Jos kirja ei ole listassa, sitä
     * ei voi poistaa.
     *
     * @param nimi Poistettavan kirjan nimi
     */
    public void poistaKirja(String nimi);

    /**
     * Kirjan haku nimen avulla.
     *
     * @param nimi Haettavan kirjan nimi
     * @return Nimen avulla löytynyt kirja
     */
    public String nimiHaku(String nimi);

    /**
     * Kirjojen haku kirjoittajan nimen avulla.
     *
     * @param nimi Haettavan kirjoittajan nimi
     * @return Kirjoittajan nimen avulla löytyneet kirjat
     */
    public String kirjoittajaHaku(String kirjoittaja);

    /**
     * Kirjojen haku julkaisuvuoden avulla.
     *
     * @param nimi Haettava julkaisuvuosi
     * @return Julkaisuvuoden avulla löytyneet kirjat
     */
    public String julkaisuvuosiHaku(String julkvuosi);

    /**
     * Tarkastaa, onko kirja olemassa kirjalistassa.
     *
     * @param nimi Tarkistettava kirja-olio
     * @return True jos kirja on listassa, false jos ei
     */
    public boolean onkoKirja(Kirja kirja);

    /**
     * Siistii annetun merkkijonon muuttaen isot kirjaimet pieniksi ja poistaen
     * turhat välit
     *
     * @param nimi Siistittävä merkkijono
     * @return Siistitty merkkijono
     */
    public String siistiMerkkijono(String merkkijono);

    /**
     * Palauttaa kirjalista-HashMapin arvot (eli kirja-oliot) ArrayListinä
     *
     * @return Kirja-oliot ArrayListinä
     */
    public ArrayList<Kirja> kirjalista();
}
