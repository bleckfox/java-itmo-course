package homeWorks.homeWork20.task1;

import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {

        Notifier notifier = new Notifier();

        notifier.addUser(new User(true));
        notifier.addUser(new User(false));
        notifier.addUser(new User(true));
        notifier.addUser(new User(true));
        notifier.addUser(new User(false));
        notifier.addUser(new User(true));
        notifier.addUser(new User(false));

        NotificationWay way01 = a -> {
            System.out.println("1 способ");
        };
        NotificationWay way02 = user -> {
            System.out.println("2 способ");
        };
        NotificationWay way03 = user -> {
            System.out.println("3 способ");
        };

        notifier.notifyUsers(way01.add(way02).addIf(way03, user -> user.isAgreeWithAdditional()));

        Predicate<Integer> isPos = integer -> integer > 0;
        Predicate<Integer> isNeg = integer -> integer < 0;

        Predicate<Integer> predicate = isPos.or(isNeg);
        predicate.test(23);
    }
}
