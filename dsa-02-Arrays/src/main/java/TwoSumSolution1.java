import java.util.Arrays;

public class TwoSumSolution1 {
    public static void main(String[] args) {

        int[] array = new int[]{5,5,6,4,11};
        int[] result = twoSumSolution1(array,10);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSumSolution1(int[] array, int target){

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] != array[j]) {
                    if (array[i] + array[j] == target) {
                        return new int[]{array[i], array[j]};
                    }

                }
            }

        }


        return new int[]{};
    }
}
