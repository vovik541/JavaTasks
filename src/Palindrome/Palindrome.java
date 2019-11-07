package Palindrome;

public class Palindrome {

    private static final int intLength = (int)Math.pow(2,31);

    public static void palindrome_v_3(){ //1.5 minutes
        char[] bitLine;
        int k = 2;
        int j;

        label:for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i+=2 ){
            bitLine = Integer.toBinaryString(i).toCharArray();
            j=0;
            k = bitLine.length - 1;

            while (j<k){
                if(bitLine[j]==bitLine[k]){
                    k--;
                    j++;
                    continue;
                } else {
                    continue label;
                }
            }
            System.out.println(i);
//            System.out.println(Integer.toBinaryString(i));
        }
    }

    private static char ZERO = '0';
    private static char ONE = '1';

    public static void showInt(String bitNegativeNumber){
        char[] charArr = bitNegativeNumber.toCharArray();

        for (int i = 0; i< 32; i++){
            if(charArr[i]==ONE){
                charArr[i]=ZERO;
            } else {
                charArr[i]=ONE;
            }
        }

        int k=31;
        while (true){
            if(charArr[k] == ONE){
                charArr[k] = ZERO;
                k--;
                continue;
            } else {
                charArr[k] = ONE;
                break;
            }
        }

        String string = new String(charArr);
        Integer.parseInt(string,2);

        System.out.println(-Integer.parseInt(string,2));
    }

    private static int NEG_NUM_OF_PAL = 32767;
    private static int HALF_INT_BITS = 16;

    private static void findNegativePalindrome(){
        char[] negativePolindromes = new char[HALF_INT_BITS];
        negativePolindromes[0]='1';
        for (int j = 1; j < HALF_INT_BITS; j++){
            negativePolindromes[j] = '0';
        }
//        String string = new String(negativePolindromes);
//        System.out.println(string);
        char currentChar = 1;
        boolean isOneSaved = false;
        String bitNegativeNumber;
        String halfBit;
        Long number;

        int k=15;
        for(int i = NEG_NUM_OF_PAL; i > 0; i--){

            if(negativePolindromes[k] != ONE){
                negativePolindromes[k] = ONE;
            } else {
                k=15;
                while (true){
                    if(negativePolindromes[k] == ONE){
                        negativePolindromes[k] = ZERO;
                        k--;
                        continue;
                    } else {
                        negativePolindromes[k] = ONE;
                        break;
                    }
                }
            }

            halfBit = new String(negativePolindromes);
//                System.out.println(halfBit);
            bitNegativeNumber = halfBit + new StringBuffer(halfBit).reverse().toString();
//                System.out.println(bitNegativeNumber);  //uncomment is you want to see bitMasks
            showInt(bitNegativeNumber);
        }
    }
    public static void toStrNum(String str){
       String reversedStr = new StringBuffer(str).reverse().toString();
//       System.out.println(str+reversedStr);
        System.out.println(Integer.parseInt(str+reversedStr,2));
//       System.out.println(str+"0"+reversedStr);
        System.out.println(Integer.parseInt(str+"0"+reversedStr,2));
//       System.out.println(str+"1"+reversedStr);
        System.out.println(Integer.parseInt(str+"1"+reversedStr,2));
    }

    private static final int HALF_NUM = (int)Math.pow(2,15);

    private static void findPositivePalindromes(){
        String bitHalfMask;
        for (int muskNumber = 1; muskNumber < HALF_NUM; muskNumber+=1){
            bitHalfMask = Integer.toBinaryString(muskNumber);
            toStrNum(bitHalfMask);
        }
    }

    public static void palindrome_v_4(){
        findNegativePalindrome();
        System.out.println("1");
        findPositivePalindromes();
    }

    public static void main(String[] args) {
        //palindrome_v_3(); //1.5 minutes
        palindrome_v_4(); //2-3 seconds!!!
    }
}