package kirjamuistio.logiikka;

public class PerusKayttaja implements Kayttaja {

    // Myöhemmin toteutetaan rajapinnan kautta
    private String tunnus;
    private String salasana;

    public PerusKayttaja(String tunnus, String salasana) {
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    @Override
    public void setSalasana(String vanhaSalasana, String uusiSalasana) {
        if (vanhaSalasana.equals(this.salasana) && sallittuMerkkijono(uusiSalasana) == true) {
            this.salasana = uusiSalasana;
        } else {
            System.out.println("Syötetty vanha salasana on väärin tai salasana on alle 5 merkkiä tai yli 12 merkkiä.");
        }
    }

    @Override
    public boolean sallittuMerkkijono(String merkkijono) {
        boolean ok = true;

        if (merkkijono.isEmpty() || merkkijono.length() < 5 || merkkijono.length() > 15) {
            ok = false;
        }

        return ok;
    }

    @Override
    // Tämä toiminto myöhemmin mahdollista vain ylläpitäjälle (?) tai vastattava turvakysymykseen
    public String getSalasana() {
        return this.salasana;
    }

    @Override
    public String getTunnus() {
        return this.tunnus;
    }
}
