
    import java.util.ArrayList;
    import java.util.Iterator;

    public class Databaze {
        private ArrayList<Pojisteny> seznamPojistenych = new ArrayList<>();

        public void pridejPojisteneho(Pojisteny pojisteny) {
            seznamPojistenych.add(pojisteny);
        }

        public void seznamPojistenych() {
            for (Pojisteny pojistenec : seznamPojistenych){
                System.out.println(pojistenec);
            }
        }

        public void vyhledejPojisteneho(String hledaneJmeno, String hledanePrijmeni) {
            for (Pojisteny pojisteny : seznamPojistenych){
                if (pojisteny.getJmeno().equals(hledaneJmeno) && pojisteny.getPrijmeni().equals(hledanePrijmeni)) {
                    System.out.println("Nalezeno:");
                    System.out.println(pojisteny);
                }
            }
        }
        public void vymazPojisteneho(String hledaneJmeno, String hledanePrijmeni) {
            Iterator<Pojisteny> iterator = seznamPojistenych.iterator();
            while (iterator.hasNext()) {
                Pojisteny pojisteny = iterator.next();
                if (pojisteny.getJmeno().equals(hledaneJmeno) && pojisteny.getPrijmeni().equals(hledanePrijmeni)) {
                    iterator.remove();
                    System.out.println("Pojisteny byl vymazán.");
                    return;
                }
            }
            System.out.println("Pojisteny nebyl nalezen.");
        }
    }

