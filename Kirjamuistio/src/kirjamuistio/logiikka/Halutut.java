package kirjamuistio.logiikka;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Halutut on Kirjalistan erikoistapaus, joka toimii varastona halutuille
 * kirjoille Se poikkeaa (tulevaisuudessa) pieniltä osin Omistetut-luokasta
 *
 * @author Karita Ojala
 */
public class Halutut implements Kirjalista {

    private HashMap<String, Kirja> kirjat;

    public Halutut() {
        this.kirjat = new HashMap<String, Kirja>();
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

        //Julkaisuvuosi ei pakollinen halutuille kirjoille
        if (kirja.getJulkaisuvuosi() < 0 || kirja.getJulkaisuvuosi() > 2100) {
            System.out.println("Kirjan julkaisuvuosi on virheellinen.");
            ok = false;
        }

        return ok;
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
    // Myöhemmin toteutus, että voi hakea epätäydellisellä nimellä?
    public String nimiHaku(String nimi) {
        String nimisiisti = siistiMerkkijono(nimi);

        if (!nimi.isEmpty()) {
            return this.kirjat.get(nimisiisti).toString();
        }
        return null;

    }

    @Override
    public String kirjoittajaHaku(String kirjoittaja) {
        String kirjatMerkkijonona = "";

        for (Kirja kirja : this.kirjat.values()) {
            if (kirja.getKirjoittaja().equalsIgnoreCase(kirjoittaja)) {
                kirjatMerkkijonona += kirja + "\n";
            }
        }
        if (!kirjoittaja.isEmpty() && !kirjatMerkkijonona.isEmpty()) {
            return kirjatMerkkijonona;
        }

        return null;
    }

    @Override
    public String julkaisuvuosiHaku(int julkvuosi) {
        String kirjatMerkkijonona = "";

        for (Kirja kirja : this.kirjat.values()) {
            if (kirja.getJulkaisuvuosi() == julkvuosi) {
                kirjatMerkkijonona += kirja + "\n";
            }
        }

        if (julkvuosi != 0 && !kirjatMerkkijonona.isEmpty()) {
            return kirjatMerkkijonona;
        }
        return null;
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

        return "Käyttäjän haluamat kirjat: \n" + kirjatMerkkijonona;
    }
}