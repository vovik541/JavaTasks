import java.util.HashMap;

public class TaskOne {

        public TaskOne(){}

        public static void taskFirst(){
            String text = "Maria Maria Julia Julia Julia, Ola".toLowerCase();
            String[] lookedWordsArr = {"humankind","maria","ola","julia"};
            HashMap<String, Integer> lookedWords = new HashMap<>();
            HashMap<String, Integer> sorted = new HashMap<>();

            text = text.replaceAll("[^A-Za-z- ]","");

            for (String looked:lookedWordsArr){ lookedWords.put(looked , 0); }

            for (String word:text.split(" ")){
                for (String looked:lookedWordsArr){
                    if(word.equals(looked)){
                        lookedWords.put(looked,lookedWords.get(looked)+1);
                    }
                }
            }

            int maxValue = 0;
            for (String looked:lookedWordsArr){
                if(maxValue < lookedWords.get(looked)){
                    maxValue = lookedWords.get(looked);
                }
            }

            for(int i = maxValue; i > 0; i--){
                for(String looked:lookedWordsArr){
                    if(i == lookedWords.get(looked)){
                        sorted.put(looked,i);
                        System.out.println(looked+" "+ sorted.get(looked));
                    }
                }
            }
        }
}
