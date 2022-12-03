package task_7;

import java.util.Arrays;

public class Main {

    private static int[] unsortedArr = {2,5,2,55,23,34,4,15,1,67};
    public static void main(String[] args) {
        System.out.print("Initial array: ");
        Arrays.stream(unsortedArr).forEach(value -> System.out.print(value + " "));
        System.out.println();
        int[] sortedArr = ShellSort.sort(unsortedArr);
        System.out.print("Sorted array: ");
        Arrays.stream(sortedArr).forEach(value -> System.out.print(value + " "));
    }
}
