package homeWorks.homeWork20.task3;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Task03 {
    public static void main(String[] args) {
        // Написать реализацию методов task01 - task05
        // Для некоторых решений может пригодиться метод flatMap класса Stream
    }

    public static Double task05(ArrayList<Article> articles){
        // Вернуть средний возраст авторов статей
        return articles.stream()
                .flatMap(article -> article.getAuthors().values().stream())
                .mapToInt(author -> Period.between(author.getBirth(), LocalDate.now()).getYears())
                .average()
                .orElse(0.0);
    }

    public static Author task04(ArrayList<Article> articles, Category category){
        // Вернуть самого молодого автора статей категории == category
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .flatMap(article -> article.getAuthors().values().stream())
                .min(Comparator.comparing(Author::getBirth))
                .orElse(null);
    }

    public static HashSet<String> task03(ArrayList<Article> articles, Category category){
        // Вернуть множество email авторов статей категории == category
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .flatMap(article ->
                        article.getAuthors().values().stream()
                                .map(Author::getEmail)
                )
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static Set<Article> task02(ArrayList<Article> articles,
                                      Category category, int min, int max){
        // Вернуть множество статей категории == category, возраст авторов
        // которых попадает в диапазон от min до max
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> {
                    int minAge = article.getAuthors().values().stream()
                            .mapToInt(author -> Period.between(LocalDate.now(), author.getBirth()).getYears())
                            .min()
                            .orElse(0);
                    int maxAge = article.getAuthors().values().stream()
                            .mapToInt(author -> Period.between(LocalDate.now(), author.getBirth()).getYears())
                            .max()
                            .orElse(0);

                    return minAge >= min && maxAge <= max;
                })
                .collect(Collectors.toSet());
    }

    public static LinkedList<Article> task01(ArrayList<Article> articles, Category category){
        // Вернуть список статей категории == category, опубликованных сегодня
        LocalDate today = LocalDate.now();

        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> article.getPublished().toLocalDate().isEqual(today))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
