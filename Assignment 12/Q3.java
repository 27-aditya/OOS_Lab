import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeFactory shapeFactory = new ShapeFactory();

        System.out.println("Input shape type ");
        String shapeName = scanner.nextLine();

        Shape shape = shapeFactory.factoryMethod(shapeName);

        if(shape != null) {
            shape.draw();
        } else {
            System.out.println("Invalid shape");
        }

        scanner.close();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Rectangle");
    }
}

class Triangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Triangle");
    }
}

class ShapeFactory {
    public Shape factoryMethod(String shape){
        if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }
        return null;
    }
}