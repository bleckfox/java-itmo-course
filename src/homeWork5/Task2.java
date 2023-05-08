package homeWork5;

public class Task2 {
    public static void main(String[] args) {

        String text = """
                JAVA стоит первым в рейтинге популярности использования языков;
                JAVA один из наиболее мощных высокоуровневых языков программирования;
                JAVA поддерживает большое количество встроенных библиотех, которые позволяют быстро писать проекты любого класса сложности;
                курс «JUNIOR JAVA DEVELOPER» предназначен для подготовки программистов-профессионалов, специализирующихся на разработке программного обеспечения различного класса и уровня сложности.""";

        System.out.println(text.replaceAll("JAVA", "PYTHON"));

        int matchJavaNum = 0;
        // Разделяем по строками
        for (var line: text.split("\n")){
            // Разделяем по словам
            for (var words: line.split(" ")){
                if (words.equals("JAVA")){
                    matchJavaNum++;
                }
            }
        }

        System.out.printf("\nСлово JAVA встретилось столько раз -> %d", matchJavaNum);
    }
}
