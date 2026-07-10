package it.unicam.cs.mpgc.rpg122641.Models;

public class Shadowhunters extends Personaggio{
public String nome;

public Shadowhunters(int attacco, int difesa){

    super(attacco,difesa);

}



public boolean isVivo(){
if (getAttacco() > 0 && getDifesa() > 0){
    return true;
    }

return false;

}
}
