package org.example;

public class Funciones {

    public double getPrice(double price){
        int iva = 16;
        return price +(price*(iva/100));
    }

}
