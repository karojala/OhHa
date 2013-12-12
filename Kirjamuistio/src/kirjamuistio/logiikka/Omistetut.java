package kirjamuistio.logiikka;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Omistetut on Kirjalistan erikoistapaus, joka toimii varastona omistetuille
 * kirjoille
 *
 * @author Karita Ojala
 */
public class Omistetut implements Kirjalista {

    private TreeMap<String, Kirja> kirjat;

    public Omistetut() {
        this.kirjat = new TreeMap<>();
    }

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

    @Override
    public Kirja getKirja(String nimi) {
        String nimisiisti = siistiMerkkijono(nimi);
        
        Kirja kirja = null;
        if (this.kirjat.containsKey(nimisiisti)) {
            kirja = this.kirjat.get(nimisiisti);
        } else {
            System.out.println("Kirja ei ole listassa.");
        }
        return kirja;
    }
    
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

    @Override
    public void poistaKirja(String nimi) {
        String nimisiisti = siistiMerkkijono(nimi);

        if (this.kirjat.containsKey(nimisiisti)) {
            this.kirjat.remove(nimisiisti);
        } else {
            System.out.println("Kirjaa ei ole listassa, joten sitä ei voida poistaa.");
        }
    }

    @Override
    public String nimiHaku(String nimi) {
        String nimisiisti = siistiMerkkijono(nimi);
        String kirjatMerkkijonona = "";

        for (Kirja kirja : this.kirjat.values()) {
            if (siistiMerkkijono(kirja.getNimi()).contains(nimisiisti)) {
                kirjatMerkkijonona += kirja + "\n";
            }
        }

        if (nimi.isEmpty()) {
            return "Nimihakua ei voi tehdä tyhjällä kentällä";
        } else if (kirjatMerkkijonona.isEmpty()) {
            return "Hakemallasi nimellä ei löytynyt yhtäkään kirjaa";
        }
        return kirjatMerkkijonona;

    }

    @Override
    public String kirjoittajaHaku(String kirjoittaja) {
        String nimisiisti = siistiMerkkijono(kirjoittaja);
        String kirjatMerkkijonona = "";

        for (Kirja kirja : this.kirjat.values()) {
            if (siistiMerkkijono(kirja.getKirjoittaja()).contains(nimisiisti)) {
                kirjatMerkkijonona += kirja + "\n";
            }
        }

        if (kirjoittaja.isEmpty()) {
            return "Kirjoittajahakua ei voi tehdä tyhjällä kentällä";
        } else if (kirjatMerkkijonona.isEmpty()) {
            return "Hakemallasi kirjoittajalla ei löytynyt yhtäkään kirjaa";
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

        if (julkvuosi == 0) {
            return "Julkaisuvuosi ei voi olla 0";
        } else if (kirjatMerkkijonona.isEmpty()) {
            return "Hakemallasi julkaisuvuodella ei löytynyt yhtäkään kirjaa";
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
        return new ArrayList<>(this.kirjat.values());
    }

    @Override
    public String toString() {
        String kirjatMerkkijonona = "";

        for (Kirja kirja : kirjalista()) {
            kirjatMerkkijonona += kirja + "\n";
        }

        return kirjatMerkkijonona;
    }
}