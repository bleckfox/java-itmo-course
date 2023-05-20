package homeWorks.homeWork3;

public class Task1 {
    public static void main(String[] args) {

        int cycleCounter = 0;

        for (int i = 2; i < 100; i+=2) {
            if(cycleCounter != 10){
                cycleCounter++;
                System.out.printf("%d -> %d\n", cycleCounter, i);
                continue;
            }
            break;
        }

    }
}
