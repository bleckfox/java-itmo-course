package homeWork5;

public class Task4 {
    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i = 1; i <= 10; i++) {
            array[i-1] = i * 2;
        }

        System.out.println("Элементы массива по убыванию:");
        System.out.println("индекс -> значение");
        for (int i = (array.length - 1); i >= 0 ; i--) {
            System.out.printf("%d -> %d\n", i, array[i]);
        }
    }
}
