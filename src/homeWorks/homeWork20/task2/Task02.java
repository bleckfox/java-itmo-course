package homeWorks.homeWork20.task2;

import homeWorks.homeWork18.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task02 {
    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course(100000, 30, "Java"));
        courses.add(new Course(200000, 60, "Java"));
        courses.add(new Course(80000, 20, "Python"));
        courses.add(new Course(12000, 40, "JavaScript"));
        courses.add(new Course(110000, 25, "C#"));
        courses.add(new Course(210000, 50, "C#"));
        courses.add(new Course(80000, 35, "Ruby on Rails"));
        courses.add(new Course(16000, 70, "Ruby on Rails"));

        // Создать map,
        //  где ключи - названия курсов,
        //  значения - списки курсов с указанным в ключе названием
        Map<String, List<Course>> map01 = courses.stream()
                .collect(Collectors.groupingBy(Course::getName));

        // Создать map,
        //  где ключи - продолжительность курсов,
        //  значения - списки курсов с указанной в ключе продолжительностью
        Map<Integer, List<Course>> map02 = courses.stream()
                .collect(Collectors.groupingBy(Course::getDuration));

        // Создать map,
        //  где ключи - названия курсов,
        //  значения - количество курсов с указанным в ключе названием
        Map<String, Long> map03 = courses.stream()
                .collect(
                        Collectors.groupingBy(
                                Course::getName,
                                Collectors.counting()
                        )
                );

        // Создать map,
        //  где ключи - названия курсов,
        //  значения - map,
        //  в которой  ключи - продолжительность курса,
        //  а значения - списки курсов с указанной в ключе продолжительностью
        Map<String, Map<Integer, List<Course>>> map04 = courses.stream()
                .collect(
                        Collectors.groupingBy(
                                Course::getName,
                                Collectors.groupingBy(
                                        Course::getDuration
                                )
                        )
                );

    }
}
