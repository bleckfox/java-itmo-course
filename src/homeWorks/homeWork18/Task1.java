package homeWorks.homeWork18;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class Task1 {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(100000, 30, "Java"));
        courses.add(new Course(80000, 20, "Python"));
        courses.add(new Course(12000, 40, "JavaScript"));
        courses.add(new Course(110000, 25, "C#"));
        courses.add(new Course(80000, 35, "Ruby on Rails"));

        University university = new University();

        university.addcourses(courses);


        Predicate<Course> pythonCoursesPredicate = course -> course.getName().equalsIgnoreCase("python");

        Predicate<Course> durationAndPricePredicate = course -> course.getDuration() < 3 && course.getPrice() < 20000;

        Function<Double, String> addSuffix = number -> number > 0 ? number + "p." : String.valueOf(number);

        Consumer<Course> getCoursesPrice = course -> System.out.println(addSuffix.apply(course.getPrice()));


        Predicate<Double> priceCondition = price -> price > 81000;
        Function<Double, String> ifTrue = price -> "Цена за курс больше 81 000 р.";
        Function<Double, String> ifFalse = price -> "Цена за курс меньше или равна 81 000 р.";

        // --------------------------------------------------------------
        university.removeIfCourses(pythonCoursesPredicate);

        university.removeIfCourses(durationAndPricePredicate);

        university.getCoursesPrice(getCoursesPrice);

        Function<Double, String> coursesPriceHigherThan = University.getHigherPriceFunction(
                priceCondition, ifTrue, ifFalse
        );

        String higherPriceThan = coursesPriceHigherThan.apply(82000.0);
        System.out.println(higherPriceThan);

    }
}
