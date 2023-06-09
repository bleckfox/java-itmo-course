package questions.questions2;

public class Questions2 {
    public static void main(String[] args) {
        // Строки ----------------------------------------------------------------------------------
        // 1. Относятся ли строки к примитивным типам данных?
        /*
            Строки не относятся к примитивным типам данных. Строка это массив char
            Char - примитивный тип данных, текстовые символы
         */

        // 2. Где находится пул строк?
        /*
            Пул строк хранится в heap и для пула строк можно использовать всю память приложения
         */

        // 3. Как строка может быть помещена в пул строк?
        /*
            Строка может быть помещена в пул строк с помощью метода intern().
            Метод intern() является частью класса String и используется для добавления
            строки в пул строк и возвращения ссылки на объект из пула.

            Строка, созданная как строковый литерал, например String str1 = "TopJava";
            тоже помещается в пул строк
         */

        // 4. Что такое "компактные строки"?
        /*
            Строка символы которой могут быть представлены с использованием
            одного байта – в LATIN-1, для хранения таких строк будет использоваться
             байтовый массив.
             Но, если какой-либо символ требует более 8 бит для своего представления,
             то каждый символы сроки будет занимать два байта (UTF-16).
         */

        // 5. Удаляет ли метод intern строку из кучи?
        /*
            Нет, метод добавляет строку в пул.
         */

        // 6. Перечислите способы сравнения строк
        /*
            1. Оператор == сравнивает ссылки на объекты. При использовании с строками,
                он проверяет, ссылаются ли обе переменные на один и тот же объект в памяти.
            2. Метод equals() сравнивает содержимое строк и возвращает true, если они
                имеют одинаковое содержимое.
                Это наиболее распространенный способ сравнения строк на равенство.
            3. Метод equalsIgnoreCase() сравнивает содержимое строк без учета
                регистра символов. Он возвращает true, если строки имеют одинаковое с
                одержимое, игнорируя различия в регистре символов.
            4. Метод compareTo() используется для сравнения строк лексикографически.
                Он возвращает отрицательное число, ноль или положительное число в
                зависимости от того, является ли текущая строка меньшей, равной или большей,
                чем переданная строка.
            5. Методы startsWith() и endsWith() проверяют, начинается ли или
                заканчивается ли строка соответственно с указанной подстрокой.
                Они возвращают true, если условие выполняется, и false в противном случае.
         */

        // 7. Как проверить строку на палиндром?
        /*
            Чтобы проверить, является ли число палиндромом, нужно сравнивать попарно символ
            с обоих концов слова. То есть сравнить первый и последний,
            потом второй и предпоследний, и так далее, двигаясь к центру слова.

            В Java, например, можно использовать метод reverse() для класса StringBuilder
            в случае, когда строка создается с помощью конструктора этого класса.
            Таким образом получается перевернутая строка, и можно провести сравнение
            исходной строки с перевернутой.
         */

        // 8. Для чего нужны классы StringBuilder и StringBuffer?
        /*
            В Java классы StringBuilder и StringBuffer используются для работы с изменяемыми
            строками. Они предоставляют удобные методы для изменения содержимого строки,
            таких как добавление, удаление, замена символов и других операций.

            Основное назначение классов StringBuilder и StringBuffer заключается в
            эффективном построении строк, особенно когда требуется множество операций
            изменения содержимого. В отличие от класса String, который представляет
            неизменяемую строку, объекты StringBuilder и StringBuffer можно модифицировать
            без создания новых экземпляров, что делает их более эффективными при работе
            с динамически изменяющимися строками.

            Основные различия между StringBuilder и StringBuffer заключаются в их поведении
            при многопоточном доступе. StringBuilder является потоконебезопасным
            (non-thread-safe) классом, тогда как StringBuffer является
            потокобезопасным (thread-safe) классом. Это означает, что StringBuffer может
            использоваться в многопоточных средах без необходимости принимать дополнительные
            меры синхронизации, в то время как StringBuilder не является безопасным для
            использования в многопоточных сценариях.

            Оба класса обладают похожими методами, позволяющими изменять содержимое строки,
            такими как append(), insert(), delete(), replace() и другими.
            Они также предоставляют методы для получения и изменения длины строки,
            получения подстроки и преобразования строки в массив символов.
         */

        // 9. Перечислите способы конкатенации строк
        /*
            1. Оператор "+" или "+="
            2. Использование метода concat() или join() класса String
            3. Использование метода append() класса StringBuilder или StringBuffer

            Оператор "+" или "+=" и concat() создают новую строку.
         */

        // 10. Строка вида "Привет" + " мир " + "!" высчитывается на этапе компиляции или
            // во время выполнения программы?
        /*
            Во время выполнения программы.
         */

        // 11. Есть ли ошибка в следующем коде? Если есть, то какая?
        // String someText = значение приходит из другой программы;
        // if (someText.startsWith("Java") && someText != null) System.out.println("Речь пойдет о Java");
        /*
            Логичнее проверку на null делать первой, тем более в связке с оператором &&
         */

        // 12. Что будет выведено в консоль (подумайте сами, не запуская программу)?
        // boolean String = false;
        // System.out.println(String);
        /*
            В консоль будет выведено false. Потому что имя переменной соответствует соглашению
            о названии переменных, и стоит после объявления типа
         */

        // 13. Что будет выведено в консоль (подумайте сами, не запуская программу)?
        // String text = "300 р., 4100 р., 911 р., 6500 р.,";
        // String[] prices = text.split("р.,");
        // System.out.println(Arrays.toString(prices));
        /*
            Список чисел (с сохранением пробела).
         */

        // 14. Сколько объектов строк мы получим в программе?
        // System.out.println("Строка" + new String("Строка"));
        // String str01 = "Строка";
        // String str02 = "строка";
        // String str03 = new String("Строка");
        /*
            Т.к. создание через конструктор помещает строку в пул, получим 3 объекта
            а в str01 и str03 = ссылки
         */

        // 15. Как узнать количество слов в строке?
        /*
            Например, можно воспользоваться методом split() для строки, и указать аргументом
            пробельный символ. Затем посчитать количество элементов в полученном списке.
         */

        // 16. Как узнать количество символов в строке?
        /*
            Можно использовать метод length для строки. Учитываются и специальные символы.
         */


        // Массивы ----------------------------------------------------------------------------------
        // 1. Является ли массив ссылочным типом?
        /*
            Массивы являются ссылочным типом данных
         */

        // 2. Можно ли хранить в массиве разные типы данных?
        /*
            Согласно общим рекомендация, следует хранить в одном массиве данные одного типа,
            чтобы избежать неопределенности при выполнении программы.

            Теоретически можно создать массив Object и помещать в такой массив разные типы данных,
            т.к. они наследуются от Object
         */

        // 3. Как добавить новый элемент в массив?
        /*
            Можно использовать запись вида array[index] = новое_значение
            Т.е записать элемент по определенному индексу.

            Для класса Arrays или List есть метод add(), который также добавляет новый элемент.
         */

        // 4. Как сравнить массивы?
        /*
            1. Использование метода equals() класса Arrays
            2. Использование метода deepEquals() класса Arrays для сравнения многомерных массивов
            3. Сравнение по индексам в цикле
            4. Есть также сравнение ссылок на массивы с помощью оператора ==

            В каждом случае массивы должны быть одинакового типа и иметь одинаковую длину
         */

        // 5. Как осуществляет поиск метод Arrays.binarySearch?
        /*
            Используется алгоритм бинарного поиска. Берется средний элемент массивы и
            производится сравнение, если искомый элемент больше среднего, происходит смещение
            левой границы и среднего элемента массива.
         */

        // 6. Как сортирует метод Arrays.sort?
        /*
            Метод Arrays.sort() в Java использует алгоритм сортировки под названием "TimSort".
            Этот алгоритм является комбинацией сортировки вставками и сортировки слиянием.
            Он оптимизирован для эффективной сортировки массивов различных размеров и типов данных.

            Метод Arrays.sort() позволяет сортировать массивы различных примитивных типов
            данных (таких как int, long, double, и т.д.), а также объекты, реализующие
            интерфейс Comparable или использующие компаратор (Comparator) для определения
            порядка сортировки.
         */

        // 7. Почему следующий код приведет к ошибке?
        // int[] ints = {34, 78};
        // ints.length = 10;
            // массив имеет фиксированную длину, которму можно получить с помощью
            // переменной length. Присвоение значений этой переменной недопустимы

        // 8. Может ли длина массива быть равной 0?
        /*
            Да, может
         */

        // 9. Что будет выведено в консоль (подумайте сами, не запуская программу)?
        // String[] ints = {"7", "34","346", "15", "0"};
        // Arrays.sort(ints);
        // System.out.println(Arrays.toString(ints));

            // Т.к происходит сравнение строк, то берется первый символ для сравнения
            // если есть одинаковые элементы с первым символом, то берется второй для них и т.д.
            // в результате получим 0, 15, 34, 346, 7

        // 10. Найти сумму значений элементов массива
        int[][] ints = {{1, 4, 7}, {22, 88, 89, 76},};

        int arraySum = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                arraySum += ints[i][j];
            }
            System.out.printf("Сумма элементов %d массива = %d \n", i + 1, arraySum);
        }

        // 11. На каких итерация программа выведет true, а на каких false
        // (подумайте сами, не запуская программу)? Почему?
        String[] cats = {"Мурка", new String("Васька"), "Гоша", "Васька", "Рыжик"};
        for (String cat : cats) {
            System.out.println(cat == "Васька");
        }
        // происходит сравнение ссылок
    }
}
