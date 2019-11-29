package ua.training;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(100);
        System.out.println(circle.getRadius());
        System.out.println(circle.toString());

        Square square = new Square(50);
        System.out.println(square.getSide());
        System.out.println(square.toString());
    }
}
