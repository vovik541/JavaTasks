package Palindrome;

import java.lang.management.BufferPoolMXBean;

public class Palindrome {

    private static char ZERO = '0';
    private static char ONE = '1';

    public static void showInt(String bitNegativeNumber){   //here me make positive numbers from negative
        char[] charArr = bitNegativeNumber.toCharArray();

        for (int i = 0; i< 32; i++){ //~number
            if(charArr[i]==ONE){
                charArr[i]=ZERO;
            } else {
                charArr[i]=ONE;
            }
        }

        String string = new String(charArr);
//        System.out.println(string);
        System.out.println(-Integer.parseInt(string,2)+1);
//        System.out.println(Integer.toBinaryString(-(Integer.parseInt(string,2)+1)));
    }

    private static int NEG_NUM_OF_PAL = 32767;
    private static int HALF_INT_BITS = 16;

    private static void findNegativePalindrome(){
        String number;

        for (int i = (int)Math.pow(2,15); i < (int)(Math.pow(2,16)-1); i++){
            number = Integer.toBinaryString(i);
            number += new StringBuffer(number).reverse().toString();
//            System.out.println(number);
            showInt(number);
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

    public static void palindrome_v_5(){
        findNegativePalindrome();
        System.out.println("-1");
        System.out.println("1");
        findPositivePalindromes();
    }

    public static void main(String[] args) {
        palindrome_v_5(); //2-3 seconds!!!
    }
}