package task_2;

import java.util.Scanner;

public class Task_2 {

    static Coordinates upperRectStart = new Coordinates(-4, 0);
    static Coordinates upperRectEnd = new Coordinates(4, 5);
    static Coordinates lowerRectStart = new Coordinates(-6, -3);
    static Coordinates lowerRectEnd = new Coordinates(6, 0);

    public static void main(String[] args) {
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        System.out.print("x: ");
        x = scanner.nextInt();

        System.out.print("y: ");
        y = scanner.nextInt();

        System.out.println(checkPoint(x, y));
    }

    private static boolean checkPoint(int x, int y){
        if ((x>= upperRectStart.x() && x<= upperRectEnd.x())&&(y>= upperRectStart.y() && y<= upperRectEnd.x())){
            return true;
        } else if ((x>=lowerRectStart.x() && x<=lowerRectEnd.x())&&(y>=lowerRectStart.y() && y<=lowerRectEnd.y())){
            return true;
        } else return false;
    }
}

