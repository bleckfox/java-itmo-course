## Задания на методы строк

1. Считывать с консоли строки до тех пор, пока пользователь не введёт "exit". Каждую полученную строку приводить к виду:
   первая
   заглавная, остальные маленькие и выводить в консоль. Пробелов в начале и
   конце строки быть не должно.
2. **Дан текст**: _JAVA стоит первым в рейтинге популярности использования языков; JAVA один из наиболее мощных
   высокоуровневых языков программирования; JAVA поддерживает большое количество встроенных библиотех, которые позволяют
   быстро писать проекты любого класса сложности; курс «JUNIOR JAVA DEVELOPER» предназначен для подготовки
   программистов-профессионалов, специализирующихся на разработке программного обеспечения различного класса и уровня
   сложности_. **Все слова "JAVA" в данном тексте заменить на "PYTHON"**.
3. Вывести в консоль количество слов "JAVA", встречающихся в тексте из предыдущего задания

## Задания на массивы

[Ссылка на класс Arrays в документации](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Arrays.html)

### Задача 1

Заполните массив на N элементов (размер массива вводит пользователь) случайным целыми числами и выведете максимальное,
минимальное и среднее арифметическое значение элементов массива

### Задача 2

Создайте массив из чётных чисел [2;20] (использовать Math.random()) и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)

### Задача 3

Задать массив на N слов. В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив (добавлять
новое слово в массив можно только, если в нем его еще нет). В итоге в массиве будут только уникальные слова.
Выход из программы по слову exit (слово 'exit' в массив не добавлять) или если массив заполнен. Перед завершением
программы, вывести получившийся массив в консоль

### Задача 4

Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.

Предложение для поска длинного слова: `"в предложении все слова разной длины"` (самостоятельно найти метод преобразования
строки в массив строк).

### Задача 5
Создать массив, наполнить его целыми числами (отрицательными и положительными). Отрицательные элементы массива скопировать в новый массив.

Размер массива должен быть равен количеству отрицательных элементов.