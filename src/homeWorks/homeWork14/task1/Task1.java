package homeWorks.homeWork14.task1;

public class Task1 {
    public static void main(String[] args) {
        Fruit fruit01 = new Fruit(FruitType.APPLE, 120, 5);
        Fruit fruit02 = new Fruit(FruitType.BANANA, 80, 12);
        Fruit fruit03 = new Fruit(FruitType.APRICOT, 300, 2);
        Fruit fruit04 = new Fruit(FruitType.APPLE, 120, 10);
        Fruit fruit05 = new Fruit(FruitType.PEAR, 180, 2);
        Fruit fruit06 = new Fruit(FruitType.PEAR, 180, 8);
        Fruit fruit07 = new Fruit(FruitType.BANANA, 130, 8);

        FruitStorage storage = new FruitStorage();
        storage.addFruit(fruit01);
        storage.addFruit(fruit02);
        storage.addFruit(fruit03);
        storage.addFruit(fruit03);
        storage.addFruit(fruit04);
        storage.addFruit(fruit05);
        storage.addFruit(fruit06);
        storage.addFruit(fruit07);

        System.out.println(storage.getNumberOfFruitsByType(FruitType.APRICOT));
        System.out.println(storage.getNumberOfFruitsByType(FruitType.BANANA));
        System.out.println(storage.getNumberOfFruitsByType(FruitType.APPLE));
        System.out.println(storage.getNumberOfFruitsByType(FruitType.PEAR));

        System.out.println(storage.getNumberOfFruits());

        storage.increasePrice(10);

        System.out.println(storage.getFruitsByTypeAndPrice(FruitType.BANANA, 150));
    }
}
