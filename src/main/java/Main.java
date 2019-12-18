import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String str = "One fish, two fish, red fish, blue fish.";
        String trigraph;
        String[] words = str.trim().replaceAll("[^A-Za-z- ]","").toUpperCase().split(" ");

        HashMap<String, Integer> trigraphs = new HashMap<>();

        for (int i = 0; i < words.length; i++){

            if(words[i].length() < 3){continue;}
            for (int j = 0; j < words[i].length()-2; j++){
                trigraph = words[i].substring(j,j+3);
                if(trigraphs.containsKey(trigraph)){
                    trigraphs.put(trigraph,trigraphs.get(trigraph)+1);
                    continue;
                }
                else { trigraphs.put(trigraph,1); }
            }
        }
        Map<String, Integer> sortedTr = new TreeMap<>(trigraphs);
        System.out.println(sortedTr);
    }
}