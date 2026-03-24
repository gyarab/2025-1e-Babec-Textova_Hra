package randombull.randombull.CelaHra;
import java.util.Scanner;
import java.util.Random;

public class HraMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hrac hrac = uvodJmeno();
    }

    private static Hrac uvodJmeno() {
        System.out.println();
        System.out.println();
        System.out.println("Hej bracho, vitej ve hre!");
        System.out.println();
        System.out.println("Abych ti nemusel rikat bracho, jak se jmenujes?");
        System.out.println();

        Hrac hrac = new Hrac();
        Scanner sc = new Scanner(System.in);
        hrac.jmeno = sc.nextLine();

        System.out.println();
        System.out.println("Tak jo " + hrac.jmeno +" pokusim se ti to vysvetlit");
        System.out.println("""
        Ve zkratce mas moznosti ze kterych si vyberes.
        Taky mas 10 hp (zivotu).
        Hodne stesti
        """);


        System.out.println();
        return hrac;
    }
}



