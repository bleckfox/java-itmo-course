package homeWork2;

public class Task6 {
    public static void main(String[] args) {

        double totalSum = 1000;
        int couponNumber = 9011;
        double discount = 0;

        switch (couponNumber){
            case 4525:
                discount = 0.3;
                break;
            case 6424:
            case 7012:
                discount = 0.2;
                break;
            case 7647:
            case 9011:
            case 6612:
                discount = 0.1;
        }

        int discountPercentage = (int) (discount * 100);
        double totalSumWithDiscount = totalSum * (1 - discount);
        System.out.printf("Task 6 ->\n" +
                        "\tсумма покупки -> %.2f\n" +
                        "\tкупон -> %d\n" +
                        "\tразмер скидки -> %d%%\n" +
                        "\tитоговая сумма -> %.2f\n" +
                        "\t---\n\tскидка составила -> %.2f\n",
                totalSum, couponNumber, discountPercentage,
                totalSumWithDiscount, (totalSum - totalSumWithDiscount));

    }
}
