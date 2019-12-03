public class TaskThree {
    public static void taskThree(String str) {
        String palindromeStr = "";
        int j = str.length();
        int i;

        label:for(;j > 0; j--){
            i = 0;
            for (;i < j; i++){
                if(checkPalindrome(str.substring(i,j))){
                    if(palindromeStr.length() < str.substring(i,j).length()){
                        palindromeStr = str.substring(i,j);
                        System.out.println(palindromeStr);
                    }
                    continue label;
                }else {
                    continue;
                }
            }
        }
        System.out.println(palindromeStr);
    }

    private static boolean checkPalindrome(String str) {
        if (str == null)
            return false;
        if (str.length() <= 1) {
            return true;
        }
        String first = str.substring(0, 1);
        String last = str.substring(str.length() - 1);
        if (!first.equals(last))
            return false;
        else
            return checkPalindrome(str.substring(1, str.length() - 1));
    }
}
