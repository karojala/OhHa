package kirjamuistio.logiikka;

public interface Kayttaja {

    public void setSalasana(String vanhaSalasana, String uusiSalasana);

    public boolean sallittuMerkkijono(String merkkijono);

    public String getSalasana();

    public String getTunnus();
}
