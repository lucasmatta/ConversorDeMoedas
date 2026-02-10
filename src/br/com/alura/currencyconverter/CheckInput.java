package br.com.alura.currencyconverter;

import java.util.Scanner;

public class CheckInput {
    public static String checkInput(Scanner reading, String message) {
        while (true) {
            System.out.println(message);
            String input = reading.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Até mais!");
                return null;
            } else if (input.equalsIgnoreCase("kpw")) {
                System.out.println("Nossa API não tem informações sobre o Wan norte-coreano.");
            } else if (input.equals("0")){
                System.out.println("Digite algo que não seja zero!");
            } else if (input.isEmpty()) {
                System.out.println("Digite alguma coisa!");
            } else {
                return input.trim().toUpperCase();
            }
        }
    }
}

