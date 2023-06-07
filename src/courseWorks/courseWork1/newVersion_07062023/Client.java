package courseWorks.courseWork1.newVersion_07062023;

import  java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Посетитель клуба
 */
public class Client {
    /**
     * Имя
     */
    private final String firstName;

    /**
     * Фамилия
     */
    private final String lastName;

    /**
     * Дата рождения
     */
    private final LocalDate birthDate;


    public Client(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = Objects.requireNonNull(firstName, "Необходимо ввести имя");
        this.lastName = Objects.requireNonNull(lastName, "Необходимо ввести фамилию");
        LocalDate clientBirthDate = Objects.requireNonNull(birthDate, "Необходимо ввести дату рождения");

        if (isAdult().test(clientBirthDate)){
            this.birthDate = birthDate;
        }
        else {
            throw new IllegalArgumentException("Извините, но в зал могут пройти люди от 18 до 120 лет!");
        }
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

    private Predicate<LocalDate> isAdult(){
        return localDate -> {
            LocalDate now = LocalDate.now();
            int age = Period.between(localDate, now).getYears();
            // возраст самого известного долгожителя)
            return age >= 18 && age < 120;
        };
    }
}
