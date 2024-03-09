package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> stringsOfUser = new ArrayList<>();

        System.out.println("How many elements you want to enter: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.print(" Your " + i + "String: ");

            String name = sc.next();

                if (!(stringsOfUser.contains(name))) {
                    stringsOfUser.add(name);
            }
        }
        for(String string : stringsOfUser){
            if(stringsOfUser.size() > 1) System.out.print(string + ", ");
            else System.out.print(string + " ");
        }
    }
}
