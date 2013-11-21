package kirjamuistio.logiikka;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Omistetut on Kirjalistan erikoistapaus, joka toimii varastona omistetuille kirjoille
 * 
 * @author Karita Ojala
 */
public class Omistetut implements Kirjalista {

    private HashMap<String, Kirja> kirjat;

    public Omistetut() {
        this.kirjat = new HashMap<String, Kirja>();
    }

    /**
     * Metodi tarkistaa, että kirjalle on syötetty nimi, kirjoittaja ja oikeassa muodossa oleva julkaisuvuosi
     * @param kirja Luotu kirja
     * @return Ovatko kirjan tiedot ok, true tai false
     */
    @Override
    public boolean tarkistaKirjanTiedot(Kirja kirja) {
        boolean ok = true;

        if (kirja.getNimi().isEmpty()) {
            System.out.println("Kirjan nimi puuttuu.");
            ok = false;
        }

        if (kirja.getKirjoittaja().isEmpty()) {
            System.out.println("Kirjan kirjoittaja puuttuu.");
            ok = false;
        }

        if (kirja.getJulkaisuvuosi() <= 0 || kirja.getJulkaisuvuosi() > 2100) {
            System.out.println("Kirjan julkaisuvuosi on virheellinen.");
            ok = false;
        }

        return ok;
    }

    
    /**
     * Kirjan lisäysmetodi, joka ensin tarkistaa kirjan tiedot toisen metodin avulla, jonka jälkeen kirjan nimi haetaan siistityn version avulla.
     * Kirjaa ei voi lisätä, jos se on jo listassa. Jos kirjaa ei ole listassa, kirja lisätään HashMapiin avaimenaan siistitty nimi ja arvona kirja-olio itse. 
     * @param kirja Lisättävä kirja
     */
    @Override
    public void lisaaKirja(Kirja kirja) {
        if (tarkistaKirjanTiedot(kirja) == false) {
            return;
        }

        String nimisiisti = siistiMerkkijono(kirja.getNimi());

        if (this.kirjat.containsKey(nimisiisti)) {
            System.out.println("Kirja on jo listassa.");
        } else {
            kirjat.put(nimisiisti, kirja);
        }
    }

    /**
     * Metodi, joka poistaa nimeä vastaavan kirjan. Kirja hakee siistityn nimen avulla avaimen, jonka poistaa arvoineen.
     * Jos kirja ei ole listassa, sitä ei voi poistaa. 
     * @param nimi Poistettavan kirjan nimi
     */
    @Override
    public void poistaKirja(String nimi) {
        String nimisiisti = siistiMerkkijono(nimi);

        if (this.kirjat.containsKey(nimisiisti)) {
            this.kirjat.remove(nimisiisti);
        } else {
            System.out.println("Kirjaa ei ole listassa, joten sitä ei voida poistaa.");
        }
    }

    /**
     * Kirjan haku nimen avulla. 
     * @param nimi Haettavan kirjan nimi
     * @return Nimen avulla löytynyt kirja
     */
    @Override
    // Myöhemmin toteutus, että voi hakea epätäydellisellä nimellä?
    public String nimiHaku(String nimi) {
        String nimisiisti = siistiMerkkijono(nimi);

        return this.kirjat.get(nimisiisti).toString();
    }

    @Override
    public String kirjoittajaHaku(String kirjoittaja) {
        String kirjatMerkkijonona = "";

        for (Kirja kirja : this.kirjat.values()) {
            if (kirja.getKirjoittaja().equalsIgnoreCase(kirjoittaja)) {
                kirjatMerkkijonona += kirja + "\n";
            }
        }

        return kirjatMerkkijonona;
    }

    @Override
    public String julkaisuvuosiHaku(int julkvuosi) {
        String kirjatMerkkijonona = "";

        for (Kirja kirja : this.kirjat.values()) {
            if (kirja.getJulkaisuvuosi() == julkvuosi) {
                kirjatMerkkijonona += kirja + "\n";
            }
        }

        return kirjatMerkkijonona;
    }

    @Override
    public boolean onkoKirja(Kirja kirja) {
        return this.kirjat.containsValue(kirja);
    }

    @Override
    public String siistiMerkkijono(String merkkijono) {
        if (merkkijono == null) {
            return "";
        }

        merkkijono = merkkijono.toLowerCase();
        return merkkijono.trim();
    }

    @Override
    public ArrayList<Kirja> kirjalista() {
        return new ArrayList<Kirja>(this.kirjat.values());
    }

    @Override
    public String toString() {
        String kirjatMerkkijonona = "";

        for (Kirja kirja : kirjalista()) {
            kirjatMerkkijonona += "  " + kirja + "\n";
        }

        return kirjatMerkkijonona;
    }
}
