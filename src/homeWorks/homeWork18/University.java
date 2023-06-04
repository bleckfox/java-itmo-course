package homeWorks.homeWork18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course){
        return courses.add(Objects.requireNonNull(course));
    }

    public boolean addcourses(List<Course> courses){
        return this.courses.addAll(Objects.requireNonNull(courses));
    }

    public void removeIfCourses(Predicate<Course> coursePredicate){
        this.courses.removeIf(coursePredicate);
        System.out.println("Courses was deleted successfully");
    }

    public void getCoursesPrice(Consumer<Course> courseConsumer){
        courses.forEach(courseConsumer);
    }

    public void upPrice(double newPrice, double currentPrice){
        courses.forEach(course -> {
            if (course.getPrice() < currentPrice){
                course.setPrice(course.getPrice() + newPrice);
            }
        });
        // метод увеличивает стоимость курсов (courses) на newPrice,
        // если текущая стоимость меньше currentPrice
        // использовать метод foreach коллекций
    }

    public void upDuration(double currentPrice) {
        courses.forEach(course -> {
            if (course.getPrice() > currentPrice){
                course.setDuration(course.getDuration() + 1);
            }
        });
        // метод увеличивает продолжительность курсов (courses) на 1,
        // если их стоимость больше currentPrice
        // использовать метод foreach коллекций
    }

    public void sortByDurationAndPrice(Comparator<Course> comparator) {
        courses.sort(comparator);
        // метод сортирует коллекцию courses по стоимости,
        // если курсы одинаковы по стоимости, сортирует по продолжительности
    }

    public static Comparator<Course> courseDurationAndPriceComparator(){
        return Comparator
                .comparing(Course::getPrice)
                .thenComparing(Course::getDuration);
    }

    public static <T, R> Function<T, R> getHigherPriceFunction (
            Predicate<T> condition,
            Function<T, R> ifTrue,
            Function<T, R> ifFalse){

        return input -> condition.test(input) ? ifTrue.apply(input) : ifFalse.apply(input);
    }
}
