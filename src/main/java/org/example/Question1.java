package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        int[] array = {1,2,2,2,2,4,4,5,6};
        Arrays.sort(array);



        findRepeatedElements(array);
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
            index++ ;
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
    public static void findRepeatedElements(int[] arrays){
        Arrays.sort(arrays);
        int count = 0;
        int currentElement;
        int index = 0;

        for(int i = index; i <= arrays.length - 1; i++){

            for(int j = i; j < arrays.length; j++) {
                if (arrays[i] == arrays[j]) {
                    index++;
                    count++;
                }
            }
                System.out.print("The element " + arrays[i] + " is repeated " + count + " time");
            i = index;
                count = 0;
            System.out.println(" ");

            }
    }
}
