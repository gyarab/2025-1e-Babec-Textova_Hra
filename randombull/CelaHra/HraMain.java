package randombull.randombull.CelaHra;

import java.util.Scanner;
import java.util.Random;

public class HraMain {
    public static void main(String[] args) throws InterruptedException {
        String wannaPlay = "a";
        int fight = 0;
        boolean poprve = true;

        while(wannaPlay.equals("a")) {
            clearScreen();
            System.out.println("=============NOVA HRA=============");

            Scanner sc = new Scanner(System.in);

            Hrac hrac = uvodJmeno(poprve);

            uvodOtazky(hrac, sc);

            scena1(hrac, sc);

            scena2(hrac, sc);

            if (hrac.barkral == 1){
                fight = scena21(hrac, fight); //Bar
                if (fight == 1) {
                    fight11(hrac, sc);//smecka vlku
                }else if (fight == 2) {
                    fight12(hrac, sc);
                }
            }else if (hrac.barkral == 2){
                scena22(hrac); //Kralovstvi
            }






            wannaPlay = wannaPlay(sc, wannaPlay);
            poprve = false;
        }
    }


    private static Hrac uvodJmeno(boolean poprve) throws InterruptedException {
        Hrac hrac = new Hrac();

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
        if (poprve == true){
            System.out.println("Hmm, tak jo " + hrac.jmeno + " pokusim se ti vysvetlit jak to tady funguje.");
            System.out.println("Vzdy ti napisu jestli chces udelat to nebo to. Jo, mimochodem mas " + hrac.hp +" hp (zivotu)");
            System.out.println("A "+ hrac.penize + " zlataku.");
            System.out.println();
            System.out.println("Tahle hra ma vice koncu, takze si to zkus dohrat vickrat. Tak pojdme zacit.");
            System.out.println();
        }else {
            System.out.println("Mas "+ hrac.penize + " zlataku a "+ hrac.hp + " hp.");
        }
        return hrac;
    }

