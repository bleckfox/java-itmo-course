package homeWorks.homeWork20.task4;

public class Task04 {
    public static void main(String[] args) {
        // Объекты FileStorage хранят имена файлов, имена файлов не должны дублироваться.
        // Правила валидации могут быть разными, но должна быть возможность их объединять.
        // При создании экземпляра FileStorage передается ссылка на правила валидации
        //      (одно или несколько, собранных в цепочку).
        // Должна быть возможность изменить правила валидации.
        // Перед добавлением в FileStorage, имя файла должно проходить проверку согласно
        //      установленным ранее правилам.
        // Если имя не прошло проверку, оно не добавляется в хранилище

        // FileStorage storage = new FileStorage(правило01.andRule(правило02.orRule(правило03))
        //      .andRule(правило04));
        // if (storage.addFile(filename)) System.out.println("Файл добавлен");
        // имя файла будет добавлено, если оно прошло проверку:
        // правилом01 + правилом02 или правилом03 + правилом04

        // Можно написать свой функциональный интерфейс, чтобы закрепить синтаксис,
        // или использовать подходящий из пакета java.util.function и разобраться с его методами

        FileStorage storage = new FileStorage();

        ValidationRule rule01 = filename -> filename.length() <= 10;
        ValidationRule rule02 = filename -> filename.endsWith(".txt");
        ValidationRule rule03 = filename -> filename.contains("test");

        storage
                .addValidationRule(rule01)
                .addValidationRule(rule02)
                .addValidationRule(rule03);

        String filename1 = "example.txt";
        String filename2 = "important_document.txt";
        String filename3 = "test.txt";

        if (storage.addFile(filename1)) {
            System.out.println("Файл " + filename1 + " добавлен");
        } else {
            System.out.println("Файл " + filename1 + " не прошел проверку");
        }

        if (storage.addFile(filename2)) {
            System.out.println("Файл " + filename2 + " добавлен");
        } else {
            System.out.println("Файл " + filename2 + " не прошел проверку");
        }

        if (storage.addFile(filename3)) {
            System.out.println("Файл " + filename3 + " добавлен");
        } else {
            System.out.println("Файл " + filename3 + " не прошел проверку");
        }
    }
}
