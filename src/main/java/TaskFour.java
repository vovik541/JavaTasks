import java.util.HashMap;

public class TaskFour {
    public static void taskFour(){
        HashMap<Integer, String> wordsValue = new HashMap<>();
        String text = "hello, world!!!. Now I am here. Are you afraid of darkness?";
        String formattedText = "";
        String changeOn = "HELLO";
        int length = 3;

        text = text.replaceAll("[^A-Za-z- ]","");
        String[] words = text.split(" ");

        for(int i = 0; i < words.length; i++){
            if(words[i].length()==length){
                words[i] = changeOn;
            }
        }

        for(String word:words){
            formattedText += word + " ";
        }

        System.out.println(formattedText);
    }
}
