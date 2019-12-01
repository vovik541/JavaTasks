import java.util.HashMap;
import java.util.Arrays;

public class TaskTwo {
    public static void taskSecond(){
        HashMap<Integer, String> wordsValue = new HashMap<>();
        String text = "hello, world!!!. Now I am here. Are you afraid of darkness?".toLowerCase();
        text = text.replaceAll("[^A-Za-z- ]","");
        String[] words = text.split(" ");
        char ch = 'a';

        int maxIndex = 0;

        for(String word:words){
            String formatted = word.replaceAll(String.valueOf(ch),"");
            Integer index = word.length()-formatted.length();

            if(maxIndex < index){
                maxIndex = index;
            }
            if(wordsValue.containsKey(index)){
                wordsValue.put(index,wordsValue.get(index) + " " + word);
            } else {
                wordsValue.put(index,word);
            }
        }

        String sortedText = "";
        for(int i = maxIndex; i >= 0; i--){

            if(wordsValue.containsKey(i)){
               String[] byLetterWord = wordsValue.get(i).split(" ");
               if(byLetterWord.length==1){
                   sortedText+=" "+ byLetterWord[0];
               }else {
                   Arrays.sort(byLetterWord);

                   for (int o = 0; o < byLetterWord.length; o++){
                       sortedText+=" "+ byLetterWord[o];
                   }
               }
            }else {
                continue;
            }
        }
        System.out.println(sortedText);
    }
}
