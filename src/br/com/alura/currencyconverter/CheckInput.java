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
            } else {
                return input.trim().toUpperCase();
            }

        }
    }
}
