package homeWorks.homeWork01;

public class Task2 {

    public static void main(String[] args) {

        for (int i = 10; i < 100; i++) {
            System.out.printf("%d -> %d\n", i, getNumbersSum(i));
        }

    }

    /**
     * Метод получения суммы цифр двухзначного целого числа
     * @param value значение
     * @return сумма цифр
     */
    private static int getNumbersSum(int value){
        return  (value / 10) + (value % 10);
    }
}
