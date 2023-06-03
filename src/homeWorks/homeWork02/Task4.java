package homeWorks.homeWork02;

public class Task4 {
    public static void main(String[] args) {

        int count = 90;
        if (count < 0){
            System.out.println("Task 4 -> Как вы так смогли?");
        } else if (count <= 39){
            System.out.println("Task 4 -> попробуйте в следующий раз");
        } else if (count <= 59){
            System.out.println("Task 4 -> удовлетворительно");
        } else if (count <= 89){
            System.out.println("Task 4 -> хорошо");
        } else if (count <= 100){
            System.out.println("Task 4 -> отлично");
        }

    }
}
