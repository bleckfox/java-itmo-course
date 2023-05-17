package homeWork13;

public class Task {
    public static void main(String[] args) {
        // Создать экземпляр `PairContainer`,
        //      где key - любые числа, value - строка
        PairContainer<Integer, String> container1 = new PairContainer<>(3, "Steps");

        System.out.println("For step 1:");
        System.out.println("Key: " + container1.getKey() + ", Value: " + container1.getValue());


        // Создать экземпляр `PairContainer`,
        //      где key - строка,
        //      value - тип User, у которого id - любые числа
        User user = new User(45);
        PairContainer<String, User> container2 = new PairContainer<>("User 1", user);

        System.out.println("For step 2:");
        System.out.println("Key: " + container2.getKey() + ", Value: User(id=" + container2.getValue().getId() + ")");


        // Создать экземпляр `PairContainer`,
        //      где key - строка,
        //      value - тип PairContainer, у которого
        //          key - любые числа,
        //          value - тип User, у которого id - строка
        User user2 = new User(52);
        PairContainer<Integer, User> nestedContainer = new PairContainer<>(2, user2);
        PairContainer<String, PairContainer<Integer, User>> container3 = new PairContainer<>("User 2", nestedContainer);

        System.out.println("For step 3:");
        System.out.println("Key: " + container3.getKey() +
                ", Value: Nested Container(Key=" + container3.getValue().getKey() +
                ", Value=User(id=" + container3.getValue().getValue().getId() + "))");


        // Часть 2 (ответ был найден в файле Task02 урока 13.
        // Он был более точным. Я сразу не учел Runnable и Serializable
        /*
            public static <T extends Cat & Eatable> void void01(T object) {
                // ВОПРОС: методы каких типов можно вызвать у object ???
                // ОТВЕТ: методы Cat и Eatable + их супертипов, т.е.
                // Cat,
                // Eatable,
                // Animal (родитель Cat),
                // Object (родитель Cat),
                // Runnable (т.к. Animal implements Runnable),
                // Serializable (т.к. Eatable extends Serializable).
            }

            public static <T extends Animal & Serializable> void void02(T object) {
                // ВОПРОС: методы каких типов можно вызвать у object ???
                // ОТВЕТ: методы Animal и Serializable + их супертипов, т.е.
                // Animal,
                // Serializable
                // Object (родитель Animal),
                // Runnable (т.к. Animal implements Runnable)
            }

            public static <T extends Serializable & Runnable> void void03(T object) {
                // ВОПРОС: методы каких типов можно вызвать у object ???
                // ОТВЕТ:
                // Serializable,
                // Runnable,
                // Object
            }

            public static void main(String[] args) {

                // можно использовать типы, которы одновременно и Cat, и Eatable (Cat & Eatable)
                Task02.<Cat>void01(new Cat());
                Task02.<Cat>void01( new Kitten());
                Task02.<Kitten>void01(new Kitten());

                // можно использовать типы, которы одновременно и Animal, и Serializable (Animal & Serializable)
                Task02.<Cat>void02(new Cat());
                Task02.<Cat>void02(new Kitten());
                Task02.<Dog>void02(new Dog());
                Task02.<Kitten>void02(new Kitten());

                // можно использовать типы, которы одновременно и Runnable, и Serializable (Serializable & Runnable)
                Task02.<Dog>void03(new Dog());
            }
         */

    }
}
