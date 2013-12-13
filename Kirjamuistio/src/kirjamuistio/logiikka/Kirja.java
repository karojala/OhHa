package kirjamuistio.logiikka;

/**
 * Kirja-luokka kokoaa kasaan tarvittavat tiedot yhdestä Kirja-oliosta Sillä on
 * getterit ja setterit, joiden avulla voidaan sekä hakea kirjan tietoja että
 * muokata tietoja.
 *
 * @author Karita Ojala
 */
public class Kirja {

    /**
     * Kirjan nimi, kirjoittaja, julkaisuvuosi ja ISBN-koodi.
     */
    private String nimi;
    private String kirjoittaja;
    private String julkvuosi;
    private String isbn;

    public Kirja(String nimi, String kirjoittaja) {
        this(nimi, kirjoittaja, "", "");
    }

    public Kirja(String nimi, String kirjoittaja, String julkvuosi) {
        this(nimi, kirjoittaja, julkvuosi, "");
    }

    public Kirja(String nimi, String kirjoittaja, String julkvuosi, String isbn) {
        this.nimi = nimi;
        this.kirjoittaja = kirjoittaja;
        this.julkvuosi = julkvuosi;
        this.isbn = isbn;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public void setJulkaisuvuosi(String julkvuosi) {
        if (0 < Integer.parseInt(julkvuosi) && Integer.parseInt(julkvuosi) < 2015) {
            this.julkvuosi = julkvuosi;
        } else {
            System.out.println("Julkaisuvuosi ei voi olla 0 eikä yli 2015");
        }
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getKirjoittaja() {
        return this.kirjoittaja;
    }

    public String getJulkaisuvuosi() {
        return this.julkvuosi;
    }

    public String getISBN() {
        return this.isbn;
    }
    
    @Override
    public String toString() {
        if (getJulkaisuvuosi() == null || getJulkaisuvuosi().contentEquals("")) {
            return "'" + this.nimi + "'" + "#" + this.kirjoittaja;
        } else if (getISBN() == null || getISBN().contentEquals("")) {
            return "'" + this.nimi + "'" + "#" + this.kirjoittaja + "#" + this.julkvuosi;
        }
        return "'" + this.nimi + "'" + "#" + this.kirjoittaja + "#" + this.julkvuosi + "#" + this.isbn;
    }
    
    /**
     * Lyhyempi toStringin versio, jota käytetään käyttöliittymän JListissä. 
     * @return Kirja toString
     */
    public String lyhytString() {
        return "'" + this.nimi + "'" + ", " + this.kirjoittaja;
    }

    /**
     * Ns perus/alkuperäinen versio toStringistä. Jätetty varalta. 
     * @return Kirja toString
     */
    public String toString2() {
        if (getJulkaisuvuosi() == null || getJulkaisuvuosi().contentEquals("")) {
            return "'" + this.nimi + "'" + ", " + this.kirjoittaja;
        } else if (getISBN() == null || getISBN().contentEquals("")) {
            return "'" + this.nimi + "'" + ", " + this.kirjoittaja + ", " + this.julkvuosi;
        }
        return "'" + this.nimi + "'" + ", " + this.kirjoittaja + ", " + this.julkvuosi + ", " + this.isbn;
    }
}