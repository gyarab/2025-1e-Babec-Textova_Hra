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

            scena2(hrac);

            if (hrac.barkral == 1){
                scena21(hrac); //Bar
            }else if (hrac.barkral == 2){
                scena22(hrac); //Kralovstvi
            }
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

    private static void scena1(Hrac hrac) {  // Chce si udelat mec?
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Jak se prochazis lesem vidis na zemi zniceny mec.");
        System.out.println("Napada te ho opravit, ale je tam risk.");
        System.out.println();

        int sanceMec;
        if (hrac.zdatny == true) {
            sanceMec = 2;
        } else {
            sanceMec = 5;
        }


        System.out.println("Mas sanci 1:" + sanceMec + " , ze ho opravis.");
        System.out.println("Jestli ne, tak si uberes zivot.");
        System.out.println("Jestli jo, tak mas mec (tvuj damage +2).");
        System.out.println();
        System.out.println("A) Pokusit se o opravu      B) Kaslat na to");
        System.out.println();

        String AB = sc.nextLine();
        AB = vail(AB, sc);

        Random random = new Random();
        int rand = random.nextInt(sanceMec) + 1;

        if (AB.equalsIgnoreCase("a") == true) { //chce si udelat mec
            if (rand == 1) {   //povedlo
                hrac.mec = true;
                System.out.println("Mas mec kamo.");
            } else {
                hrac.klacek = true;//nepovedlo
                hrac.hp = hrac.hp - 1;
                System.out.println("Bohuzel amigo, porezal ses, ale mas klacek :D");
            }
        } else if (AB.equalsIgnoreCase("b") == true) { //nechce si udelat mec
            hrac.klacek = true;
            System.out.println("Vykaslal ses na mec a vzal misto toho klacek.");
        }

        //nakup mece
        if (hrac.mec == true) {
            System.out.println();
            System.out.println("Prijde k tobe muz, ktery se jmenuje Andrej: Hele muzu ten mec za 15 zlataku?");
            System.out.println();
            System.out.println("Muzes ho prodat (a teoreticky zkusit zvetsit cenu) nebo si ho nechat");
            System.out.println("A) Prodat(mozna obchdovat)      B)Nechat si ho");
            System.out.println();

            if (AB.equalsIgnoreCase("a") == true) { // Chce prodat

                int sanceCena;
                if (hrac.charisma == true) {
                    sanceCena = 2;
                } else {
                    sanceCena = 5;
                }

                System.out.println("Mas sanci 1:" + sanceCena + " , ze zvednes cenu na 25 zlataku.");
                System.out.println("Jestli se ti to nepovede, tak on ji snizi na 5.");
                System.out.println("Jestli jo, tak nemas mec, ale mas + 25 zlataku.");
                System.out.println();
                System.out.println("A) Pokusit se o smlouvani     B) Vzit to za 15");
                System.out.println();

                AB = sc.nextLine();
                AB = vail(AB, sc);
                rand = random.nextInt(sanceCena) + 1;

                if (AB.equalsIgnoreCase("a") == true) { //Chce smlouvat

                    if (rand == 1) {   //povedlo
                        hrac.mec = false;
                        hrac.klacek = true;
                        hrac.penize = hrac.penize + 25;
                        System.out.println();
                        System.out.println("Andrej: No... Tak jo, tady mas 25 zlataku a tady mas klacek.");

                    } else { //nepovedlo
                        System.out.println();
                        System.out.println("Andrej: hele nebud drzej, tak ted menim cenu na 5 zlataku. Beres?");
                        System.out.println();
                        System.out.println("A) Beru     B) Ne, diky");
                        System.out.println();

                        AB = sc.nextLine();
                        AB = vail(AB, sc);

                        if (AB.equalsIgnoreCase("a") == true) { //Bere
                            hrac.mec = false;
                            hrac.klacek = true;
                            hrac.penize = hrac.penize + 5;

                            System.out.println();
                            System.out.println("Andrej: tak tady mas 5 zlataku a klacek, abys neumrel.");
                            System.out.println();

                        } else if (AB.equalsIgnoreCase("b") == true) { //Nechce za 5

                            System.out.println();
                            System.out.println("Andrej: tak potom jdi do dreveneho zachodu!!!");
                            System.out.println();

                    }


                    }



                } else if (AB.equalsIgnoreCase("b") == true) { //Nechce smlouvat

                    hrac.mec = false;
                    hrac.klacek = true;
                    hrac.penize = hrac.penize + 15;

                    System.out.println();
                    System.out.println("Andrej: vazne?? JOOO tady mas 15 zlataku a klidne si vezmi muj klacek, abys prezil.");
                    System.out.println();

                }





        } else if (AB.equalsIgnoreCase("b") == true) { // Nechce prodat
            System.out.println("Andrej: Tak nic no :(");
        }






        }





    }

    private static void scena2(Hrac hrac){//Bar nebo Kralovstvi
        System.out.println();
        System.out.println("Jdes takhle lesem a vidis dve znacky, jedna ukazuje smer bar a druha do kralovstvi.");
        System.out.println("Kam pujdes?");
        System.out.println();
        System.out.println("A) Bar            B) Kralovstvi");

        Scanner sc = new Scanner(System.in);
        String AB = sc.nextLine();
        AB = vail(AB, sc);

        if (AB.equalsIgnoreCase("a") == true) {
            hrac.barkral = 1;
        } else if (AB.equalsIgnoreCase("b") == true) {
            hrac.barkral = 2;
        }
    }

    private static void scena21(Hrac hrac){//Bar
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Barman: Dobry den, vitejte v baru u Lukase Pod Dubem.");
        System.out.println("Chcete si neco dat?");
        System.out.println("A) Ano            B) Ne");
        System.out.println();

        String AB = sc.nextLine();
        AB = vail(AB, sc);

        if (AB.equalsIgnoreCase("a") == true) {//Jde si dat





        } else if (AB.equalsIgnoreCase("b") == true) {//Kasle na to


        }




    }

    private static void scena22(Hrac hrac){//Kralovstvi

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
    private static String vailD(String ABCD, Scanner sc){
        while (!ABCD.equals("a") && !ABCD.equals("A") &&  !ABCD.equals("b") &&  !ABCD.equals("B") &&  !ABCD.equals("c") &&  !ABCD.equals("C")) {
            System.out.println("Napis A nebo B nebo C nebo D.");
            ABCD = sc.nextLine();
        }
        return ABCD;
    }
    private static void barvail(String AB, Scanner sc){
        System.out.println();
        System.out.println("Date si piti nebo jidlo?");
        System.out.println("A) Piti            B) Jidlo");
        System.out.println();

        if (AB.equalsIgnoreCase("a") == true) {//Jde si dat Piti



        } else if (AB.equalsIgnoreCase("b") == true) {//Jde si dat Jidlo



        }
    }


    private static void maPrachy(Hrac hrac, PitiJidlo pitiJidlo){
        if(hrac.penize >= pitiJidlo.cena){
            hrac.penize = hrac.penize - pitiJidlo.cena;
            hrac.procentoOpilost = hrac.procentoOpilost + pitiJidlo.procentoOpilosti;
            hrac.procentoPlnosti = hrac.procentoPlnosti + pitiJidlo.procentoPlnosti;

        }else{

        }

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



