public class Question5 {

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

        System.out.println("Enter which day of the week we are");

        Person p1 = new Person(13);

        System.out.println(getPrice(dayOfTheWeek(5),p1));
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
    public static int getPrice(dayOfTheWeek day, Person person){
        if(day == dayOfTheWeek.Monday || day == dayOfTheWeek.Tuesday
           || day == dayOfTheWeek.Wednesday || day == dayOfTheWeek.Thursday){
            if (person.isAdult(person)){
                return 20;
            }else return 15; 
        } else if (day == dayOfTheWeek.Friday) {
            if(!person.isAdult(person)) return 25;
            else return 30;
        }else {
            if(person.isAdult(person)) return 40;
            else return 35;
        }
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

