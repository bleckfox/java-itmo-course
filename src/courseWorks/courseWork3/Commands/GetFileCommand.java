package courseWorks.courseWork3.Commands;

import courseWorks.courseWork3.Helper;

import java.io.File;
import java.nio.file.Paths;

public class GetFileCommand implements ICommand {

    private String fileName;
    private String folder;
    private final int BUFFER_SIZE = 256;

    public GetFileCommand(String folder, String fileName){
        this.fileName = fileName;
        this.folder = folder;
    }

    @Override
    public void execute(){
        // Проверка существования файла в классе Helper, которые вызывается перед отправкой
        // На момент вызова гарантируется, что файл существует
        // (разве что пользователь самый быстрый на диком западе и удалит быстрее)

        // Получаем файл из хранилища
        File fileToSend = new File(Helper.getStorageFolder() + fileName);

        byte[] fileData = Helper.readFileData(fileToSend, BUFFER_SIZE);

        if (fileData != null){
            Helper.uploadFile(folder, fileName, fileData);
            System.out.println("Файл успешно сохранен: " + fileToSend.getName() + " -> " + Paths.get(folder, fileName));
        } else {
            System.out.println("Ошибка сохранения файла: " + fileToSend.getName());
        }

    }
}
