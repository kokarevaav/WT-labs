package task_3;

public class Task_3 {

    private static final double A = 3.1;
    private static final double B = 5.9;
    private static final double H = 0.2;

    public static void main(String[] args) {
        System.out.print("a: " + A);
        System.out.print("b: " + B);
        System.out.print("h: " + H);

        countFunction();
    }

    private static void countFunction(){
        System.out.printf("| %-10s | %-12s |%n", "X", "F(x) = tg(x)");
        double x = A;
        while (x < B) {
            double result = Math.tan(x);
            System.out.printf("| %-10f | %-12f |%n", x, result);
            x += H;
        }
    }
}
