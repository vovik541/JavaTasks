package Palindrome;

public class Palindrome {

    public static final int intLength = (int)Math.pow(2,31);

    public static void palindrome_v_3(){ //1.5 minutes
        char[] bitLine;
        int k = 2;
        int j;

        label:for (int i = -2147483645; i < 2147483646; i+=2 ){
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

    public static void palindrome_v_4(){

    }

    public static void main(String[] args) {
        //palindrome_v_3(); //1.5 minutes
        palindrome_v_4();
    }
}