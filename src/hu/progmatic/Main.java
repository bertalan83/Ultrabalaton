package hu.progmatic;

import jdk.dynalink.linker.LinkerServices;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            List<Contender> contenderList = new ArrayList<>();

            try (BufferedReader reader =
                         new BufferedReader
                                 (new FileReader("files/ub2017egyeni.txt"))) {
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {

                    Contender contender = new Contender(line);
                    contenderList.add(contender);

                }
            }

            // 3. feladat

            System.out.println("3. feladat: Egyeni indulok: " + contenderList.size() + " fo");


            // 4. feladat

            int counter = 0;

            for (Contender contender : contenderList) {
                if (contender.getCategory().equalsIgnoreCase("Noi")
                && contender.getPercentageDone() == 100) {
                    counter++;
                }
            }

            System.out.println("4. feladat: Celba erkezo noi sportolok: " + counter + " fo");


            // 5. feladat

            Scanner scanner = new Scanner(System.in);

            System.out.println("5. feladat: Kerem a sportolo nevet!");
            String name = scanner.nextLine();

            boolean wasThere = false;
            boolean doneTheThing = false;

            for (Contender contender : contenderList) {
                if (contender.getName().equalsIgnoreCase(name)) {
                    wasThere = true;
                    if (contender.getPercentageDone() == 100) {
                        doneTheThing = true;
                    }
                }
            }

            System.out.println("Indult egyeniben? " + (wasThere ? "Igen" : "Nem"));

            if (wasThere) {
                System.out.println("Teljesitette a tavot? " + (doneTheThing ? "Igen" : "Nem"));
            }

            // 7. feladat

            counter = 0;
            double time = 0;

            for (Contender contender : contenderList) {
                if (contender.getCategory().equalsIgnoreCase("Ferfi")
                && contender.getPercentageDone() == 100) {
                    counter++;
                    time += contender.IdoOraban();
                }
            }

            System.out.println("7.feladat: Atlagos ido: " + time/counter + " ora");


            // 8. feladat

            double bestTimeMale = Integer.MAX_VALUE;
            double bestTimeFemale = Integer.MAX_VALUE;

            String bestMaleName = null;
            String winnerTimeMale = null;
            int bestMaleNumber = 0;

            String bestFemaleName= null;
            String winnerTimeFemale = null;
            int bestFemaleNumber = 0;

            for (Contender contender : contenderList) {
                if (contender.getCategory().equalsIgnoreCase("Ferfi")
                        && contender.IdoOraban() < bestTimeMale
                        && contender.getPercentageDone() == 100) {
                    bestTimeMale = contender.IdoOraban();
                    bestMaleName = contender.getName();
                    winnerTimeMale = contender.getTime();
                    bestMaleNumber = contender.getNumber();
                }
                if (contender.getCategory().equalsIgnoreCase("Noi")
                        && contender.IdoOraban() < bestTimeFemale
                        && contender.getPercentageDone() == 100) {
                    bestTimeFemale = contender.IdoOraban();
                    bestFemaleName = contender.getName();
                    winnerTimeFemale = contender.getTime();
                    bestFemaleNumber = contender.getNumber();
                }
            }

            System.out.println("8. feladat: Verseny gyoztesei");
            System.out.println("Nok: " + bestFemaleName + " (" + bestFemaleNumber + ".)" + " - " + winnerTimeFemale);
            System.out.println("Ferfiak: " + bestMaleName + " (" + bestMaleNumber + ".)" + " - " + winnerTimeMale);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
