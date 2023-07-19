
public class Pojisteny {
    private final String jmeno;
    private final String prijmeni;
    private final int vek;
    private final String telefon;

    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }
    public String getJmeno() {
        return jmeno;
    }
    public String getPrijmeni() {
        return prijmeni;
    }

    @Override public String toString() {
        return "Jméno: " + jmeno +"     "+ " Příjmení: " + prijmeni +"     " + " Věk: " + vek + "     " + " Telefon: " + telefon;

    }}

