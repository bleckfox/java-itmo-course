package homeWorks.homeWork15.task2;

import java.util.*;

public class Task2 {

    private static List<String> task01(Map<String, String> map, String someString) {

        List<String> resultList = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(someString)){
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }

    private static Map<String, Integer> task02(List<String> strings) {

        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String str : strings) {
            if (resultMap.containsKey(str)){
                resultMap.put(str, (resultMap.get(str) + 1) );
            }
            else {
                resultMap.put(str, 1);
            }
        }

        return resultMap;
    }

    private static Map<String, Long> task0301(String text) {
        Map<String, Long> resultMap = new HashMap<>();
        String[] words = text.split("\\W+");

        for (String word : words) {
            if (resultMap.containsKey(word)) {
                long count = resultMap.get(word);
                resultMap.put(word, count + 1);
            } else {
                resultMap.put(word, 1L);
            }
        }

        return resultMap;
    }

    private static Map<Integer, ArrayList<String>> task0302(String text) {

        HashMap<Integer, ArrayList<String>> resultMap = new HashMap<>();
        String[] words = text.split("\\W+");

        for (String word : words) {
            int wordLength = word.length();

            if (resultMap.containsKey(wordLength)){
                ArrayList<String> wordList = resultMap.get(wordLength);
                wordList.add(word);
            }
            else {
                ArrayList<String> wordList = new ArrayList<>();
                wordList.add(word);
                resultMap.put(wordLength, wordList);
            }
        }
        return resultMap;
    }

    private static void task0303(String text) {
        Map<String, Integer> map = task02(Arrays.asList(text.split(" ")));
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // анонимный класс
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(valueComparator);

        int count = Math.min(10, list.size());
        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i).getKey() + "=" + list.get(i).getValue());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(task01(firstTaskMap, city));

        // ---------------------------------------------------------------------------

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(task02(words));

        // ---------------------------------------------------------------------------

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(task0301(text));
        System.out.println(task0302(text));
        task0303(text);

    }

}
