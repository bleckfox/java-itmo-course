package courseWorks.courseWork3.Commands;

import courseWorks.courseWork3.Helper;

import java.io.File;
import java.util.Arrays;

public class GetFilesCommand implements ICommand {
    @Override
    public void execute(){
        File folder = new File(Helper.getStorageFolder());

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("В папке нет файлов.");
        } else {
            System.out.println("Список файлов в папке:");
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) System.out.println(file.getName());
            });
//            for (File file : files) {
//                if (file.isFile()) {
//                    System.out.println(file.getName());
//                }
//            }
        }
    }
}
