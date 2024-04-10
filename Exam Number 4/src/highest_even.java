import java.util.Arrays;

public class highest_even {
    public static void main(String[] args) {
        float[][] numbers = {{1,4,7},{2,5,8},{3,6,9}};
        System.out.println(Arrays.toString(sum_elem_highest_even(numbers)));
    }

    //sum of elements in the column with the highest number of even elements
    public static float[] sum_elem_highest_even(float[][] numbers){
        if(numbers.length > 0){
            int max = Integer.MIN_VALUE;
            int index = -1;
            for(int i = 0; i < numbers[0].length; i++){
                int count = 0;
                for(int j = 0; j < numbers.length; j++){
                    if(numbers[j][i] % 2 == 0){
                        count++;
                    }
                }
                if(count > max){
                    max = count;
                    index = i;
                }
            }
            float sum = 0;
            for(int i = 0; i < numbers.length; i++){
                sum += numbers[i][index];
            }
            return new float[]{index, sum};
        }
        return new float[0];

    }
}