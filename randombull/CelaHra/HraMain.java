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

            scena1(hrac);



//            fight(hrac, skeleton);

            wannaPlay = wannaPlay(sc, wannaPlay);
        }
    }



    private static Hrac uvodJmeno() throws InterruptedException {
        Hrac hrac = new Hrac();
        hrac.hp = 10;
        hrac.damage = 2;

        System.out.println();
        System.out.println("Hej bracho, vitej ve hre!");
        System.out.println();
        System.out.println("Abych ti nemusel rikat bracho, jak se jmenujes?");
        System.out.println();
        printSlow("|");
        printSlow("|");
        printSlow("V");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        hrac.jmeno = sc.nextLine();
        System.out.println();
        System.out.println("Hmm, tak jo " + hrac.jmeno + " pokusim se ti vysvetlit jak to tady funguje.");
        System.out.println("Vzdy ti napisu jestli chces udelat to nebo to. Jo, mimochodem mas 10 hp (zivotu)");
        System.out.println("A 20 zlataku.");
        System.out.println();
        System.out.println("Tahle hra ma vice koncu, takze si to zkus dohrat vickrat. Tak pojdme zacit.");
        System.out.println();
        return hrac;
    }

    private static void uvodOtazky(Hrac hrac) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Jo, jeste neco. Chces byt spis chytry nebo silny nebo plny charisma?");
        System.out.println();
        System.out.println("A) Chytry    B) Silny   C) Charisma");
        System.out.println();
        String ABC = sc.nextLine();
        ABC = vailC(ABC, sc);

        if((ABC.equalsIgnoreCase("a")) == true) {
            hrac.zdatny = true;
            System.out.println("Mozek se ti zvetsil nahoru. Ted vyhrajes kamen,nuzky, papir s Einsteinem.");
        }else if ((ABC.equalsIgnoreCase("b")) == true) {
            hrac.bojovnik = true;
            hrac.damage = hrac.damage + 2;
            System.out.println("Zvetsili se ti bicepsy minimalne o dva centimetry a ted se te boji i pololetka z matiky.");
        }else if ((ABC.equalsIgnoreCase("c")) == true) {
            hrac.charisma = true;
            System.out.println("Mas vetsi oboci a ted dokazes premluvit Davida Gogginse at vezme tu lod.");
        }

    }

    private static void scena1(Hrac hrac){  // Chce si udelat mec?
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Jak se prochazis lesem vidis na zemi zniceny mec.");
        System.out.println("Napada te ho opravit, ale je tam risk.");
        System.out.println();

        int sanceMec;
        if(hrac.zdatny == true) {
            sanceMec = 2;
        }else {
            sanceMec = 5;
        }


        System.out.println("Mas sanci 1:" +  sanceMec + " , ze ho opravis.");
        System.out.println("Jestli ne, tak si uberes zivot.");
        System.out.println("Jestli jo, tak mas mec (tvuj damage +2).");
        System.out.println();
        System.out.println("A) Pokusit se o opravu      B) Kaslat na to");
        System.out.println();

        String AB = sc.nextLine();
        AB = vail(AB, sc);

        Random random = new Random();
        int rand = random.nextInt(sanceMec) + 1;

        if(AB.equalsIgnoreCase("a") == true) {
            if (rand == 1) {
                hrac.mec = true;
                System.out.println("Mas mec kamo.");
            }else{
                hrac.klacek = true;
                hrac.hp = hrac.hp - 1;
                System.out.println("Bohuzel amigo, porezal ses, ale mas klacek :D");
            }
        }else if (AB.equalsIgnoreCase("b") == true) {
            hrac.klacek = true;
            System.out.println("Vykaslal ses na mec a vzal misto toho klacek.");
        }


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

//    private static void fight(Hrac hrac, Enemy enemy) {
//        System.out.println();
//        System.out.println("Jdes fightit s " + enemy.jmeno);
//        System.out.println();
//
//        while (enemy.hp > 0 && hrac.hp > 0) {
//            System.out.println();
//            System.out.println("Ted mas " + hrac.hp);
//            System.out.println();
//            System.out.println(enemy.jmeno + " ted ma " + enemy.hp + " hp");
//            System.out.println();
//            System.out.println("Chces zautocit mecem (-" + (hrac.damage + 1) + " hp) nebo rukou (-" + hrac.damage + " hp ) ?");
//            System.out.println("""
//                    A) Mec
//                    B) Ruka
//                    """);
//
//            Scanner sc = new Scanner(System.in);
//            String AB = sc.nextLine();
//            AB = vail(AB, sc);
//
//            if (AB.equals("a") || AB.equals("A")) {
//                hrac.damage = hrac.damage + 1;
//                enemy.hp = enemy.hp - hrac.damage;
//                hrac.damage = hrac.damage - 1;
//            } else {
//                enemy.hp = enemy.hp - hrac.damage;
//            }
//
//            Random random = new Random();
//
//            int randDam = random.nextInt(enemy.damage) + 1;
//
//
//            if (enemy.hp > 0){
//                hrac.hp = hrac.hp - randDam;
//                System.out.println();
//                if (hrac.hp <= 0){
//                    System.out.println(enemy.jmeno + " ti ubral " + randDam + " a tim te zabil");
//                }else{
//                    System.out.println(enemy.jmeno + " ted na tebe jde zautocit a ubere ti " + randDam);
//                }
//            }
//        }
//        if (hrac.hp <= 0){
//            System.out.println();
//            System.out.println("Damn si lowkey dead.");
//        }else if (enemy.hp <= 0){
//            System.out.println();
//            System.out.println("Nice, zabil si " + enemy.jmeno);
//        }else{
//            System.out.println();
//            System.out.println("Wow, vy jste se oba dva zabili.");
//        }
//
//    }
    private static String vail(String AB, Scanner sc) {
        while (!AB.equals("a") && !AB.equals("A") &&  !AB.equals("b") &&  !AB.equals("B")) {
            System.out.println("Napis A nebo B.");
            AB = sc.nextLine();
        }
        return AB;
    }
    private static String vailC(String ABC, Scanner sc) {
        while (!ABC.equals("a") && !ABC.equals("A") &&  !ABC.equals("b") &&  !ABC.equals("B") &&  !ABC.equals("c") &&  !ABC.equals("C")) {
            System.out.println("Napis A nebo B nebo C.");
            ABC = sc.nextLine();
        }
        return ABC;
    }
    public static void printSlow(String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(150);
        }
        System.out.println();
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
        }else{
            wannaPlay = "b";
        }
        return wannaPlay;
    }



}



