package task_5;

import java.util.Arrays;

public class Task_5 {
    private static int[] initialArr = {2,6,1,4,8,9,5,10};

    public static void main(String[] args) {
        System.out.println("Given array");
        Arrays.stream(initialArr).forEach(value -> System.out.print(value + " "));

        System.out.println("\nSubsequence");

        int[] subsequence = findSubsequence(initialArr);
        Arrays.stream(subsequence).filter(value -> value != 0).forEach(value -> System.out.print(value + " "));
    }

    private static int[] findSubsequence(int[] arr){
        int i = 0;
        do {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[j] = 0;
                }
            }
            i++;
        } while (i < arr.length);
        return arr;
    }
}
