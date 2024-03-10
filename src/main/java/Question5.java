import java.util.Scanner;

/**
 * Contains the tasks of question 5
 * @author  Joseph Josue Forestal
 */
public class Question5 {
    static boolean isNotExit = true;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String blockOfDay = """
                * 1 : Monday
                * 2: Tuesday
                * 3: Wednesday
                * 4: Saturday
                * 5: Friday nights
                * 6 : Saturday
                * 7 : Sunday
                """;

        System.out.println(blockOfDay);
        int count = 1;
        boolean wantPerson = true;
        int totalPrice = 0;
        while(isNotExit) {
            System.out.println("Enter one of the integer above for the day you want to chose: ");
            if(!sc.hasNextInt()) System.out.println("Must be an Integer of the given day");
            dayOfTheWeek day = dayOfTheWeek(sc.nextInt());

            System.out.println("How old is Person one ?: ");
            if(!sc.hasNextInt()) System.out.println("The age must be a full number");
            Person p1 = new Person(sc.nextInt());
            totalPrice += getPrice(day,p1);
            while (wantPerson) {
                System.out.println("Do you want to add another person ?");
                String answer = sc.next();
                if(answer.equalsIgnoreCase("Y")) {
                    count++;
                    System.out.println("What is the age of the person " + count+ "?");
                    if(!sc.hasNextInt()) System.out.println("The age must be an integer");
                  totalPrice += getPrice(day, personNa(sc.nextInt()));
                }else if (answer.equalsIgnoreCase("N")){
                    wantPerson = false;
                }
            }
            break;
        }
        System.out.println("Total price is " + totalPrice + "$");
    }

    /***
     * Case based on the day of the weeks
     * @param day take int day of the week
     * @return the enum day of the week
     */
    public static dayOfTheWeek dayOfTheWeek(int day){
        return switch (day){
            case 1 -> dayOfTheWeek.Monday;
            case 2 -> dayOfTheWeek.Tuesday;
            case 3 -> dayOfTheWeek.Wednesday;
            case 4 -> dayOfTheWeek.Thursday;
            case 5 -> dayOfTheWeek.Friday;
            case 6 -> dayOfTheWeek.Saturday;
            case 7 -> dayOfTheWeek.Sunday;
            default -> null;
        };
    }

    /***
     * Get the price based on the person is age
     * @param day the day of the week
     * @param person the person object
     * @return an integer that represent the money
     */
    public static int getPrice(dayOfTheWeek day, Person person) {
        if (day == dayOfTheWeek.Monday || day == dayOfTheWeek.Tuesday
                || day == dayOfTheWeek.Wednesday || day == dayOfTheWeek.Thursday) {
            if (person.isAdult(person)) {
                return 20;
            } else return 15;
        } else if (day == dayOfTheWeek.Friday) {
            if (!person.isAdult(person)) return 25;
            else return 30;
        } else {
            if (person.isAdult(person)) return 40;
            else return 35;
        }
    }

    /**
     * method that return a new person
     * @param age take the age since the constructor take the age
     * @return a peron with an age
     */
        public static Person personNa(int age){
            return new Person(age);
        }

    /**
     * Enum of the day of the week
     */
    public enum dayOfTheWeek{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }
}

/**
 * Contains the info a person (only its age)
 * @author Jospeh Josue Forestal
 */
class Person{
    int age;
    public Person(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    /**
     * Check if person is adult
     * @param person take a person object
     * @return a boolean value
     */
    public  boolean  isAdult(Person person){
        if(person.getAge() >= 18) return true;
        else return false;
    }
}
