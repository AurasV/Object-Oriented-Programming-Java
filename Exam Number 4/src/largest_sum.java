public class largest_sum {
    public static void main(String[] args) {
        float[][] numbers = {{1,4,7},{2,5,8},{3,6,9}};
        System.out.println(largest_sum_per_column(numbers));
    }

    public static int largest_sum_per_column(float[][] numbers){
        if (numbers.length > 0){
            float[] averages = new float[numbers[0].length];
            for (int i = 0; i < numbers[0].length; i++){
                float sum = 0;
                for (float[] number : numbers) {
                    sum += number[i];
                }
                averages[i] = sum / numbers.length;
            }
            float max = Float.MIN_VALUE;
            int index = -1;
            for(int i = 0; i < averages.length; i++){
                if(averages[i] > max){
                    max = averages[i];
                    index = i;
                }
            }
            return index;
        }

        return -1;
    }
}