package randombull.CelaHra.Postava;
import java.util.Scanner;
import java.util.Random;

public class hra{
 public static void main(String [] args){
Scanner sc = new Scanner (System.in);
     uvod();

     System.out.println("Chces mit klacek nebo mec?");
 System.out.println();
 String volba1 = sc.nextLine();



if(volba1.equals("mec") || volba1.equals("meč") || volba1.equals("Meč") || volba1.equals("Mec")){//kdyz vybere mec
 System.out.println();
 System.out.println("Vyborna volba!");
 System.out.println();
 System.out.println("Mozna prezijes....");
 System.out.println();

    }else if(volba1.equals("klacek") || volba1.equals("Klacek")){         // kdyz vybere klacek
 System.out.println();
      System.out.println("Ok....");
      System.out.println("Vis co? Budes mit mec :D"); 
      System.out.println();

    }else {
    System.out.println();
    System.out.println("Nechapu co tim myslis, takze dostanes mec."); 
    System.out.println();
    volba1 = "mec";
    }

    System.out.println();
    System.out.println("Mimochodem, jak se vlastne jmenujes?");
    System.out.println();
    System.out.println("Napis to s velkym pismenem");
    System.out.println();
    String jmeno = sc.nextLine();
    System.out.println();
    System.out.println("Hmm " + jmeno + " zajimavy.....");
    System.out.println();
    System.out.println("ok " + jmeno + " jdes ven ze sve vesnice a musis si vybrat cestu mezi lesem a barem");
    System.out.println();
    System.out.println("Kam to bude ?");
    System.out.println();
    System.out.println("Instrukce: napis les nebo bar");
    System.out.println();
    String volba2 = sc.nextLine();
   

    if(volba2.equals("les") || volba2.equals("Les")){//typek vybere les
            int sv = 1;
          System.out.println();
          System.out.println("Takze sis vybral les, spooky ze?");
          System.out.println();
          System.out.println("Bojis se?");
          System.out.println();
          System.out.println("Ja taky ne, ehm...");
          System.out.println();
          System.out.println("No uz je pozde, byt tebou bych sel spat.");
          System.out.println();
          System.out.println("Chces jit spat? ano/ne");
          System.out.println();
          String spanek = sc.nextLine();
         
            if(spanek.equals("ano") || spanek.equals("Ano")){
            System.out.println();
            System.out.println("Ok, jdes spat dobrou");
            System.out.println();
          }else if(spanek.equals("ne") || spanek.equals("Ne")){
            int n = (int)(Math.random() * 1001);
            System.out.println();
            System.out.println("Ok, jestli si myslis ze si tak hustej, tak ti dam challenge");
            System.out.println("Napis cislo od jedne do 1000, jestli to trefis neusnes, jestli ne tak udelas zzzzzzz");
            System.out.println(); 
            int cislo = sc.nextInt();
             
              if(n != cislo){
            System.out.println();
            System.out.println("Well... tvoje cislo je " + cislo + " ale moje cislo je " + n);
            System.out.println("Takze bohuzel, dobrou :D ");
            System.out.println();
             
              }else if (n == cislo){
              System.out.println();
              System.out.println("WOW");
              System.out.println("Dal si to");
              System.out.println("Ale bohuzel, tim jak si premyslel nad cislem si usnul, dobrou");
              System.out.println();
              }else{
                System.out.println();
                System.out.println("ok nevim co si udelal ale usnul si");
                System.out.println();
              }
          }       
       
    }else if(volba2.equals("bar") || volba2.equals("Bar")){
        int sv = 2;
        System.out.println();
          System.out.println("Dojdes do baru");
          System.out.println();
          System.out.println("Jsou tam tri barmani.");
          System.out.println();
          System.out.println("Jeden je ryba, druhy je roboticka zena a treti je elf");
          System.out.println();
          System.out.println("Tak si vyber. Napoveda: napis to v 1. pade");
          System.out.println();
          String barman = sc.nextLine();
          if (barman.equals("ryba") || barman.equals("Ryba") || barman.equals("roboticka zena") || barman.equals("Roboticka zena") || barman.equals("elf") || barman.equals("Elf")){
            System.out.println();
            System.out.println(barman + " te jde oblouzit.");
            System.out.println();
            System.out.println(barman + ": Chcete pivo nebo limonadu?");
            }else{
              barman = "Ryba";
              System.out.println();
              System.out.println(barman + " te jde oblouzit.");
              System.out.println();
              System.out.println(barman + ": Chcete pivo nebo limonadu?");
              System.out.println();
            }
            String piti = sc.nextLine();
          if(piti.equals("pivo") || piti.equals("Pivo")){
           
            System.out.println();
            System.out.println("Tady mate pivo");
            System.out.println("Podekuj");
            System.out.println();
            String podek = sc.nextLine();
              if(podek.equals("dekuju") || podek.equals("děkuju") || podek.equals("Děkuju") || podek.equals("Dekuju")){
                System.out.println();
                System.out.println(barman + ": nemate zac :3");
                System.out.println();
                Random rand = new Random();
                int y = rand.nextInt(10000) + 100;
                System.out.println("Dal sis " + y + " piv");
                System.out.println("a po " + y + ". pivu si usnul");
                System.out.println();
              }else{
                System.out.println();
                System.out.println(barman + ": COS TO REK ???!!");
                System.out.println();
                System.out.println("Barman te prasti a ty usnes");
                System.out.println();
              }

          }else if(piti.equals("limonadu") || piti.equals("Limonadu")) {
                System.out.println();
                System.out.println(barman + ":Limonadu? Ses holka?");
                System.out.println(barman + ":Ne budes mit pivo, tady..");
                System.out.println();
                System.out.println("Podekuj");
            String podek = sc.nextLine();
              if(podek.equals("dekuju") || podek.equals("děkuju") || podek.equals("Děkuju") || podek.equals("Dekuju")){
                System.out.println();
                System.out.println(barman + ": nemate zac :3");
                System.out.println();
                Random rand = new Random();
                int y = rand.nextInt(100001) + 100;
                System.out.println("Dal sis " + y + " piv");
                System.out.println("a po " + y + ". pivu si usnul");
                System.out.println();
              }else{
                System.out.println();
                System.out.println(barman + ": COS TO REK ???!!");
                System.out.println("Barman te prasti a ty usnes");
                System.out.println();
              }


          }else{
            System.out.println();
            System.out.println(barman + ": to neznam, dam ti pivo");
            System.out.println();
            System.out.println("Podekuj");
            String podek = sc.nextLine();
              if(podek.equals("dekuju") || podek.equals("děkuju") || podek.equals("Děkuju") || podek.equals("Dekuju")){
                System.out.println();
                System.out.println(barman + ": nemate zac :3");
                System.out.println();
                Random rand = new Random();
                int y = rand.nextInt(100001) + 100;
                System.out.println("Dal sis " + y + " piv");
                System.out.println("a po " + y + ". pivu si usnul");
                System.out.println();
              }else{
                System.out.println();
                System.out.println(barman + ": COS TO REK ???!!");
                System.out.println("Barman te prasti a ty usnes");
                System.out.println();
              }
              if(sv == 1){
                  System.out.println("Probudil ses.");

              }else if(sv == 2){
                  System.out.println("Probudil ses z nejakeho duvodu v lese.");
              }


          }    
    }
  }

    private static void uvod() {
        System.out.println();
        System.out.println("Hej bracho, vitej ve hre!");
        System.out.println();
        System.out.println("Prvni volba, kterou budes muset udelat bude mezi dvema dulezitymi vecmi.");
        System.out.println();
    }
}   

