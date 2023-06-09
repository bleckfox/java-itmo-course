## Коллекции используются для хранения данных (вместо массивов).

При выборе конкретного типа коллекции следует учитывать:

* необходимость работы с коллекцией из разных потоков и соответственно потокобезопасность коллекции;
* необходимость в хранении элементов в определенном порядке: в порядке добавления, в отсортированном виде и т.д.;
* возможность/невозможность добавления дублирующихся элементов: одни коллекции разрешают дубли, другие нет.

### Все классы, описывающие коллекции, реализуют интерфейс Collection.

В интерфейсе `Collection` объявлены методы для работы с коллекциями. Данные методы реализованы в конкретных классах.

**Некоторые методы интерфейса Collection<E>**:

* `boolean add(E element)` - добавление элемента в коллекцию
* `boolean addAll(Collection<? extends E> collection)` - добавление элементов одной коллекции в другую
* `void clear()` - удаление элементов коллекции
* `boolean contains(Object element)` - вернет true, если элемент содержится в коллекции
* `boolean remove(Object element)` - удаление элемента из коллекции
* `int size()` - вернет количество элементов коллекции

Другие методы коллекций см. в документации.

***При изучении методов необходимо учитывать версию java и особенности их реализации в конкретных классах.*** Например,
метод `boolean add(E element)` реализован таким образом, что добавляет элемент в конец списка и возвращает true, но при
добавлении элемента в множество может вернуть false (множества не позволяют добавить дубли) и т.п. При этом расположение
элемента в множестве будет зависеть от конкретной реализации.

### Интерфейсы List, Queue/Deque, Set.

Каждый класс, представляющий собой коллекцию, реализует и другие интерфейсы, наследуются от абстрактных классов. В этих
интерфейсах могут быть объявлены дополнительные методы, которые реализованы в отдельных классах.

В связи с этим все **коллекции можно разделить три большие категории**:

1. **списки** (реализуют интерфейс List);
2. **множества** (реализуют интерфейс Set);
3. **очереди** (реализуют интерфейс Queue/Dequeue).

### Списки (реализуют интерфейс List):

1. В списках реализована возможность работы с индексами (нумерация начинается с 0, обращение к несуществующему индексу
   приводит в ошибке).
2. Списки позволяют хранить дублирующиеся элементы.
3. Порядок хранения элементов соответствует порядку добавления (метод add добавляет элемент в конец списка).
4. Позволяют хранить null.
5. Есть возможность создавать неизменяемые списки (методы List.of and List.copyOf).
6. Наиболее популярные **непотокобезопасные реализации**: класс `ArrayList` и класс `LinkedList`.

**Некоторые дополнительные методы списков**:

* `void add(int index, E element)` - добавление элемента на указанную позицию (остальные элементы сдвигаются)
* `E get(int index)` - возвращает элемент, расположенный по указанному индексу
* `E remove(int index)` - удаляет и возвращает элемент, расположенный по указанному индексу, из списка
* `E set(int index, E newElement)` - заменяет элемент, расположенный по указанному индексу, на новый (newElement)

Другие методы списков см. в документации.

### Множества (реализуют интерфейс Set):

1. Нет возможности работать с индексами.
2. Множества не позволяют добавлять дублирующиеся элементы.
3. Не все множества позволяют хранить null.
4. Порядок хранения элементов зависит от конкретной реализации.
5. Есть возможность создавать неизменяемые множества (методы Set.of and Set.copyOf).
6. Наиболее популярные **непотокобезопасные реализации**: класс `HashSet`, класс `LinkedHashSet` и класс `TreeSet`.

Методы множеств см. в документации.

### Очереди (реализуют интерфейс Queue / Deque):

1. Содержат дополнительные методы добавления, извлечения, удаления элементов.
2. Каждый из этих методов представлен в двух вариантах: выбрасывает исключение, если операция не удалась / возвращают
   специальное значение в случае неудачи (null, false).
3. Двунаправленные очереди (Deque) предоставляют возможность работать с концом и началом очереди (добавить первый
   элемент/последний элемент, удалить первый элемент/последний элемент и тп).
4. Наиболее популярные **непотокобезопасные реализации**: класс `LinkedList` и класс `ArrayDeque`.

Методы очередей см. в документации.

### Создание экземпляров коллекций

1. Все коллекции можно создать
    1) **пустыми** (использовать конструктор без параметров)
    2) **на основе элементов другой коллекции** (использовать конструктор, который принимает на вход другую коллекцию)
    3) некоторые классы обладают **дополнительными конструкторами** (например, ArrayList можно создать с указанием
       размера внутреннего массива, TreeSet
       можно создать с указанием порядка сортировки элементов и т.п.).
2. Все коллекции типизированы (generic), при создании экземпляра необходимо указывать, какой тип данных будет храниться
   в
   коллекции.
3. В коллекциях нельзя хранить примитивные типы данных.

### ArrayList (List)

* реализован на основе массива;
* элементы хранятся в массиве, когда место в массиве заканчивается, создается новый массив, куда перемещаются элементы
  из текущего и т.д.
* В документации нет указания на то, как увеличивается размер массива: по мере добавления элементов в список ArrayList
  его емкость автоматически увеличивается. Детали политики роста не указаны, т.к. могут меняться в зависимости от версии
  java (обычно, в 1.5 раза)

