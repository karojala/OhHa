package kirjamuistio.logiikka;

public class Kirja {

    // Kirja toteutetaan myöhemmin ehkä rajapinnan kautta
    private String nimi;
    private String kirjoittaja;
    private int julkvuosi;
    private String genre;
    private String isbn;

    public Kirja(String nimi, String kirjoittaja, int julkvuosi) {
        this(nimi, kirjoittaja, julkvuosi, "", "");
    }

    public Kirja(String nimi, String kirjoittaja, int julkvuosi, String genre) {
        this(nimi, kirjoittaja, julkvuosi, genre, "");
    }

    public Kirja(String nimi, String kirjoittaja, int julkvuosi, String genre, String isbn) {
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

    public void setJulkaisuvuosi(int julkvuosi) {
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

    public int getJulkaisuvuosi() {
        return this.julkvuosi;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getISBN() {
        return this.isbn;
    }

    @Override
    public String toString() {
        return "'" + this.nimi + "'" + ", " + this.kirjoittaja + ", " + this.julkvuosi;
        // + ", " + this.genre + ", " + "ISBN " + this.isbn
    }
}