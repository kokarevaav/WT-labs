package task_9;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    public static void main(String[] args) {
        List<Ball> basket = new ArrayList<>();

        basket.add(new Ball("Red", 4.1));
        basket.add(new Ball("Blue", 3.2));
        basket.add(new Ball("Orange", 2.1));
        basket.add(new Ball("Red", 5.4));
        basket.add(new Ball("Blue", 4.1));
        basket.add(new Ball("Purple", 6.2));
        basket.add(new Ball("Blue", 1.0));

        System.out.printf("Blue balls amount: %d\n", findBlueBallsAmount(basket));
        System.out.printf("Total weight: %.1f", findWeight(basket));
    }

    private static double findWeight(List<Ball> basket){
       return basket.stream().mapToDouble(ball -> ball.weight).sum();
    }

    private static long findBlueBallsAmount(List<Ball> basket){
        return basket.stream().filter(
                ball -> ball.color.equals("Blue")
        ).count();
    }
}
