### Задание 1

1. Объявить класс `PairContainer` со свойствами `key` и `value`. `key` и `value` - generic свойства без ограничений, но
   могут быть разных типов.
2. Создать экземпляр `PairContainer`, где key - любые числа, value - строка
3. Создать экземпляр `PairContainer`, где key - строка, value - тип User, у которого id - любые числа
4. Создать экземпляр `PairContainer`, где key - строка, value - тип PairContainer, у которого key - любые числа,
   value - тип User, у которого id - строка

### Задание 2

      interface Eatable extends Serializable{}
      interface Runnable {}

      class Animal implements Runnable{}

      class Cat extends Animal implements Eatable{}
      class Kitten extends Cat{}

      class Dog extends Animal implements Serializable{}


      class Task {
         public static  <T extends Cat & Eatable> void void01(T object){
             // ВОПРОС: методы каких типов можно вызвать у object ???
         }

         public static  <T extends Animal & Serializable> void void02(T object){
            // ВОПРОС: методы каких типов можно вызвать у object ???
         }

         public static  <T extends Serializable & Runnable> void void03(T object){
            // ВОПРОС: методы каких типов можно вызвать у object ???
         }

         public static void main(String[] args) {
            Task.</* ВОПРОС: какие типы можно указать ??? */>void01(/* ВОПРОС: какие типы можно передать ??? */);
            Task.</* ВОПРОС: какие типы можно указать ??? */>void02(/* ВОПРОС: какие типы можно передать ??? */);
            Task.<Dog>void03(/* ВОПРОС: какие типы можно передать ??? */);
         }
      }

