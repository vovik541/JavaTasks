package OddNumber;

public class OddNumber {


    public static void findMax(){
        int[]  array = {3,15,17,26,3,4,52,6,7,8,9,10,11,12,13};
        int maxOdd=array[0];

        for (int i = 0; i<array.length;i++){
            if(array[i]%2==1 && array[i] > maxOdd){
                maxOdd = array[i];
            }
        }
        System.out.println("Max Odd Number is: "+ maxOdd);
    }


    public static void main(String[] args) {
        findMax();
    }
}
