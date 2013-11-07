package kirjamuistio.logiikka;

public class Kayttaja {

    // Myöhemmin toteutetaan rajapinnan kautta
    private String tunnus;
    private String salasana;

    public Kayttaja(String tunnus, String salasana) {
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    public void setSalasana(String vanhaSalasana, String uusiSalasana) {
        if (vanhaSalasana.equals(this.salasana) && sallittuMerkkijono(uusiSalasana) == true) {
            this.salasana = uusiSalasana;
        } else {
            System.out.println("Syötetty vanha salasana on väärin tai salasana on alle 5 merkkiä tai yli 12 merkkiä.");
        }
    }

    public boolean sallittuMerkkijono(String merkkijono) {
        boolean ok = true;

        if (merkkijono.isEmpty() || merkkijono.length() < 5 || merkkijono.length() > 15) {
            ok = false;
        }

        return ok;
    }
    
    // Tämä toiminto myöhemmin mahdollista vain ylläpitäjälle (?) tai vastattava turvakysymykseen
    public String getSalasana() {
        return this.salasana;
    }

    public String getTunnus() {
        return this.tunnus;
    }
}