**Конструкторы**:

1. `ArrayList()` - создает пустой список (size == 0) с внутренним массивом на 10 элементов
2. `ArrayList(int capacity)` - создает пустой список (size == 0) с внутренним массивом на `capacity` элементов
3. `ArrayList(Collection<? extends E> collection)` - создает список с элементами другой коллекции

### LinkedList (List + Deque)

* реализован как двунаправленный список;
* LinkedList хранит ссылки только на первый и последний элемент;
* в свою очередь каждый элемент списка хранит ссылки на следующий и предыдущий элементы списка.

**Конструкторы**:

1. `LinkedList()` - создает пустой список
2. `LinkedList(Collection<? extends E> collection)` - создает список с элементами другой коллекции

***В большинстве случаев использование ArrayList предпочтительнее, чем LinkedList***

### HashSet (Set)

* хранит элементы в хеш таблице;
* расположение элемента определяется значением, которое возвращает метод hashCode;
* порядок хранения элементов может отличаться от порядка добавления элементов;
* позволяет добавить null, который всегда будет на первом месте.

**Конструкторы**:

1. `HashSet()` - создает пустое множество, емкость - 16, фактор загрузки - 0.75
2. `HashSet(int initialCapacity)` - создает пустое множество, емкость - initialCapacity, фактор загрузки - 0.75
3. `HashSet(int initialCapacity, float loadFactor)` - создает пустое множество, емкость - initialCapacity, фактор
   загрузки - loadFactor
4. `HashSet(Collection<? extends E> collection)` - создание множества с элементами другой коллекции, фактор загрузки -
   0.75

* **Фактор загрузки** - показатель того, на сколько заполненным может быть HashSet до того момента, когда его емкость
  автоматически увеличится.
* **Начальная емкость** - изначальное количество ячеек (корзин) в хэш-таблице.
* При добавлении элемента в хеш таблицу (массив) вычисляется индекс, по которому будет добавлен элемент. Вычисление
  происходит по следующей формуле `(ДОБАВЛЯЕМЫЙ_ЭЛЕМЕНТ.hashCode() & 0x7FFFFFFF) % ДЛИНА_МАССИВА`

### LinkedHashSet (Set)

* при переборе LinkedHashSet доступ к элементам осуществляется в порядке их добавления;
* хранит элементы в хеш таблице;
* расположение элемента определяется значением, которое возвращает метод hashCode;
* позволяет добавить null;
* медленнее, чем HashSet.

**Конструкторы**:

1. `LinkedHashSet()` - создает пустое множество, емкость - 16, фактор загрузки - 0.75
2. `LinkedHashSet(int initialCapacity)` - создает пустое множество, емкость - initialCapacity, фактор загрузки - 0.75
3. `LinkedHashSet(int initialCapacity, float loadFactor)`- создает пустое множество, емкость - initialCapacity, фактор
   загрузки loadFactor LinkedHashSet(Collection<? extends E> c) - создание множества с элементами другой коллекции,
   фактор загрузки - 0.75

### TreeSet (Set)

* добавление null приведет к ошибке;
* хранит элементы в отсортированном виде (используется алгоритм красно-черного бинарного дерева);
* для добавления элементов в TreeSet необходимо, (1) чтобы тип (класс), элементы которого будут храниться в TreeSet,
  реализовывал интерфейс Comparable и его метод compareTo или (2) использовать экземпляр класса Comparator, который
  передается в конструктор TreeSet

**Конструкторы**:

1. `TreeSet()` -создает пустое множество, с натуральным порядком сортировки. Сортировка осуществляется благодаря
   реализации метода `compare интерфейса Comparable`
2. `TreeSet(Collection<? extends E> collection)` - создает множество из элементов другой коллекции, с натуральным
   порядком сортировки. Сортировка осуществляется благодаря реализации метода `compare интерфейса Comparable`
3. `TreeSet(Comparator<? super E> comparator)` - создает пустое множество. Сортировка осуществляется благодаря
   экземпляру типа `Comparator`, который `передается в конструктор множества`
4. `TreeSet(SortedSet<E> set)` - создает множество из элементов другого отсортированного множества. Порядок сортировки в
   новом множестве соответствует порядку сортировки исходного множества.

### Перебор коллекций и удаление элементов в цикле

        for (ТипДанныхЭлементовКоллекции имяПеременной: перебираемаяКоллекция) {
            на каждой итерации переменная - ссылка к элементу коллекции
            попытка удаление элемента в цикле приведет к ConcurrentModificationException
        }

        Iterator<ТипДанныхЭлементовКоллекции> итератор = коллекция.iterator();
        while (итератор.hasNext()) {
            итератор.next() - ссылка на элемент коллекции
            итератор.remove() - удаляет элемент коллекции
        }

### Массивы и коллекции

1. Создание списка из элементов массива: `List<String> fromArray = Arrays.asList("blue", "yellow", "black", "white");`
2. Создание массива из коллекции:

        Object[] objects = fromArray.toArray(); // массив элементов типа Object
        String[] strings = fromArray.toArray(new String[0]);

### Дополнительные возможности по работе с коллекциями:

1. Класс `Collections` с набором статических методов
2. `Stream API` (начиная с java 8)