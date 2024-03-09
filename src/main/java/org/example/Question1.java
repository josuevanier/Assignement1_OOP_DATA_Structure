package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {
    static Scanner sc = new Scanner(System.in);
    static boolean isExit = false;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String msgMenu = """
         * You must have an array in order to have these features        
         * If you want to add an element to an array enter: 1
         * If you want to sort an array enter: 2
         * If you want to remove an array enter: 3
         * If you want to find all the repeated elements(elements are automatically sorted) 
         and the one that is repeated the most enter : 4
         * If you want to display display enter: 5
         * If you want to see what the number you will enter does, enter: 6
         * If you want to exit enter: 7
                """;

        System.out.println(msgMenu);
        try {
        int[] array = getInputsArrays();
        while (!isExit){
            System.out.println("What feature would you like . Note it can only be one " +
                    "of the feature stated earlier: ");
            if(!sc.hasNextInt()) throw new InputMismatchException("Must be an integer");
            int num = sc.nextInt();
            array = menu(num,array);
        }
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("To many exceptions !");
        }
    }

    public static  int[] getInputsArrays() throws InputMismatchException{

        System.out.println("Hi ! How many elements you would like to enter : ");

        if(!sc.hasNextInt()){
            throw new InputMismatchException("Must be an integer");
        }
        int numberOfElements = sc.nextInt();
        int index = 0;
        int count = 0;

        int[] arrays = new int[numberOfElements];
        while(index < numberOfElements){
            System.out.println("Enter your " + count + ": ");
            if(!sc.hasNextInt()) throw new InputMismatchException("The input must be an integr !");
            arrays[count] = sc.nextInt();
            count++;
            index++ ;
        }
        return arrays;
    }

    public static int[] addElement(int[] arrays, int num) throws InputMismatchException{
        int[] addedElements = new int[arrays.length + 1];
        for (int i = 0; i < arrays.length; i++) {
            addedElements[addedElements.length - 1] = num;
            addedElements[i] = arrays[i];
        }
        return addedElements;
    }
    public static void findRepeatedElements(int[] arrays) throws InputMismatchException{
        int max = Integer.MIN_VALUE;
        Arrays.sort(arrays);
        int count = 0;
        int currentElement = 0;
        int index = 0;
        for(int i = index; i <= arrays.length - 1; i++){
            for(int j = i  ; j < arrays.length;j++) {
                if ( (arrays[i] == arrays[j])) {
                    index++;
                    count++;
                }
            }
             System.out.print("The element " + arrays[i] + " "+ " is repeated " + count + " time");
                if( count > 1) {
                    i = index - 1;
                }else index = i;

            if( count > max && count > 1){
                max = count;
                currentElement = arrays[i];
            }
            count = 0;
            System.out.print("\n");
            }
        if( max <= 1){
            System.out.println("No occurence!");
        }else {
            System.out.println("The element " + currentElement + " is repeated the most " + max);
        }

    }

    public static  int[] removeElement(int[] arrays, int index){
        if(  index < 0 || index >= arrays.length){
                throw new ArrayIndexOutOfBoundsException("Invalid Index | " + " You can only put " +
                        "an index from " + 0 + " to " + (arrays.length - 1));
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
    public static int[] menu(int num,int[] arr) throws InputMismatchException{
        switch (num) {
                case 1:
                    System.out.println("Integer value you want to add ?");
                    if(!sc.hasNextInt()){ throw new InputMismatchException("Must be an integer");}
                    else arr = addElement(arr, sc.nextInt());
                   break;
                case 2:
                    sortArray(arr);
                    break;
                case 3:
                    System.out.println("Index to remove the element:");
                    if(!sc.hasNextInt()){ throw new InputMismatchException("Must be an integer");}
                     else {
                        System.out.println("Index to remove the element:");
                        arr = removeElement(arr, sc.nextInt());
                    }
                    break;
                case 4:
                    findRepeatedElements(arr);
                    break;
                case 5:
                    if(!sc.hasNextInt()){ throw new InputMismatchException("Must be an integer");}
                    else display(arr);
                    break;
                case 6:

                        System.out.print("Enter the integer to see what it does: ");
                    if(!sc.hasNextInt()) {
                        throw new InputMismatchException("Must be an integer");
                    }
                    else  printCase(sc.nextInt());
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
    public static void printCase(int num){
        switch (num){
            case 1-> System.out.println("1 add an element");
            case 2 -> System.out.println("2 sort the array");
            case 3 -> System.out.println("3 remove an element");
            case 4 -> System.out.println("4 find the repeated element");
            case 5 -> System.out.println("5 display the element");
            case 6 -> System.out.println("6 show the what the choices");
            case 7 -> System.out.println("7 is to exit");
            default -> System.out.println(num + " do nothing");
        }
    }
}
