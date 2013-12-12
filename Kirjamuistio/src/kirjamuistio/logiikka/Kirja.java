package kirjamuistio.logiikka;

/**
 * Kirja-luokka kokoaa kasaan tarvittavat tiedot yhdestä kirja-oliosta
 * Sillä on getterit ja setterit, joiden avulla voidaan sekä hakea kirjan tietooja 
 * ja muokata tietoja
 * @author Karita Ojala
 */
public class Kirja {

    private String nimi;
    private String kirjoittaja;
    private String julkvuosi;
    private String genre;
    private String isbn;

    public Kirja(String nimi, String kirjoittaja, String julkvuosi) {
        this(nimi, kirjoittaja, julkvuosi, "", "");
    }

    public Kirja(String nimi, String kirjoittaja, String julkvuosi, String isbn) {
        this(nimi, kirjoittaja, julkvuosi, isbn, "");
    }

    public Kirja(String nimi, String kirjoittaja, String julkvuosi, String isbn, String genre) {
        this.nimi = nimi;
        this.kirjoittaja = kirjoittaja;
        this.julkvuosi = julkvuosi;
        this.genre = genre;
        this.isbn = isbn;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public void setJulkaisuvuosi(String julkvuosi) {
        this.julkvuosi = julkvuosi;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getGenre() {
        return this.genre;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String lyhytString() {
        return "'" + this.nimi + "'" + ", " + this.kirjoittaja;
    }
    
    @Override
    public String toString() {
        if (getJulkaisuvuosi().isEmpty()) {
            return "'" + this.nimi + "'" + ", " + this.kirjoittaja;
        } else if (getISBN().isEmpty()) {
            return "'" + this.nimi + "'" + ", " + this.kirjoittaja + ", " + this.julkvuosi;
        }
        return "'" + this.nimi + "'" + ", " + this.kirjoittaja + ", " + this.julkvuosi + ", " + this.isbn;
    }
}