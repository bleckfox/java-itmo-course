package homeWork1;

public class Task1 {

    public static void main(String[] args) {

        float area = getRectangleArea(5, 6);
        System.out.printf("Площадь прямоугольника %f, м2\n", area);

        int cube = (int) Math.pow(2, 3);
        System.out.printf("Число 2 в кубе = %d\n", cube);

        double speed = getSpeedByHourAndKilometers(3, 100);
        System.out.printf("Если время движения = 3 часа, а расстояние = 100 км. Скорость = %f м/с", speed);
    }

    /**
     * Метод получения значения площади прямоугольника
     * @param length длина
     * @param width ширина
     * @return значение площади
     */
    private static float getRectangleArea(float length, float width){
        return length * width;
    }

    /**
     * Метод получения значения скорости в м/с
     * @param time время (в часах)
     * @param distance расстояние (в километрах)
     * @return значение скорости в м/с
     */
    private static double getSpeedByHourAndKilometers(double time, double distance){
        double convertCoefficient = (double) 1000 / 3600;
        return (time / distance) * convertCoefficient;
    }
}