package homeWorks.homeWork14.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Message {
    private int code;
    private MessagePriority priority;

    public Message(int code, MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" +
                "Message { " +
                "code = " + code + ", " +
                "priority = " + priority + " }";
    }

    public static List<Message> generate(int num) {
        if (num <= 0) {
            return Collections.emptyList();
        }

        Random random = new Random();
        List<Message> messages = new ArrayList<>(num);

        int typesCount = MessagePriority.values().length;

        for (int i = 0; i < num; i++) {
            messages.add(new Message(random.nextInt(10), MessagePriority.getPriority(random.nextInt(typesCount))));
        }

        return messages;
    }
}