    private static void uvodOtazky(Hrac hrac, Scanner sc) {

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

    private static void scena1(Hrac hrac, Scanner sc) {  // Chce si udelat mec?
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

            AB = sc.nextLine();
            AB = vail(AB, sc);

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
    private static void scena2(Hrac hrac, Scanner sc){//Bar nebo Kralovstvi
        System.out.println();
        System.out.println("Jdes takhle lesem a vidis dve znacky, jedna ukazuje smer bar a druha do kralovstvi.");
        System.out.println("Kam pujdes?");
        System.out.println();
        System.out.println("A) Bar            B) Kralovstvi");

        String AB = sc.nextLine();
        AB = vail(AB, sc);

        if (AB.equalsIgnoreCase("a") == true) {
            hrac.barkral = 1;
        } else if (AB.equalsIgnoreCase("b") == true) {
            hrac.barkral = 2;
        }
    }
    private static int scena21(Hrac hrac, int fight){//Bar
        Scanner sc = new Scanner(System.in);

        System.out.println();
        if (hrac.charisma == true){
            System.out.println();
            System.out.println("Prijdes do baru a protoze se nebojis lidi tak si sednes do prostred baru.");
            System.out.println("Prijde k tobe barman.");
        }else{
            System.out.println();
            System.out.println("Prijdes do baru a sednes si do rohu.");
            System.out.println("Prijde k tobe barman.");
        }

        System.out.println("Barman: Dobry den, vitejte v baru u Lukase Pod Dubem.");
        System.out.println("Chcete si neco dat?");
        System.out.println("A) Ano            B) Ne");
        System.out.println();

        String AB = sc.nextLine();
        AB = vail(AB, sc);

        if (AB.equalsIgnoreCase("a") == true) {//Jde si dat
            barvail(AB,sc, hrac);
            if (hrac.procentoOpilost > 25 && hrac.procentoPlnosti > 30) {
                System.out.println("Opil ses a byl si plny jidla takze si usnul. V pulnoci byla rvacka a spadla na tebe zidle, ktera te zabila.");
            }
        } else if (AB.equalsIgnoreCase("b") == true) {//Kasle na to
            System.out.println("Barman: aha... tak jo. :( ");
        }

        System.out.println();
        System.out.println("Do baru vbehne muz a bezi rovnou k tobe");
        System.out.println("Muz: hele potrebujeme tvoji pomoc. Venku je smecka vlku, pomuzes?");


        if (hrac.procentoOpilost > 20) {
            System.out.println("A)'oopvHOIvhopvH'            B) 'hoefsUOHFAgyi'");
            System.out.println("(ses opilej a kvuli tomu nemuzes mluvit a ztracis jeden damage v boji)");
            System.out.println();

            hrac.damage = hrac.damage - 1;

            AB = sc.nextLine();
            AB = vail(AB, sc);
            System.out.println("Muz: aha, no tak to beru jako jo. :D");
            fight = 1; // fight smecka vlku


        } else if (hrac.procentoPlnosti > 25) {
            System.out.println("A)'Ok, jdu tam'            B) 'Asi ne, diky'");
            System.out.println();
            AB = sc.nextLine();
            AB = vail(AB, sc);

            if (AB.equalsIgnoreCase("a") == true) {//jde (akorat ze ne)
                System.out.println("Jak se snazis postavit, tak ti dojde, ze nemuzes, protoze ses prejedl.");
                System.out.println("Muz: hej kamo, kasli na to, pujdeme sami.");
                fight = 2;//fight v baru

            }else if (AB.equalsIgnoreCase("b") == true) { //nejde

                System.out.println();
                System.out.println("Muz: aha, tak jo no, lenochu. >:(");
                System.out.println();
                fight = 2;//fight v baru
            }

        }else {
            System.out.println("A)'Ok, jdu tam'            B) 'Asi ne, diky'");
            System.out.println();
            AB = sc.nextLine();
            AB = vail(AB, sc);

            switch (AB){
                case "a", "A" :
                    System.out.println("Muz: ok, tak pojd je jich par.");
                    fight = 1;
                    break;
                case "b", "B" :
                    System.out.println("Muz: aha, tak jo no, tak zatim.");
                    fight = 2;
                    break;
            }
        }



        return fight;
    } //bar
    private static void scena22(Hrac hrac){//Kralovstvi

    } // kralovstvi

    private static void fight11(Hrac hrac, Scanner sc){//fight smecka vlku
        System.out.println();
        System.out.println("Vysel si ven a vidis dva mensi vlky a jednoho velkeho, za kym jdes?");
        System.out.println("A) Dva mensi       B) Vetsi");
        System.out.println();

        String AB = sc.nextLine();
        AB = vail(AB, sc);

        if (AB.equalsIgnoreCase("a") == true) {
            MensiVlci mensi = new MensiVlci();
            fight(hrac, mensi, sc);
            System.out.println("Vsimnes si ze vzadu je jeste jeden velky vlk.");
            VetsiVlk vetsi = new VetsiVlk();
            fight(hrac, vetsi, sc);
        }else if  (AB.equalsIgnoreCase("b") == true) {
            VetsiVlk vetsi = new VetsiVlk();
            fight(hrac, vetsi, sc);
            System.out.println("Vsimnes si ze vzadu je jeste jeden velky vlk.");
            MensiVlci mensi = new MensiVlci();
            fight(hrac, mensi, sc);
        }
    }
    private static void fight12(Hrac hrac, Scanner sc){
        System.out.println();
        System.out.println("Protoze si nechtel nebo nemohl si sedel v baru az do pulnoci.");
        System.out.println("Trochu sis prispal a hned jak ses probudil uvidela muze, ktery je asi trikrat vetsi nez ty.");
        if(hrac.bojovnik == true){
            System.out.println("Si bojovnik, ale presto si tak velkeho muze nevidel.");
        }
        if(hrac.procentoPlnosti > 20){
            System.out.println("Velky muz: kamo, kolik si toho snedl?");
            System.out.println("A) 'Urcite ne vic nez ty'      B) 'Jak se jmenujes?'");
            System.out.println();
        }else{
            System.out.println("Velky muz: hej, to je moje misto.");
            System.out.println("A) 'Ty by ses stejne nevesel.      B) 'Jak se jmenujes?'");
            System.out.println();
        }
        String AB = sc.nextLine();
        AB = vail(AB, sc);


        if (AB.equalsIgnoreCase("a") == true) {
            System.out.println();
            System.out.println("Nekdo ze zadu: oooh tos nemel, ted te Arsen zabije.");
            System.out.println("Arsen ted stoji pred tebou a nastvane rika: si mrtvy!!!");
            System.out.println();
            Arsen arsen = new Arsen();
            fight(hrac,arsen, sc);
        }else if (AB.equalsIgnoreCase("b") == true) {
            System.out.println("Velky muz: Arsen, co ty?");
            System.out.println("A) " + hrac.jmeno + "      B) Co te to zajima");
            System.out.println();
            AB = sc.nextLine();
            AB = vail(AB, sc);

            if (AB.equalsIgnoreCase("a") == true) {
                System.out.println("Arsen: hmmm, nikdo mi nechtel rict svoje jmeno, vsichni se me boji, ja asi pujdu, tady mas 15 zlataku.");
                System.out.println(hrac.jmeno + ": diky.");
                System.out.println("Arsen odesel a tys zustal v baru.");
                hrac.penize = hrac.penize + 15;

            }else if (AB.equalsIgnoreCase("b") == true) {
                System.out.println("Nekdo ze zadu: oooh tos nemel, ted te Arsen zabije.");
                System.out.println("Arsen ted stoji pred tebou a nastvane rika: si mrtvy!!!");
                System.out.println();
                Arsen arsen = new Arsen();
                fight(hrac,arsen, sc);
            }
        }

    }
    private static void fight(Hrac hrac, Enemy enemy,Scanner sc) {
        System.out.println();
        if (hrac.hp > 0) {
            switch (enemy.pady) {
                case 1:
                    System.out.println("Jdes fightit s mensimi vlky.");
                    break;
                case 2:
                    System.out.println("Jdes fightit s velkym vlkem.");
                    break;
                case 3:
                    System.out.println("Jdes fightit s Arsenem.");
                    break;

            }
            System.out.println();

            while (enemy.hp > 0 && hrac.hp > 0) {
                System.out.println();
            if(hrac.hp == 1){
                System.out.println("Ted mas " + hrac.hp + " zivot.");
                System.out.println();
            }else if (1 < hrac.hp && hrac.hp < 5){
                System.out.println("Ted mas " + hrac.hp + " zivoty.");
                System.out.println();
            }else if(hrac.hp > 5){
                System.out.println("Ted mas " + hrac.hp + " zivotu.");
                System.out.println();
            }

                if (enemy.pady == 1) {
                    System.out.println(enemy.jmeno + " ted maji " + enemy.hp + " hp");
                    System.out.println();
                } else {
                    System.out.println(enemy.jmeno + " ted ma " + enemy.hp + " hp");
                    System.out.println();
                }


                if (hrac.mec == true) {
                    System.out.println("Chces zautocit mecem (-" + (hrac.damage + 2) + " hp) nebo rukou (-" + hrac.damage + " hp ) ?");
                    System.out.println("""
                            A) Mec
                            B) Ruka
                            """);

                    String AB = sc.nextLine();
                    AB = vail(AB, sc);

                    if (AB.equals("a") || AB.equals("A")) {
                        hrac.damage = hrac.damage + 2;
                        enemy.hp = enemy.hp - hrac.damage;
                        hrac.damage = hrac.damage - 2;
                    } else {
                        enemy.hp = enemy.hp - hrac.damage;
                    }

                } else {
                    System.out.println("Chces zautocit klackem (-" + (hrac.damage + 1) + " hp) nebo rukou (-" + hrac.damage + " hp ) ?");
                    System.out.println("""
                            A) Klacek
                            B) Ruka
                            """);

                    String AB = sc.nextLine();
                    AB = vail(AB, sc);

                    if (AB.equals("a") || AB.equals("A")) {
                        hrac.damage = hrac.damage + 1;
                        enemy.hp = enemy.hp - hrac.damage;
                        hrac.damage = hrac.damage - 1;
                    } else {
                        enemy.hp = enemy.hp - hrac.damage;
                    }


                }

                Random random = new Random();

                int randDam = random.nextInt(enemy.damage) + 1;


                if (enemy.hp > 0) {
                    hrac.hp = hrac.hp - randDam;
                    System.out.println();
                    if (hrac.hp <= 0) {
                        if (enemy.pady == 1) {
                            System.out.println(enemy.jmeno + " ti ubrali " + randDam + " a tim te zabili");
                        } else {
                            System.out.println(enemy.jmeno + " ti ubral " + randDam + " a tim te zabil");
                        }
                    } else {
                        if (enemy.pady == 1) {
                            System.out.println(enemy.jmeno + " ted na tebe jdou zautocit a uberou ti " + randDam);
                        } else {
                            System.out.println(enemy.jmeno + " ted jde na tebe zautocit a ubere ti " + randDam);
                        }
                    }
                }
            }
            if (hrac.hp <= 0) {
                switch (enemy.pady) {
                    case 1:
                        System.out.println();
                        System.out.println("Dva maly vlci te uplne roztrhali. Lidi nad nimi vyhrali a tys byl pohrben den potom.");
                        System.out.println("Vsichni si te ted pamatuji jako statecneho bojovnika dvou vlku, ktery se jmenoval " + hrac.jmeno);
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Velky vlk te zachytil a vyhodil do vysky 30 metru. Lidi nad nim vyhrali a tys byl pohrben den potom.");
                        System.out.println("Vsichni si te ted pamatuji jako statecneho bojovnika velkeho vlka, ktery se jmenoval " + hrac.jmeno);
                        System.out.println("Taky si dosahl rekordu nejvyssiho letu v te vesnici. (30 metru)");
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Arsen te vzal, vyhodil te z okna, pozdeji na tebe pristal stul, ktery te zabil.");
                        System.out.println("Vsichni si te ted pamatuji jako clovicka, ktery nastval Arsena a jmenoval se " + hrac.jmeno);
                        break;
                }
            } else if (enemy.hp <= 0) {
                switch (enemy.pady) {
                    case 1:
                        System.out.println();
                        System.out.println("Poslednim uderem si zabil dva maly vlky.");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Poslednim uderem si zabil velkeho vlka.");
                        System.out.println();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Poslednim uderem si zabil Arsena.");
                        System.out.println();
                        break;

                }
            } else {
                switch (enemy.pady) {
                    case 1:
                        System.out.println();
                        System.out.println("Ty si zautocil na jedno vlka mezitm co druhy sel ze zadu.");
                        System.out.println("Vsichni si te ted pamatuji jako statecneho bojovnika dvou vlku, ktery se jmenoval " + hrac.jmeno);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Ty si skocil na vlka a zautocil na nej tak silne, ze te shodil na zem. Tys zemrel, ale on taky.");
                        System.out.println("Vsichni si te ted pamatuji jako statecneho bojovnika velkeho vlka, ktery se jmenoval " + hrac.jmeno);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println();
                        if (hrac.mec == true){
                            System.out.println("Hodil si na Arsena mec, ten se zabodl do jeho hrudi, ale on uz bezel za tebou a nez dobehl tak zemrel a spadl na tebe.");
                        }else {
                            System.out.println("Hodil si na Arsena klacek, ten se zabodl do jeho hrudi, ale on uz bezel za tebou a nez dobehl tak zemrel a spadl na tebe.");
                        }
                        System.out.println("Kvuli tomu jste oba dva mrtvy. Trvalo tri tydny nez se ten bar uklidil, ale nikdy se nezapomnelo jmeno " + hrac.jmeno);
                        System.out.println();
                        break;
                }

            }

        }
    }

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
        while (!ABCD.equals("a") && !ABCD.equals("A") &&  !ABCD.equals("b") &&  !ABCD.equals("B") &&  !ABCD.equals("c") &&  !ABCD.equals("C") &&  !ABCD.equals("d") &&  !ABCD.equals("D")) {
            System.out.println("Napis A nebo B nebo C nebo D.");
            ABCD = sc.nextLine();
        }
        return ABCD;
    }
    private static void barvail(String AB, Scanner sc, Hrac hrac){
        String chcesJeste = "a";
        while(chcesJeste.equalsIgnoreCase("a")) {
            System.out.println();
            System.out.println("Date si piti nebo jidlo?");
            System.out.println("A) Piti            B) Jidlo");
            System.out.println();
            AB = sc.nextLine();
            AB = vail(AB, sc);

            if (AB.equalsIgnoreCase("a") == true) {//Jde si dat Piti
                int zradlo = 1;
                System.out.println();
                System.out.println("Co si date?");
                System.out.println("A) Dzus            B) Rum          C) Pivo             D) Kava");
                System.out.println("za 1 zlatak       za 5 zlataku    za 2 zlataky       za 2 zlataky ");
                System.out.println();

                String ABCD = sc.nextLine();
                ABCD = vailD(ABCD, sc);

                PitiJidlo pitiJidlo = coZrat(zradlo, ABCD);
                maPrachy(hrac, pitiJidlo);

            } else if (AB.equalsIgnoreCase("b") == true) {//Jde si dat Jidlo
                int zradlo = 2;
                System.out.println();
                System.out.println("Co si date?");
                System.out.println("A) Dort (cokoladovy)        B) Pizza (stredoveka)       C) Steak (s hranolkama)       D) Jablko (jedno)");
                System.out.println("za 3 zlataky                  za 5 zlataky                  za 7 zlataku                   za 1 zlatak ");
                System.out.println();

                String ABCD = sc.nextLine();
                ABCD = vailD(ABCD, sc);

                PitiJidlo pitiJidlo = coZrat(zradlo, ABCD);
                maPrachy(hrac, pitiJidlo);

            }
            System.out.println();
            System.out.println("Chces jeste neco?");
            System.out.println("A) Ano            B) Ne");
            System.out.println();
            chcesJeste = sc.nextLine();
            chcesJeste = vail(chcesJeste, sc);
        }
    }


    private static void maPrachy(Hrac hrac, PitiJidlo pitiJidlo){
        if(hrac.penize >= pitiJidlo.cena){
            hrac.penize = hrac.penize - pitiJidlo.cena;
            hrac.procentoOpilost = hrac.procentoOpilost + pitiJidlo.procentoOpilosti;
            hrac.procentoPlnosti = hrac.procentoPlnosti + pitiJidlo.procentoPlnosti;
            System.out.println("Dal sis " + pitiJidlo.jmeno + " a utratil si " + pitiJidlo.cena + " zl. Mas " + hrac.penize + " zl.");
            System.out.println();
        }else{
            System.out.println("Nemas na to prachy.");
        }
    }
    private static PitiJidlo coZrat(int zradlo, String ABCD){
        PitiJidlo  pitiJidlo = new PitiJidlo();
        if(zradlo == 1){
            switch(ABCD){
                case "a", "A" :
                    pitiJidlo =new dzus();
                    break;
                case "b", "B" :
                    pitiJidlo =new rum();
                    break;
                case "c", "C" :
                    pitiJidlo =new pivo();
                    break;
                case "d", "D":
                    pitiJidlo =new kava();;
                    break;
            }
        }else if(zradlo == 2){
            switch(ABCD){
                case "a", "A" :
                    pitiJidlo =new dort();
                    break;
                case "b", "B" :
                    pitiJidlo =new pizza();
                    break;
                case "c", "C" :
                    pitiJidlo =new steak();
                    break;
                case "d", "D":
                    pitiJidlo =new jablko();;
                    break;
            }
        }
        return pitiJidlo;
    }

    public static void printSlow(String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(400);
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
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }



}



