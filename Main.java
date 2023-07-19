

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Databaze databaze = new Databaze();

        List<Operace> operace = new ArrayList<>();
        operace.add(new VytvorPojistence(databaze, scanner));
        operace.add(new ZobrazSeznam(databaze, scanner));
        operace.add(new VyhledejPojistence(databaze, scanner));
        operace.add(new VymazPojistence(databaze,scanner));

        boolean pokracovat = true;
        while (pokracovat) {
            System.out.println("Vyberte akci:");
            for (int i = 0; i < operace.size(); i++) {
                System.out.println((i + 1) + ". " + operace.get(i).getClass().getSimpleName());
            }
            System.out.println((operace.size() + 1) + ". Konec programu");

            int volba = scanner.nextInt() - 1;
            scanner.nextLine();

            if (volba < operace.size()) {
                operace.get(volba).vykonej();

                System.out.println("\nChcete pokračovat? (ano/ne)");
                String odpoved = scanner.nextLine().trim().toLowerCase();

                if (!odpoved.equals("ano")) {
                    pokracovat = false;
                }
            } else {
                pokracovat=false;
                System.out.println("Konec programu ");
                System.out.println("\n ----------------------------------------------------------------");
            }
        }
    }
}

