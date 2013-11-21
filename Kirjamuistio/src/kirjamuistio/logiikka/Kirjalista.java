package kirjamuistio.logiikka;

import java.util.ArrayList;

/**
 * Kirjalista on rajapinta, joka määrittelee joukon metodeja toteutettavaksi
 * Nämä metodit muodostavat kirjamuistion ydinosuuden
 * @author Karita Ojala
 */
public interface Kirjalista {

    public boolean tarkistaKirjanTiedot(Kirja kirja);

    public void lisaaKirja(Kirja kirja);

    public void poistaKirja(String nimi);

    public String nimiHaku(String nimi);

    public String kirjoittajaHaku(String kirjoittaja);

    public String julkaisuvuosiHaku(int julkvuosi);

    public boolean onkoKirja(Kirja kirja);

    public String siistiMerkkijono(String merkkijono);

    public ArrayList<Kirja> kirjalista();
}
