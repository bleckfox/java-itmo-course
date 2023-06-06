package homeWorks.homeWork19.task3;

import homeWorks.homeWork14.task1.Fruit;
import homeWorks.homeWork14.task1.FruitType;

import java.util.Optional;

public class Task3 {
    public static boolean isFruitValid(Fruit fruit) {
        return Optional.ofNullable(fruit)
                .filter(f -> f.getCount() >  5)
                .filter(f -> f.getPrice() <= 100)
                .isPresent();
    }

    public static Optional<Fruit> optionalFruit01(FruitType type, double price, int count){
        if (type == null || price < 1 || count < 1){
            return Optional.empty();
        }
        else {
            return Optional.of(new Fruit(type, price, count));
        }
    }

    public static boolean optionalFruit02(Fruit fruit){
        return  Optional.ofNullable(fruit)
                .filter(f -> f.getCount() > 5)
                .filter(f -> f.getPrice() <= 100)
                .isPresent();
    }

    public static Optional<String> optionalFruit03(Fruit fruit){
        return Optional.ofNullable(fruit)
                .map(Fruit::getType)
                .map(FruitType::getName);
    }

    public static void main(String[] args) {
        // Задания на методы Optional:
        // 1. написать метод, который принимает на вход тип фрукта, стоимость и количество
        // и возвращает Optional контейнер с экземпляром типа Fruit
        // или Optional контейнер с null ссылкой, если тип фрукта == null,
        // а стоимость или количество меньше 1
        FruitType type01 = FruitType.APPLE;
        double price01 = 89.5;
        int count01 = 5;

        Optional<Fruit> fruit01 = optionalFruit01(type01, price01, count01);
        fruit01.ifPresent(System.out::println);

        // 2. написать метод, который принимает на вход экземпляр типа Fruit
        // и возвращает true, если передан не null, количество фруктов (getCount) больше 5,
        // а стоимость не больше 100 (getPrice)
        // Вместо обычных проверок использовать тип Optional и подходящие методы
        boolean isFruit01NULL = optionalFruit02(fruit01.get());

        // 3. написать метод, который принимает на вход экземпляр типа Fruit
        // и возвращает
        // название фрукта (FruitType.getName()) в Optional контейнере, если тип фрукта определен,
        // и Optional контейнер с null ссылкой, если тип фрукта == null
        // Вместо обычных проверок использовать тип Optional и подходящие методы
        Optional<String> string01 = optionalFruit03(fruit01.get());
        System.out.println(string01.orElse("Неизвестный тип фрукта"));
    }
}
