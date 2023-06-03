package homeWorks.homeWork14.task2;

import java.util.*;

public class Task2 {

    /**
     * Метод подсчета количества сообщений для каждого приоритета
     * @param messageList Список сообщений
     */
    public static void countEachPriority(List<Message> messageList) {

        int[] count = new int[MessagePriority.values().length];

        for (Message message : messageList) {
            MessagePriority priority = message.getPriority();
            int index = priority.ordinal();
            count[index]++;
        }

        for (MessagePriority priority: MessagePriority.values()) {
            int index = priority.ordinal();
            System.out.println(priority + ": " + count[index]);
        }
    }

    /**
     * Метод подсчета количества сообщений для каждого кода сообщения
     * @param messageList Список сообщений
     */
    public static void countEachCode(List<Message> messageList) {

        int[] count = new int[10];

        for (Message message : messageList) {
            int code = message.getCode();
            count[code]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + ": " + count[i]);
        }
    }

    /**
     * Метод подсчета количества уникальных сообщений
     * @param messageList Список сообщений
     */
    public static void uniqueMessageCount(List<Message> messageList) {

        HashSet<Message> uniqueMessages = new HashSet<>(messageList);

        System.out.println("Количества уникальных сообщений: " + uniqueMessages.size());
    }

    /**
     * Метод получения списка неповторяющихся сообщений и в том порядке, в котором они встретились
     * @param messageList Список сообщений
     * @return Список неповторяющихся сообщений
     */
    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {

        LinkedHashSet<Message> uniqueMessages = new LinkedHashSet<>(messageList);

        List<Message> uniqueMessagesList = new ArrayList<>(uniqueMessages);

        return uniqueMessagesList;
    }

    /**
     * Метод удаления из коллекции каждого сообщения с заданным приоритетом
     * @param messageList Список сообщений
     * @param inPriority Приоритет сообщения
     */
    public static void removeEach(List<Message> messageList, MessagePriority inPriority) {

        System.out.println("До удаления: " + messageList);

        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            MessagePriority priority = iterator.next().getPriority();
            if (priority == inPriority){
                iterator.remove();
            }
        }

        System.out.println("После удаления: " + messageList);
    }

    /**
     * Метод удаления из коллекции всех сообщений, кроме тех, которые имеют заданный приоритет
     * @param messageList Список сообщений
     * @param priority Приоритет сообщения
     */
    public static void removeOther(List<Message> messageList, MessagePriority priority) {

        System.out.println("До удаления: " + messageList);

        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            MessagePriority currentPriority = iterator.next().getPriority();
            if (currentPriority != priority){
                iterator.remove();
            }
        }

        System.out.println("После удаления: " + messageList);
    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);

        countEachPriority(messages);

        countEachCode(messages);

        uniqueMessageCount(messages);

        System.out.println(uniqueMessagesInOriginalOrder(messages));

        removeEach(messages, MessagePriority.HIGH);

        removeOther(messages, MessagePriority.LOW);
    }
}
