package homeWorks.homeWork19.task1;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Student(int number, String name, Gender gender, LocalDate birth) {
        setNumber(number);
        setName(name);
        setGender(gender);
        setBirth(birth);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student pupil = (Student) o;
        return number == pupil.number && Objects.equals(name, pupil.name) && gender == pupil.gender && Objects.equals(birth, pupil.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, gender, birth);
    }

    @Override
    public String toString() {
        return "\n" +
                "Student { " +
                "number = " + number + ", " +
                "name = '" + name + "', " +
                "gender = " + gender + ", " +
                "birth = " + birth + " }";
    }
}
