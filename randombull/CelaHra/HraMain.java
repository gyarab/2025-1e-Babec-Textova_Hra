package randombull.randombull.CelaHra;
import java.util.Scanner;
import java.util.Random;

public class HraMain {
    public static void main(String[] args) throws InterruptedException {

        Hrac hrac = uvodJmeno();

        uvodOtazky(hrac);

        System.out.println(hrac.vysoky);

    }

    private static void uvodOtazky(Hrac hrac) {
        System.out.println(hrac.jmeno);
        System.out.println("Jeste mam par otazek na tebe.");
        System.out.println();
        System.out.println("Chces byt vysoky nebo maly?");
        System.out.println();
        System.out.println();
        System.out.println("A--> Chci byt vysoky.");
        System.out.println();
        System.out.println("B--> Chci byt maly.");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 9999; i++) {
            String AB = sc.nextLine();
            if (AB.equals("a") || AB.equals("A")) {
                hrac.vysoky = true;
                i = 9999;
            }else if (AB.equals("b") || AB.equals("B")) {
                hrac.vysoky = false;
                i = 9999;
            }else{
                System.out.println("Napis A nebo B.");
            }
        }
    }


    private static Hrac uvodJmeno() throws InterruptedException {
        System.out.println();
        printSlow("Hej bracho, vitej ve hre!");
        System.out.println();
        printSlow("Abych ti nemusel rikat bracho, jak se jmenujes?");
        System.out.println();
        printSlow("|");
        printSlow("|");
        printSlow("V");
        Hrac hrac = new Hrac();
        Scanner sc = new Scanner(System.in);
        hrac.jmeno = sc.nextLine();
        System.out.println();
        System.out.println("Hmm, tak jo " + hrac.jmeno + " pokusim se ti vysvetlit jak to tady funguje.");
        System.out.println("Vzdy ti napisu jestli chces udelat to nebo to. Jo, mimochodem mas 10 hp (zivotu)");
        System.out.println();
        System.out.println("Tahle hra ma vice koncu, takze si to zkus dohrat vickrat. Tak pojdme zacit.");
        System.out.println();
        return hrac;
    }



    public static void printSlow(String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(150);
        }
        System.out.println();
    }

}



