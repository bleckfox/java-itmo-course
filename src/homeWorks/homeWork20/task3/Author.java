package homeWorks.homeWork20.task3;

import java.time.LocalDate;

public class Author {
    private final String name;
    private final String email;
    private final LocalDate birth;

    public Author(String name, String email, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
