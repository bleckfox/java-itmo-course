package courseWorks.courseWork3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Helper {
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 2222;
    private static final int FILE_NAME_LENGTH = 15;
    private static final int FILE_EXTENSTION_LENGTH = 4;

    private static final String FILE_STORAGE = "D:\\Code\\java\\java-itmo-course\\src\\courseWorks\\courseWork3\\FileStorage\\";

    public static String getServerHost(){
        return SERVER_HOST;
    }

    public static int getServerPort(){
        return SERVER_PORT;
    }

    public static String getStorageFolder(){
        return FILE_STORAGE;
    }

    public static String getFileName(boolean folder, boolean isSending){

        boolean isFileNameCorrect = false;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String fileName = "";
        String helpText = folder
                ? "Введите полный путь до папки. Например, C:\\path\\to\\ \n"
                : isSending
                    ? "Введите полный путь до файла. Например, C:\\path\\to\\file.txt\n"
                    : "Введите название файла. Например, название.txt\n";

        while (!isFileNameCorrect) {
            System.out.println(helpText + "За справкой по формату файла введите stop, а затем help или -h");

            input = scanner.nextLine().trim();

            if (input.length() > 0){

                if (input.equalsIgnoreCase("stop")){
                    return null;
                }


                if (folder || isSending){
                    File file = new File(input);
                    if (file.exists()) {
                        fileName = file.getName();
                    } else {
                        System.out.println("Файл или папка не найдены!");
                        continue;
                    }
                }

                // Если нужна только папка
                if (folder) return input;

                // Выполняется отправка файла
                if (isSending){
                    // Проверяем, что файл удовлетворяет условиям
                    if (fileName.length() > (FILE_NAME_LENGTH + FILE_EXTENSTION_LENGTH)){
                        System.out.println("Ошибка: Название файла превышает 15 символов.");
                        continue;
                    } else if (!fileName.endsWith(".txt")){
                        System.out.println("Ошибка: Недопустимое расширение файла. Разрешено только .txt");
                        continue;
                    }

                    isFileNameCorrect = true;
                } else {
                    return input;
                }

            }

        }
        // Возвращаем полный путь к файлу
        return input;
    }

    public static void uploadFile(String folder, String fileName, byte[] fileData){
        Path fileStorage = Paths.get(folder, fileName);

        try {
            Files.write(fileStorage, fileData);
//            FileOutputStream outputStream = new FileOutputStream(fileStorage);
//            outputStream.write(fileData);
//            outputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла '" + fileName + "' на сервере: " + e.getMessage());
        }
    }

    public static byte[] readFileData(File file, int bufferSize){
        try {

            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer, 0, bufferSize)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            return outputStream.toByteArray();

        } catch (IOException e){
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }
}
