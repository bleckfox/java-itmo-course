package homeWorks.homeWork20.task4;

@FunctionalInterface
public interface ValidationRule {
    boolean isValid(String filename);
}