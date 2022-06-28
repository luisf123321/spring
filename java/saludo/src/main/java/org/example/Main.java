package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String saludo = "hello world";
        byte num1 = 1;
        int num2 = 100;
        long num3 = 10000000;

        char letter = 'a';

        boolean flag = true;

        double num4 = 3.3;
        float num5 = 3.4f;
        Funciones funciones = new Funciones();

        double resultado = funciones.getPrice(200);
        System.out.println(resultado);


        String[] nombres = {"luis", "juan", "carlos", "pedro"};
        for(String nombre:nombres){
            System.out.print(nombre + ", ");

        }

    }
}