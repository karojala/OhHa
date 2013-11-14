package kirjamuistio.logiikka;

public interface Kayttaja {

    // Välttämättä ei edes tule useampaa käyttäjää järjestelmään sittenkään
    // Nyt aika pitkälle vain yksi käyttäjä
    public void setSalasana(String vanhaSalasana, String uusiSalasana);

    public boolean sallittuMerkkijono(String merkkijono);

    public String getSalasana();

    public String getTunnus();
}
