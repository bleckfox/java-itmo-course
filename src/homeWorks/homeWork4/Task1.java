package homeWorks.homeWork4;

public class Task1 {
    public static void main(String[] args) {

        String hello = "Hello, world!";
        String hello2 = "Hello, world!";
        String world = "world";
        String example = "   abc  a   a  ssadasd   asdasd  ";

        System.out.println(hello);
        System.out.println("replaceAll -> " + hello.replaceAll("o", "a"));
        System.out.println("replaceFirst -> " + hello.replaceFirst("o", "a"));

        System.out.println("contains -> " + hello.contains("o"));
        System.out.println("startsWith -> " + hello.startsWith("o"));
        System.out.println("endsWith -> " + hello.endsWith("o"));

        System.out.println("trim -> " + example.trim());
        System.out.println("strip -> " + example.strip());
        System.out.println("stripIndent -> " + example.stripIndent());
        System.out.println("stripLeading -> " + example.stripLeading());
        System.out.println("stripTrailing -> " + example.stripTrailing());

        System.out.println("compareTo -> " + hello.compareTo(hello2));
        System.out.println("compareToIgnoreCase -> " + hello.compareToIgnoreCase(world));

        System.out.println("isBlank -> " + hello.isBlank());
        System.out.println("isEmpty -> " + hello.isEmpty());

        System.out.println("repeat -> " + hello.repeat(2));

        System.out.println("toLowerCase -> " + hello.toLowerCase());
        System.out.println("toUpperCase -> " + hello.toUpperCase());

        System.out.println("charAt -> " + hello.charAt(1));

    }
}
