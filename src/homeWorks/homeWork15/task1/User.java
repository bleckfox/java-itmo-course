package homeWorks.homeWork15.task1;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private Role role;
    private int age;


    public User(String login, String password, Role role, int age) {
        setLogin(login);
        setPassword(password);
        setRole(role);
        setAge(age);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, role, age);
    }

    @Override
    public String toString() {
        return "\n" +
                "User { " +
                "login = '" + login + "', " +
                "password = '" + password + "', " +
                "role = '" + role + "', " +
                "age = " + age + " }";
    }
}
