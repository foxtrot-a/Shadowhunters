package it.unicam.cs.mpgc.rpg122641.Models;

public class Daemon extends Personaggio {

private boolean demoneSuperiore;
   public Daemon(int attaco, int difesa, boolean demoneSuperiore){
       super(attaco,difesa);
       this.demoneSuperiore = demoneSuperiore;
}

}
