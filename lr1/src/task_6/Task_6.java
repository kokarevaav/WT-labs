package task_6;

import java.util.Arrays;

public class Task_6 {

    public static void main(String[] args) {
        int[] elementsArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        buildMatrix(elementsArr.length, elementsArr);
    }

    private static void buildMatrix(int size, int[] elementsArr){
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = elementsArr;
            int elementToShift = elementsArr[0];
            elementsArr = Arrays.copyOfRange(elementsArr, 1, elementsArr.length + 1);
            elementsArr[elementsArr.length - 1] = elementToShift;
        }

        Arrays.stream(matrix).forEach(ints -> {
            Arrays.stream(ints).forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
    }
}
