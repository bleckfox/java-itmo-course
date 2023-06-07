package homeWorks.homeWork20.task1;

import java.util.HashSet;
import java.util.Objects;

public class Notifier {
    private HashSet<User> users;

    public void addUser(User user) {
        // добавлять, если:
        // пользователь не null (при null выбрасывать исключение) +
        // у пользователя есть хотя бы один основной контакт для уведомлений +
        // если пользователь согласен на дополнительные уведомления,
        // у него должен быть хотя бы один дополнительный контакт для уведомлений
        if (user.getMainContacts().size() > 0){
            if (user.isAgreeWithAdditional()
                    && user.getAdditionalContacts().size() > 0){
                users.add(Objects.requireNonNull(user));
                return;
            }
            users.add(Objects.requireNonNull(user));
        }
    }

    public void notifyUsers(NotificationWay way){
        this.users.forEach(way::send);
        /*for (User user : this.users) {
            way.send(user);
        }*/
    }
}
