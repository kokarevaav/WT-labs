package task_1;

public class Task_1 {
    public static void main(String[] args) {
        double x = 2.6;

        System.out.println("X: " + x);
        double y = 9.1432;
        System.out.println("Y: " + y);

        System.out.printf("%,.2f", countExpression(x, y));
    }

    private static double countExpression(double x, double y) {
        double numerator = 1 + Math.pow(Math.sin(x + y), 2);
        double denumerator = 2 + Math.abs(countExpressionInDenumerator(x, y));
        return (numerator / denumerator) + x;
    }

    private static double countExpressionInDenumerator(double x, double y) {
        double numerator = 2 * x;
        double denumerator = 1 + (Math.pow(x, 2) * Math.pow(y, 2));
        return x - (numerator / denumerator);
    }
}
