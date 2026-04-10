package randombull.randombull.CelaHra;
import java.util.Scanner;
import java.util.Random;

public class HraMain {
    public static void main(String[] args) throws InterruptedException {

        Zombie zombie = new Zombie();
        zombie.jmeno = "zombie";
        zombie.hp = 5;
        zombie.damage = 5;




        Hrac hrac = uvodJmeno();

        uvodOtazky(hrac);

        fight(hrac, zombie);




    }

    private static void fight(Hrac hrac, Enemy enemy) {
        System.out.println();
        System.out.println("Jdes fightit s " + enemy.jmeno);
        System.out.println();
        if (hrac.vysoky = true){
            System.out.println("Jsi vysoky, takze davas damage - 2 hp");
            hrac.damage = 2;
        }else if (hrac.vysoky = false){
            System.out.println("Jsi nizky, takze damage - 1 hp");
            hrac.damage = 1;
        }

        for (int i = 1; i < 9999; i++) {
            System.out.println();
            System.out.println(enemy.jmeno + " ted ma " + enemy.hp + " hp");
            System.out.println();
            System.out.println("Chces zautocit mecem (-" + (hrac.damage + 1) + " hp) nebo rukou (-" + hrac.damage + " hp ) ?");
            System.out.println("""
                    A) Mec
                    B) Ruka
                    """);

            Scanner sc = new Scanner(System.in);
            for (int d = 1; d <= 9999; d++) {
                String AB = sc.nextLine();
                if (AB.equals("a") || AB.equals("A")) {
                    d = 9999;
                    hrac.damage = hrac.damage + 1;
                    enemy.hp = enemy.hp - hrac.damage;
                    hrac.damage = hrac.damage - 1;
                } else if (AB.equals("b") || AB.equals("B")) {
                    enemy.hp = enemy.hp - hrac.damage;
                    d = 9999;
                } else {
                    System.out.println("Napis A nebo B.");
                }
            }
            if (enemy.hp <= 0){
                System.out.println(enemy.jmeno + " je mrtvej, hezky ty!!");
                i = 9999;
            }
        }
    }

    private static void uvodOtazky(Hrac hrac) {
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
        String AB = sc.nextLine();
        AB = vail(AB, sc);
        if (AB.equals("a") && AB.equals("A")) {
                hrac.vysoky = true;
            }else if (AB.equals("b") && AB.equals("B")) {
                hrac.vysoky = false;
        }

        //        for (int i = 1; i < 9999; i++) {
//            String AB = sc.nextLine();
//            if (AB.equals("a") || AB.equals("A")) {
//                hrac.vysoky = true;
//                i = 9999;
//            }else if (AB.equals("b") || AB.equals("B")) {
//                hrac.vysoky = false;
//                i = 9999;
//            }else{
//                System.out.println("Napis A nebo B.");
//            }
//        }
    }

    private static String vail(String AB, Scanner sc) {
        while (!AB.equals("a") && !AB.equals("A") &&  !AB.equals("b") &&  !AB.equals("B")) {
            System.out.println("Napis A nebo B.");
            AB = sc.nextLine();
        }
        return AB;
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
        System.out.println();
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



