package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        int[] array = getInputsArrays();

        System.out.println(Arrays.toString(addElement(array, 3)));

    }






    public static  int[] getInputsArrays(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi ! How many elements you would like to enter : ");

        int numberOfElements = sc.nextInt();

        int index = 0;

        int count = 0;
        int[] arrays = new int[numberOfElements];
        while(index < numberOfElements){
            System.out.println("Enter your " + count + ": ");

            arrays[count] = sc.nextInt();
            count++;
            index++;
        }
        return arrays;
    }

    public static  int[] addElement(int[] arrays, int num){
        int[] addedElements = new int[arrays.length + 1];

        for(int i = 0;  i < arrays.length; i++){
                addedElements[addedElements.length - 1 ] = num;
                addedElements[i] =  arrays[i];
        }
        return addedElements;
    }
}
