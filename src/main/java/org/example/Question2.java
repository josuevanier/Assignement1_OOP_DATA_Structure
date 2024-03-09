package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> stringsOfUser = new ArrayList<>();

        try {
            int count = 0;
            System.out.println("How many elements you want to enter: ");
            if (!sc.hasNext()) {
                throw new InputMismatchException("Illegal argument Exception");
            } else {
                int n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    System.out.print(" Your " + i + "String: ");
                    if (!sc.hasNext()) throw new InputMismatchException("Must be a string");
                    else {
                        String name = sc.next();

                        if (!(stringsOfUser.contains(name))) {
                            stringsOfUser.add(name);
                            count++;
                        }
                    }
                }
                for (String string : stringsOfUser) {
                    if (stringsOfUser.size() > 1 && (stringsOfUser.size() <= count || stringsOfUser.size() <= n)) System.out.print(string + " | ");
                    else System.out.print(string + " ");
                }
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}
