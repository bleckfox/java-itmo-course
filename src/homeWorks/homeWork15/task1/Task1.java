package homeWorks.homeWork15.task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        User user01 = new User("user01", "1111", Role.ADMIN, 18);
        User user02 = new User("user02", "2222", Role.USER, 22);
        User user03 = new User("user03", "3333", Role.USER, 29);
        User user04 = new User("user04", "4444", Role.USER, 44);
        User user05 = new User("user05", "5555", Role.ADMIN, 18);

        UserStorage storage = new UserStorage();

        storage.addUser(user01);
        storage.addUser(user02);
        storage.addUser(user03);
        storage.addUser(user04);
        storage.addUser(user05);

        List<User> userArrayList = storage.getUsersByAge(28);

        Map<Integer, List<User>> userHashMap = storage.getUsersByAge();

        EnumMap<Role, Integer> enumMap = storage.getNumberOfUsersByRole();
    }
}
