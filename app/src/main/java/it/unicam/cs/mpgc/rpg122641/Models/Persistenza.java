package it.unicam.cs.mpgc.rpg122641.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistenza {
   private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
public static Object recupera(Object obj){

    try (FileReader reader = new FileReader("gioco.json")) {

        return gson.fromJson(reader, obj.getClass());

    } catch (IOException e) {

        e.printStackTrace();

    }

   return null;
}



    public static void memorizza(Object obj, String nomeFile){

        try (FileWriter writer = new FileWriter(nomeFile)) {

            // Converte l'oggetto in JSON e lo salva nel file
            gson.toJson(obj, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
