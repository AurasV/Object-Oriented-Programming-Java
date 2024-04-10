import java.util.Arrays;

public class Averaging {
    public static void main(String[] args) {
        float[][] numbers = {{1,4,7},{2,5,8},{3,6,9}};
        System.out.println(Arrays.toString(average_per_column(numbers)));
    }

    public static float[] average_per_column(float[][] numbers){
        if (numbers.length > 0){
            float[] averages = new float[numbers[0].length];
            for (int i = 0; i < numbers[0].length; i++){
                float sum = 0;
                for (float[] number : numbers) {
                    sum += number[i];
                }
                averages[i] = sum / numbers.length;
            }
            return averages;
        }
        return new float[0];
    }
}