package homeWork2;

public class Task5 {
    public static void main(String[] args) {

        int range = (501 - 9);
        int num04 = (int) (Math.random() * range) + 9;
        if (25 < num04 && num04 < 200){
            System.out.printf("Task 5 -> %d содержится в интервале (25;200)\n", num04);
        }
        else {
            System.out.printf("Task 5 -> %d не содержится в интервале (25;200)\n", num04);
        }

    }
}
