import java.util.*;

public class KostiaTasks {
    public static void main(String[] args) {
        sortByLetter();
    }
// ---------------- TASK 1 ---------------------

    static void count() {
        HashMap<String, Integer> map = new HashMap<>();
        String sentence = "My home, is my home my my".toLowerCase();

        for (String word : sentence.split("\\W")) {
            if (word.isEmpty()) {
                continue;
            }
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> words = new ArrayList<>(map.entrySet());
        words.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(words);
        words.forEach(System.out::println);
    }

    // ---------------- TASK 2 ---------------------
    private static int countLetterInWord(String word, char r){
        if(word.isEmpty()) return 0;
        return (((word.charAt(0) == r) ? (1) : (0)) + countLetterInWord(word.substring(1), r));
    }

    private static void sortByLetter() {
        System.out.println("Input required letter: ");
        Scanner scanner = new Scanner(System.in);
        char requiredChar = scanner.next().charAt(0);
        scanner.close();

        HashMap<String, Integer> wordsMap = new HashMap<>();
        ArrayList<String> noUsage = new ArrayList<>();

        String sentence = "My home, radar is my home, daad".toLowerCase();
        String[] words = sentence.split("\\W");

        for (String word : words) {
            int usage = countLetterInWord(word, requiredChar);

            if (usage > 0)
                wordsMap.put(word, usage);
            else
                noUsage.add(word);
        }

        Collections.sort(noUsage);
        sortByValue(wordsMap).stream().distinct().forEach(System.out::println);
        noUsage.stream().distinct().forEach(System.out::println);
    }

    private static ArrayList<String> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(list);
        ArrayList<String> result = new ArrayList<>();

        list.sort((o1, o2) -> ((o1.getValue().equals(o2.getValue())) ?
                (o1.getKey().compareTo(o2.getKey())) : (0)));

        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
        }

        return result;
    }

// ---------------- TASK 3 ---------------------

    static void findPalindrome() {
        String sentence = "My home, dad, radar is my home, dad".toLowerCase();
        ArrayList<String> pals = new ArrayList<>();

        search:
        for (String word : sentence.split("\\W")) {
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                    continue search;
                }
            }
            pals.add(word);
        }

        String maxLen = pals.get(0);
        for (String s : pals) {
            if (s.length() > maxLen.length())
                maxLen = s;
        }
        System.out.println(maxLen);
    }

// ---------------- TASK 4 ---------------------

    private static void replaceWords() {
        String sentence = "My home, is my lovely home, baby :)".toLowerCase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input required word length");
        int requiredLength = scanner.nextInt();

        System.out.println("Input word for replace");
        String wordForReplace = scanner.next();
        String[] words = sentence.split("\\W");

        for (String word : words) {
            if (word.length() == requiredLength)
                sentence = sentence.replaceAll(word, wordForReplace);
        }
        System.out.println(sentence);
    }
}
