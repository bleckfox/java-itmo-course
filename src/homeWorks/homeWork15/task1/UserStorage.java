package homeWorks.homeWork15.task1;

import java.util.*;

public class UserStorage {
    private HashMap<String, User> users;

    public UserStorage() {
        users = new HashMap<>();
    }

    public void addUser(User user){
        Objects.requireNonNull(user, "User object cannot be null1");
        if (!users.containsKey(user.getLogin())){
            users.put(user.getLogin(), user);
        }
    }

    public List<User> getUsersByAge(int maxAge){
        ArrayList<User> userArrayList = new ArrayList<>();

        for (User user : users.values()) {
            if (user.getAge() < maxAge) {
                userArrayList.add(user);
            }
        }

        return userArrayList;
    }

    public Map<Integer, List<User>> getUsersByAge(){
        HashMap<Integer, List<User>> map = new HashMap<>();

        for (User user : users.values()) {
            int ageKey = user.getAge();

            if (map.containsKey(ageKey)){
                map.get(ageKey).add(user);
            }
            else {
                ArrayList<User> userArrayList = new ArrayList<>();
                userArrayList.add(user);
                map.put(ageKey, userArrayList);
            }
        }

        return map;
    }

    public EnumMap<Role, Integer> getNumberOfUsersByRole(){
        EnumMap<Role, Integer> enumMap = new EnumMap<>(Role.class);

        for (User user : users.values()) {
            Role role = user.getRole();
            enumMap.put(role, enumMap.getOrDefault(role, 0) + 1);
        }

        return enumMap;
    }
}
