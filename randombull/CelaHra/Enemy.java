package randombull.randombull.CelaHra;

public class Enemy extends Entita {
    int pady;
}
class MensiVlci extends Enemy {
    public MensiVlci(){
        jmeno = "Mensi vlci";
        hp = 20;
        damage = 4;
        pady = 1;
    }
}
class VetsiVlk extends Enemy {
    public VetsiVlk() {
        jmeno = "Vetsi vlk";
        hp = 35;
        damage = 8;
        pady = 2;
    }
}
class Arsen extends Enemy{
    public Arsen(){
        jmeno = "Arsen";
        hp = 30;
        damage = 7;
        pady = 3;
    }
}
class drak extends Enemy{
    public drak(){
        jmeno = "drak";
        hp = 45;
        damage = 10;
        pady = 4;
    }
}


