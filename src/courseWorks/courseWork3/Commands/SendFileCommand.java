package courseWorks.courseWork3.Commands;

import courseWorks.courseWork3.Helper;

import java.io.*;

public class SendFileCommand implements ICommand {

    private String filePath;

    private final int BUFFER_SIZE = 256;

    public SendFileCommand(String input){
        filePath = input;
    }

    @Override
    public void execute(){
        // Проверка существования файла в классе Helper, которые вызывается перед отправкой
        // На момент вызова гарантируется, что файл существует
        // (разве что пользователь самый быстрый на диком западе и удалит быстрее)
        File fileToSend = new File(filePath);

        byte[] fileData = Helper.readFileData(fileToSend, BUFFER_SIZE);

        if (fileData != null){
            Helper.uploadFile(Helper.getStorageFolder(), fileToSend.getName(), fileData);
            System.out.println("Файл успешно отправлен на сервер: " + fileToSend.getName());
        } else {
            System.out.println("Ошибка чтения файла: " + fileToSend.getName());
        }
    }
}
