package homeWorks.homeWork02;

public class Task3 {

    private enum YearTime{
        WINTER_TIME("зима"),
        SPRING_TIME("весна"),
        SUMMER_TIME("лето"),
        AUTUMN_TIME("осень");

        public final String label;

        YearTime(String label){
            this.label = label;
        }
    }

    public static void main(String[] args) {

        int monthNumber = 3;
        // 12, 1, 2 - зима
        // 3, 4, 5 - весна
        // 6, 7, 8 - лето
        // 9, 10, 11 - осень
        if (0 < monthNumber && monthNumber < 13){
            if (monthNumber <= 2 || monthNumber == 12){
                System.out.printf("Task 3 -> %s\n", YearTime.WINTER_TIME.label);
            } else if (monthNumber <= 5){
                System.out.printf("Task 3 -> %s\n", YearTime.SPRING_TIME.label);
            } else if (monthNumber <= 8) {
                System.out.printf("Task 3 -> %s\n", YearTime.SUMMER_TIME.label);
            } else if (monthNumber <= 11) {
                System.out.printf("Task 3 -> %s\n", YearTime.AUTUMN_TIME.label);
            }
        }
        else {
            System.out.println("Task 3 -> Такого номера месяца нет в григорианском календаре!");
        }
    }
}
