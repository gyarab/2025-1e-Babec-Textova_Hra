package randombull.randombull.CelaHra;
import java.util.Scanner;
import java.util.Random;

public class HraMain {
    public static void main(String[] args) throws InterruptedException {

        String wannaPlay = "a";

        while(wannaPlay.equals("a")) {
            Scanner sc = new Scanner(System.in);

            Zombie zombie = zombie();

            Skeleton skeleton = skeleton();


            Hrac hrac = uvodJmeno();


            uvodOtazky(hrac);


            fight(hrac, skeleton);
            wannaPlay = wannaPlay(sc, wannaPlay);
        }
    }

    private static String wannaPlay(Scanner sc, String wannaPlay) {
        System.out.println("Chces jeste jednou?");
        System.out.println("""
                A) Jo
                B) Hell Nah
                """);
        String AB = sc.nextLine();
        AB = vail(AB, sc);

        if(AB.equals("A") || AB.equals("a")) {
            wannaPlay = "a";
        }
        return wannaPlay;
    }

    private static Skeleton skeleton() {
        Skeleton skeleton = new Skeleton();
        skeleton.jmeno = "skeleton";
        skeleton.hp = 5;
        skeleton.damage = 5;
        return skeleton;
    }

    private static Zombie zombie() {
        Zombie zombie = new Zombie();
        zombie.jmeno = "zombie";
        zombie.hp = 5;
        zombie.damage = 5;
        return zombie;
    }

    private static void fight(Hrac hrac, Enemy enemy) {
        System.out.println();
        System.out.println("Jdes fightit s " + enemy.jmeno);
        System.out.println();
        if (hrac.vysoky == true){
            System.out.println("Jsi vysoky, takze davas damage - 2 hp");
            hrac.damage = 2;
        }else if (hrac.vysoky == false){
            System.out.println("Jsi nizky, takze damage - 1 hp");
            hrac.damage = 1;
        }
        while (enemy.hp > 0 && hrac.hp > 0) {
            System.out.println();
            System.out.println("Ted mas " + hrac.hp);
            System.out.println();
            System.out.println(enemy.jmeno + " ted ma " + enemy.hp + " hp");
            System.out.println();
            System.out.println("Chces zautocit mecem (-" + (hrac.damage + 1) + " hp) nebo rukou (-" + hrac.damage + " hp ) ?");
            System.out.println("""
                    A) Mec
                    B) Ruka
                    """);

            Scanner sc = new Scanner(System.in);
            String AB = sc.nextLine();
            AB = vail(AB, sc);

            if (AB.equals("a") || AB.equals("A")) {
                hrac.damage = hrac.damage + 1;
                enemy.hp = enemy.hp - hrac.damage;
                hrac.damage = hrac.damage - 1;
            } else {
                enemy.hp = enemy.hp - hrac.damage;
            }

            Random random = new Random();

            int randDam = random.nextInt(enemy.damage) + 1;

            System.out.println();
            System.out.println(enemy.jmeno + " ted na tebe jde zautocit a ubere ti " + randDam);
            hrac.hp = hrac.hp - randDam;
        }
        if (hrac.hp <= 0){
            System.out.println("Damn si lowkey dead.");
        }else if (enemy.hp <= 0){
            System.out.println("Nice, zabil si " + enemy.jmeno);
        }else{
            System.out.println("Wow, vy jste se oba dva zabili.");
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
        if (AB.equals("a") || AB.equals("A")) {
                hrac.vysoky = true;
            }else if (AB.equals("b") || AB.equals("B")) {
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
        System.out.println("Hej bracho, vitej ve hre!");
        System.out.println();
        System.out.println("Abych ti nemusel rikat bracho, jak se jmenujes?");
        System.out.println();
        printSlow("|");
        printSlow("|");
        printSlow("V");
        System.out.println();
        Hrac hrac = new Hrac();
        hrac.hp = 10;
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



