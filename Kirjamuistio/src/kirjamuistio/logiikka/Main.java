package kirjamuistio.logiikka;

public class Main {

    public static void main(String[] args) {

        // Tämä toteutetaan myöhemmin eri luokassa
        Kirja kirja = new Kirja("The Selfish Gene", "Richard Dawkins", 1976, "Populaaritiede", "978-0-19-929115-1");
        Kirja kirja2 = new Kirja("The Selfish Gene", "Richard Dawkins", 1976);
        Kirja kirja3 = new Kirja("The God Delusion", "Richard Dawkins", 1980);
        Kirja kirja4 = new Kirja("Statistical Methods For Psychology", "David C. Howell", 2012);
        
        Kirjalista kirjalista = new Kirjalista();
        kirjalista.lisaaKirja(kirja);
        kirjalista.lisaaKirja(kirja2);
        kirjalista.lisaaKirja(kirja3);
        kirjalista.lisaaKirja(kirja4);
        System.out.println(kirjalista);
    }
}
