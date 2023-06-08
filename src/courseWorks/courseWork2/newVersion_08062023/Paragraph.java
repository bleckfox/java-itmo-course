package courseWorks.courseWork2.newVersion_08062023;

import java.util.Map;

public class Paragraph {
    private String title;
    private int number;
    private String description;
    private Map<Integer, Option> options;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Integer, Option> getOptions() {
        return this.options;
    }

    public void setOptions(Map<Integer, Option> options) {
        this.options = options;
    }

    static class Option{
        private String text;
        private int nextStep;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getNextStep() {
            return nextStep;
        }

        public void setNextStep(int nextStep) {
            this.nextStep = nextStep;
        }
    }

    /**
     * Метод для получения следующего шага по выбранному варианту ответа
     * @param optionNumber Выбранный вариант
     * @return Следующий шаг
     */
    public Paragraph getNextStep(int optionNumber){
        Option option = options.get(optionNumber);
        if (option != null){
            int nextStepNumber = option.getNextStep();
            return Game.paragraphs.get(nextStepNumber);
        }

        return null;
    }

    /**
     * Метод для отображения текста шага
     */
    public void display(){
        System.out.println("\n" + title);
        System.out.println(description);

        if (!options.isEmpty()){
            System.out.println("Выберите вариант ответа:");
            System.out.println("Для выхода в меню: 0");
//            options.entrySet().stream().forEach(option -> {
//                System.out.println(option.getKey() + ". " + option.getValue());
//            });
//            options.entrySet().forEach(option -> {
//                System.out.println(option.getKey() + ". " + option.getValue());
//            });
            options.forEach(
                    (key, value) -> System.out.println(key + ". " + value.getText())
            );
        }
    }
}
