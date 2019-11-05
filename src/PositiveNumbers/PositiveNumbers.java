package PositiveNumbers;

public class PositiveNumbers {

    public static void findPosiviteN(){
        int [][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,-200,1,2},
                {98,1,1,0},
                {2,2,2,2}
        };
        int[][] finalArray = matrix;
        float maxAverage = 0;
        int numberLine = 0;
        int numberOfZeroes;
        int sum;

        for (int i = 0; i < finalArray.length; i++){
            numberOfZeroes = 0;
            sum = 0;

            for (int j = 0; j < finalArray[i].length; j++){
                if (finalArray[i][j] < 0){
                    finalArray[i][j] = 0;
                    numberOfZeroes++;
                }
                sum += finalArray[i][j];
            }

            if (maxAverage < sum/(finalArray[i].length-numberOfZeroes)){
                numberLine = i;
                maxAverage = (float) sum/(finalArray[i].length-numberOfZeroes);
            }

        }
        System.out.println("line number: " + (numberLine + 1) +" Maximum average is: " + maxAverage);
    }

    public static void main(String[] args) {
        findPosiviteN();
    }
}
