package homeWorks.homeWork20.task4;

import java.util.ArrayList;
import java.util.HashSet;

public class FileStorage {
    private ArrayList<ValidationRule> validationRules;

    private HashSet<String> filenames;

    public FileStorage() {
        this.validationRules = new ArrayList<>();
        this.filenames = new HashSet<>();
    }

    public FileStorage addValidationRule(ValidationRule rule) {
        validationRules.add(rule);
        return this;
    }

    public boolean addFile(String filename) {
        // Проверяем имя файла согласно установленным правилам
        for (ValidationRule rule : validationRules) {
            if (!rule.isValid(filename)) {
                return false; // Имя файла не прошло проверку
            }
        }

        // Имя файла прошло все проверки, добавляем его в хранилище
        // your code to add the file to the storage
        this.filenames.add(filename);

        return true; // Имя файла добавлено успешно
    }
}

//public class FileStorage {
//    private HashSet<String> filenames;
//    private Predicate<String> validationRules;
//
//    public FileStorage(Predicate<String> validationRules){
//        this.filenames = new HashSet<>();
//        setValidationRules(validationRules);
//    }
//
//    public void setValidationRules(Predicate<String> validationRules) {
//        this.validationRules = validationRules;
//    }
//
//    public boolean addFileName(String filename){
//        if (this.validationRules.test(filename)){
//            return this.filenames.add(filename);
//        }
//        return false;
//    }
//}
