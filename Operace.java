import java.util.Scanner;

abstract class Operace {
    protected Databaze databaze;
    protected Scanner scanner;

    public Operace(Databaze databaze, Scanner scanner) {
        this.databaze = databaze;
        this.scanner = scanner;
    }

    public abstract void vykonej();
}

class VytvorPojistence extends Operace {
    public VytvorPojistence(Databaze databaze, Scanner scanner) {
        super(databaze, scanner);
    }

    public void vykonej() {
        try {
            String jmeno = "";
            String prijmeni = "";
            int vek = -1;
            String telefon = "";

            do {
                System.out.println("Vytváření nového pojištěného");
                System.out.println("Jméno:");
                jmeno = scanner.nextLine().trim();
                if (jmeno.isEmpty()) {
                    System.out.println("Jméno nesmí být prázdné.");
                    continue;
                }
                System.out.println("\nPříjmení:");
                prijmeni = scanner.nextLine().trim();
                if (prijmeni.isEmpty()) {
                    System.out.println("Příjmení nesmí být prázdné.");
                    continue;
                }
                System.out.println("\nVěk:");
                vek = scanner.nextInt();
                if (vek < 0 || vek > 100) {
                    System.out.println("Věk musí být v rozmezí 0-100 let.");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();
                System.out.println("\nTelefonní číslo:");
                telefon = scanner.nextLine();
                if (!telefon.matches("\\d{9}")) {
                    System.out.println("Telefonní číslo musí mít 9 číslic.");
                    continue;
                }
            } while (jmeno.isEmpty() || prijmeni.isEmpty() || vek < 0 || vek > 100 || !telefon.matches("\\d{9}"));

            Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
            databaze.pridejPojisteneho(pojisteny);
            System.out.println("\nPojisteny byl vytvořen.");
            System.out.println("\n");
            System.out.println(pojisteny);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("\n");
        } catch (Exception e){
            System.out.println("Došlo k chybě: " + e.getMessage());
        }

    }}

class ZobrazSeznam extends Operace {
    public ZobrazSeznam(Databaze databaze, Scanner scanner) {
        super(databaze, scanner);
        System.out.println("\n");
        System.out.println("\n");
    }

    public void vykonej() {
        System.out.println("Seznam pojištěných:");
        databaze.seznamPojistenych();
        System.out.println("------------------------------------------------------------------");
    }
}

class VyhledejPojistence extends Operace {
    public VyhledejPojistence(Databaze databaze, Scanner scanner) {
        super(databaze, scanner);
    }

    public void vykonej() {
        System.out.println("Vyhledávání pojištěného");
        System.out.println("Jméno:");
        String hledaneJmeno = scanner.nextLine();
        System.out.println("Příjmení:");
        String hledanePrijmeni = scanner.nextLine();
        databaze.vyhledejPojisteneho(hledaneJmeno, hledanePrijmeni);
        System.out.println("------------------------------------------------------------------");
    }}
    class VymazPojistence extends Operace {
        public VymazPojistence(Databaze databaze, Scanner scanner) {
            super(databaze, scanner);
        }

        public void vykonej() {
            System.out.println("Vymazání pojištěného");
            System.out.println("Jméno:");
            String hledaneJmeno = scanner.nextLine();
            System.out.println("Příjmení:");
            String hledanePrijmeni = scanner.nextLine();
            databaze.vymazPojisteneho(hledaneJmeno, hledanePrijmeni);
        }
    }

