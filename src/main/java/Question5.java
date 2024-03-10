import java.util.Scanner;

public class Question5 {
    static boolean isNotExit = true;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String blockOfDay = """
                * 1 : Monday
                * 2: Tuesday
                * 3: Wednesday
                * 4: Saturday
                * 5: Friday
                * 6 : Saturday
                * 7 : Sunday
                """;


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
                    System.out.println("What is the age of the person");
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
        public static Person personNa(int age){
            return new Person(age);
        }

    public enum dayOfTheWeek{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }
}
class Person{
    int age;
    public Person(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public  boolean  isAdult(Person person){
        if(person.getAge() >= 18) return true;
        else return false;
    }
}

