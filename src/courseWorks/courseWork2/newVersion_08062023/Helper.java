package courseWorks.courseWork2.newVersion_08062023;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class Helper {
    public static final String SAVE_FILE_PATH = "D:\\Code\\java\\java-itmo-course\\src\\courseWorks\\courseWork2\\saved_games.json";
    public static final String GAME_FILE_PATH = "D:\\Code\\java\\java-itmo-course\\src\\courseWorks\\courseWork2\\paragraphs.json";

    public static int getLoginIfExist(String login, boolean isLoadingCommand){
        try (FileReader fileReader = new FileReader(SAVE_FILE_PATH)) {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(fileReader);

            JsonArray sessionsArray = jsonObject.getAsJsonArray("sessions");

            for (int i = 0; i < sessionsArray.size(); i++) {
                JsonObject sessionObject = sessionsArray.get(i).getAsJsonObject();
                String existingLogin = sessionObject.get("login").getAsString();

                if (existingLogin.equals(login)) {
                    return i; // Логин существует, возвращаем индекс
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (isLoadingCommand) System.out.println("Логин не найден. Пожалуйста, введите корректный логин.");

        return -1; // Логин не найден
    }

    public static int getCurrentStep(int loginIndex){

        try (FileReader reader = new FileReader(Helper.SAVE_FILE_PATH)){
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(reader);

            JsonArray sessionsArray = jsonObject.getAsJsonArray("sessions");

            JsonObject sessionObject = sessionsArray.get(loginIndex).getAsJsonObject();

            return sessionObject.get("currentStep").getAsInt();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return -1;
    }

    public static String getLogin(int loginIndex){

        try (FileReader reader = new FileReader(Helper.SAVE_FILE_PATH)){
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(reader);

            JsonArray sessionsArray = jsonObject.getAsJsonArray("sessions");

            JsonObject sessionObject = sessionsArray.get(loginIndex).getAsJsonObject();

            return sessionObject.get("login").getAsString();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return "new_login_" + LocalDateTime.now();
    }
}
