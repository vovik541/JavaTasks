package MostCommonSymbol;

public class MostCommonSimbol {

    public static void mostCommSimbl(){
        String str = "--__/,,,DfffFFFFF".toLowerCase();
        char[] strToArray = str.toCharArray();
        int arrLength = strToArray.length;
        int maxCoincidence = 0;
        int charPosition = 0;
        int coincidence;

        for (int i = 0; i < arrLength; i++){
            coincidence = 0;
            for (int j = 0; j < arrLength; j++){
                if (strToArray[i]==strToArray[j]){
                    coincidence++;
                }
            }
            if (coincidence > maxCoincidence){
                maxCoincidence = coincidence;
                charPosition = i;
            }
        }
        System.out.println("symbol '"+strToArray[charPosition]+"' meets "+maxCoincidence+" times");
    }

    public static void main(String[] args) {
        mostCommSimbl();
    }
}
