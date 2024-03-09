package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    static Scanner sc = new Scanner(System.in);
    static boolean isExit = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = getInputsArrays();

        String msgMenu = """
         * You must have an array in order to have these features        
         * If you want to add an element to an array enter: 2
         * If you want to sort an array enter: 3
         * If you want to remove an array enter: 4
         
         * If you want to find all the repeated elements(elements are automaticly sorted) 
         and the one that is repeated the most enter : 5
    
         * If you want to display display enter: 6
         * If you want to see what the number you will enter does, enter: 7
         * If you want to exit enter: 8 
                """;

        while (!isExit){
            System.out.println("What feature would you like . Note it can only be one " +
                    "of the feature stated earlier: ");
            int num = sc.nextInt();;
            array = menu(num,array);
        }
    }






    public static  int[] getInputsArrays(){
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

    public static int[] addElement(int[] arrays, int num) {
        int[] addedElements = new int[arrays.length + 1];
        for (int i = 0; i < arrays.length; i++) {
            addedElements[addedElements.length - 1] = num;
            addedElements[i] = arrays[i];
        }
        return addedElements;
    }
    public static void findRepeatedElements(int[] arrays){
        int max = Integer.MIN_VALUE;
        Arrays.sort(arrays);
        int count = 0;
        int currentElement = 0;
        int index = 0;
        for(int i = index; i <= arrays.length - 1; i++){
            for(int j = i  ; j < arrays.length; j++) {
                if ( (arrays[i] == arrays[j])) {
                    index++;
                    count++;
                }
            }
            if(count >= 1 ){ System.out.print("The element " + arrays[i] + " " +
                    "is repeated " + count + " time");
            }
            i = index;
            if( count > max && count > 1){
                max = count;
                currentElement = arrays[i];
            }
            System.out.print("\n");
            }
        if( max <= 1){
            System.out.println("No occurence ! ");
        }else {
            System.out.println("The element " + currentElement + " is repeated the most " + max);
        }
    }

    public static  int[] removeElement(int[] arrays, int index){
        if(index > arrays.length){
                throw new ArrayIndexOutOfBoundsException("This index is bigger than the array length it self " +
                        "(" + arrays.length + ")" + " Please enter a valid index");
        }
        int[] removedArray =  new int[arrays.length - 1];
        if(index == arrays.length - 1){
            for(int t = 0; t < removedArray.length; t++){
                removedArray[t] = arrays[t];
            }
        }

        for(int i = 0; i < index; i++){
            removedArray[i] = arrays[i];
        }
        for(int j =  (index + 1); j <= removedArray.length; j++){
            removedArray[j - 1] = arrays[j];
        }
        return removedArray;
    }
    public static void display(int[] arrays){
        System.out.println(Arrays.toString(arrays));
    }
    public static void sortArray(int[] array){
        Arrays.sort(array);
    }
    public static int[] menu(int num,int[] arr){

            switch (num) {
                case 1:
                    System.out.println("Integer value you want to add ?");

                    arr = addElement(arr, sc.nextInt());
                   break;
                case 2:
                    sortArray(arr);
                    break;
                case 3:
                    System.out.println("Index to remove the element:");
                    arr = removeElement(arr, sc.nextInt());
                    break;
                case 4:
                    findRepeatedElements(arr);

                case 5:
                   display(arr);
                    break;
                case 6:
                    break;
                case 7:
                    isExit = wantExit();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            return arr;
    }
    public static boolean wantExit(){
        return true;
    }
}
