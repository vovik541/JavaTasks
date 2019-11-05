package IdenticalNumbers;

public class IdenticalNumbers {

    public static void printArray(int[] Arr, int counter){
        for (int i=0; i < counter; i++){
            System.out.println("Array["+i+"]= "+Arr[i]);
        }
    }

    public static void findIdenticalNumbers(){
        final int N = 5;
        int[] firstArray = {1,2,3,4,5,10,1,0};
        int[] secondArray = {4,5,6,7,8,9,10,1,0};
        int[] finalArray = new int[N];
        int counter = 0;

        label: for (int i = 0; i < firstArray.length; i++){

            for (int k = 0; k < N; k++){
                if (firstArray[i] == finalArray[k]){
                    continue label;
                }
            }
            for (int j = 0; j < secondArray.length; j++){
                if (firstArray[i] == secondArray[j]){
                    finalArray[counter] = firstArray[i];
                    counter++;
                    continue label;
                }
            }
        }
        printArray(finalArray,counter);
    }

    public static void main(String[] args) {
        findIdenticalNumbers();
    }
}
