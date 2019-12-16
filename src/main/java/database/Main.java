package database;

import Weather.Voivodship;
import Weather.Wojewodztwo;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Voivodship> lista = new ArrayList<>();
        Wojewodztwo wojewodztwo = new Wojewodztwo();
      lista =  wojewodztwo.wojewodztwo();
        for (int i = 0; i <lista.size() ; i++) {
            System.out.println(lista.get(i).toString());
        }
    }
}