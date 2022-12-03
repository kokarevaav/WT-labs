package task_7;

public class ShellSort {

    public static int[] sort(int[] arr) {
        int i = 0;
        while(i < arr.length - 1) {
            if(arr[i] > arr[i + 1]){
                int tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = tmp;
                if(i > 0) {
                    i--;
                }
            }
            else {
                i++;
            }
        }

        return arr;
    }
}
