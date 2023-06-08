package courseWorks.courseWork2.newVersion_08062023;

import com.google.gson.*;
import courseWorks.courseWork2.newVersion_08062023.Commands.DisplayCommand;
import courseWorks.courseWork2.newVersion_08062023.Commands.ExitGameCommand;
import courseWorks.courseWork2.newVersion_08062023.Commands.SaveGameCommand;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    public static Map<Integer, Paragraph> paragraphs = new HashMap<>();
    private static Game game;
    private int currentStep = 1;

    public Game(){
        loadGameFromFile();
    }

    public static Game getInstance(){
        if (game == null){
            game = new Game();
            loadGameFromFile();
        }
        return game;
    }

    /**
     * Метод запуска игры
     */
    public void start(){
        Scanner scanner = new Scanner(System.in);
        DisplayCommand displayCommand = new DisplayCommand();

        while (true){
            Paragraph paragraph = paragraphs.get(currentStep);
            if (paragraph == null) {
                System.out.println("Конец игры, до скорого!");
                break;
            }

            // Устанавливаю ссылки на различные параграфы
            displayCommand.setParagraph(paragraph).execute();

            if (!paragraph.getOptions().isEmpty()){
                int optionNumber = scanner.nextInt();

                if (optionNumber == 0) {
                    showMenu();
                    continue;
                }

                paragraph = paragraph.getNextStep(optionNumber);
                if (paragraph != null){
                    currentStep = paragraph.getNumber();
                } else {
                    System.out.println("Некорректный выбор варианта. Попробуйте снова.");
                }
            }
            else {
                break;
            }
//            else {
//                currentStep++;
//            }
        }
    }

    /**
     * Метод сохранения игры в json файл
     */
    public void save(String login, int loginIndex){
        try (FileReader reader = new FileReader(Helper.SAVE_FILE_PATH)) {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);

            // Получение массива сессий
            JsonArray sessionsArray = jsonObject.getAsJsonArray("sessions");

            // Если не существует, запишем
            if (loginIndex < 0){
                // Создание новой сессии
                JsonObject newSession = new JsonObject();
                newSession.addProperty("login", login);
                newSession.addProperty("currentStep", currentStep);

                // Добавление новой сессии в массив sessions
                sessionsArray.add(newSession);
            }
            // иначе получим логин и перезапишем
            else {
                JsonObject sessionObject = sessionsArray.get(loginIndex).getAsJsonObject();
                sessionObject.addProperty("currentStep", currentStep);
            }

            try (FileWriter writer = new FileWriter(Helper.SAVE_FILE_PATH)){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, writer);
            }
            System.out.println("Игра успешно сохранена!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод сохранения игры в json файл
     */
//    public void save(){
//        try (FileWriter writer = new FileWriter(SAVE_FILE_PATH)){
//            Gson gson = new Gson();
//            JsonArray jsonArray = new JsonArray();
//
//            paragraphs.forEach(
//                    (key, value) -> {
//                        JsonObject jsonObject = new JsonObject();
//
//                        // вместо paragraph можно прямо использовать value
//                        // но использую paragraph для удобного чтения и понимания какой тип в value
//                        Paragraph paragraph = value;
//                        jsonObject.addProperty("number", paragraph.getNumber());
//                        jsonObject.addProperty("title", paragraph.getTitle());
//                        jsonObject.addProperty("description", paragraph.getDescription());
//
//                        JsonObject optionsJson = new JsonObject();
//
//                        paragraph.getOptions().forEach(
//                                (pKey, pValue) -> {
//                                    // используется для наглядного представления типа в pValue
//                                    Paragraph.Option option = pValue;
//
//                                    JsonObject optionJson = new JsonObject();
//
//                                    optionJson.addProperty("text", option.getText());
//                                    optionJson.addProperty("nextStep", option.getNextStep());
//                                    optionJson.add(pKey.toString(), optionsJson);
//                                }
//                        );
//
//                        jsonObject.add("options", optionsJson);
//                        jsonArray.add(jsonObject);
//
//                    }
//            );
//
//            gson.toJson(jsonArray, writer);
//            System.out.println("Игра успешно сохранена!");
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    /**
     * Метод загрузки игры
     */
    public void load(int loginIndex){
        try (FileReader reader = new FileReader(Helper.SAVE_FILE_PATH)){
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(reader);

            JsonArray sessionsArray = jsonObject.getAsJsonArray("sessions");

            JsonObject sessionObject = sessionsArray.get(loginIndex).getAsJsonObject();
            this.currentStep = sessionObject.get("currentStep").getAsInt();

            // Запуск игры
            start();

            System.out.println("Игра загружена!\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод загрузки игры
     */
//    public void load(){
//        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE_PATH))){
//            Gson gson = new Gson();
//            JsonParser parser = new JsonParser();
//            JsonArray jsonArray = parser.parse(reader).getAsJsonArray();
//
//            paragraphs.clear();
//
//            jsonArray.forEach(
//                    jsonElement -> {
//                        JsonObject jsonObject = jsonElement.getAsJsonObject();
//                        int number = jsonObject.get("number").getAsInt();
//                        String title = jsonObject.get("title").getAsString();
//                        String description = jsonObject.get("description").getAsString();
//
//                        Paragraph paragraph = new Paragraph();
//                        paragraph.setNumber(number);
//                        paragraph.setTitle(title);
//                        paragraph.setDescription(description);
//
//                        JsonObject optionsJson = jsonObject.getAsJsonObject("options");
//
//                        if (optionsJson != null){
//                            Map<Integer, Paragraph.Option> options = new HashMap<>();
//                            for (Map.Entry<String, JsonElement> entry : optionsJson.entrySet()) {
//                                int optionNumber = Integer.parseInt(entry.getKey());
//                                JsonObject optionJson = entry.getValue().getAsJsonObject();
//                                String text = optionJson.get("text").getAsString();
//                                int nextStep = optionJson.get("nextStep").getAsInt();
//
//                                Paragraph.Option option = new Paragraph.Option();
//                                option.setText(text);
//                                option.setNextStep(nextStep);
//
//                                options.put(optionNumber, option);
//                            }
//                            paragraph.setOptions(options);
//                        }
//
//                        paragraphs.put(number, paragraph);
//                    }
//            );
//            System.out.println("Игра загружена из файла!");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Метод загрузки новой игры
     */
    private static void loadGameFromFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(Helper.GAME_FILE_PATH))) {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);

            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.get("steps").getAsJsonArray();
            paragraphs.clear();

            for (JsonElement element : jsonArray) {
                JsonObject paragraphJson = element.getAsJsonObject();

                int number = paragraphJson.get("number").getAsInt();
                String title = paragraphJson.get("title").getAsString();
                String description = paragraphJson.get("description").getAsString();

                Paragraph paragraph = new Paragraph();
                paragraph.setNumber(number);
                paragraph.setTitle(title);
                paragraph.setDescription(description);

                JsonObject optionsJson = paragraphJson.getAsJsonObject("options");
                if (optionsJson != null) {
                    Map<Integer, Paragraph.Option> options = new HashMap<>();
                    for (Map.Entry<String, JsonElement> entry : optionsJson.entrySet()) {
                        int optionNumber = Integer.parseInt(entry.getKey());
                        JsonObject optionJson = entry.getValue().getAsJsonObject();
                        String text = optionJson.get("text").getAsString();
                        int nextStep = optionJson.get("nextStep").getAsInt();

                        Paragraph.Option option = new Paragraph.Option();
                        option.setText(text);
                        option.setNextStep(nextStep);

                        options.put(optionNumber, option);
                    }
                    paragraph.setOptions(options);
                }

                paragraphs.put(number, paragraph);
            }

            System.out.println("Новая игра загружена!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод показа меню во время игры
     */
    private void showMenu(){
        System.out.println("МЕНЮ:");
        System.out.println("1. Продолжить игру");
        System.out.println("2. Сохранить игру");
        System.out.println("3. Начать новую игру");
        System.out.println("4. Выход");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                new SaveGameCommand(this).execute();
                break;
            case 3:
                Game adventureGame = Game.getInstance();
                adventureGame.start();
                return;
            case 4:
                new ExitGameCommand().execute();
                break;
            default:
                System.out.println("Некорректный выбор. Продолжение игры...");
        }
    }
}
