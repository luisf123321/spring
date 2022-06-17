package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

       CalculatorService calculadora = (CalculatorService) context.getBean("calculatorService");

       String text = calculadora.hello();
        System.out.println(text);

        CalculatorService calculadora2 = (CalculatorService) context.getBean("calculatorService");
        text = calculadora2.hello();
        System.out.println(text);

        GestorFactura gestorFactura = (GestorFactura) context.getBean("gestionFactura");
        System.out.println(gestorFactura.calculatorService.hello());

    }
}