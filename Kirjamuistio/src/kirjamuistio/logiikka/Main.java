package kirjamuistio.logiikka;

public class Main {

    public static void main(String[] args) {

        // Tämä toteutetaan myöhemmin käyttöliittymässä
        Kirjalista omistetut = new Omistetut();
        omistetut.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976, "Populaaritiede", "978-0-19-929115-1"));
        omistetut.lisaaKirja(new Kirja("The Selfish Gene", "Richard Dawkins", 1976));
        omistetut.lisaaKirja(new Kirja("The God Delusion", "Richard Dawkins", 1980));
        omistetut.lisaaKirja(new Kirja("Statistical Methods For Psychology", "David C. Howell", 2012));
        
        Kirjalista halutut = new Halutut();
        halutut.lisaaKirja(new Kirja("Abarat", "Clive Barker", 2000, "Nuorten fantasia"));
        halutut.lisaaKirja(new Kirja("Pride and Prejudice", "Jane Austen", 1813, "Klassikot"));
        
        System.out.println(omistetut);
        System.out.println(halutut);
    }
}
