package courseWorks.courseWork1.oldVersion;

import java.time.LocalDate;

/**
 * Посетитель клуба
 */
public class Client {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public Client(String firstName, String lastName, LocalDate birthDate){

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
