package task_8;

public class Main {

    static int[] aSequence = { 1,3,5,7,9,21 };
    static int[] bSequence = { 2,4,6,12,19,20 };

    public static void main(String[] args) {
        printInsertionIndexes(aSequence, bSequence);
    }

    private static void printInsertionIndexes(int[] aSequence, int[] bSequence){
        for (int i = 0; i < aSequence.length; i++) {
            boolean flagIns = true;
            for (int j = 0; j < bSequence.length; j++) {
                if (aSequence[i] < bSequence[j]) {
                    System.out.printf("Insert aSequence[%d] before bSequence[%d]\n", i, j);
                    flagIns = false;
                    break;
                }
            }
            if (flagIns)
                System.out.printf("Insert aSequence[%d] after last bSequence element\n", i);
        }
    }
}
