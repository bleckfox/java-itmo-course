package homeWorks.homeWork18;

import java.util.Objects;

public class Course {
    private double price;
    private int duration;
    private final String name;

    public Course(double price, int duration, String name) {
        this.price = price;
        this.duration = duration;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "\n" +
                "Course { " +
                "price = " + price + ", " +
                "duration = " + duration + ", " +
                "name = " + name + " }";
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, duration, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;

        Course course = (Course) obj;

        if (price != course.price) return false;
        if (duration != course.duration) return false;
        return Objects.equals(name, course.name);
    }
}
