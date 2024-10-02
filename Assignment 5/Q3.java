import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.nextLine();
        int comp = scanner.nextInt();

        if(shape.equals("Circle")){
            Circle c = new Circle();
            System.out.println(c.area(comp));
        }
        else{
            Square sq = new Square();
            System.out.println(sq.area(comp));
        }
    }
}

interface ShapeArea{
    int area(int component);
}

class Circle implements ShapeArea{
    private static final double PI = 3.14F;

    public int area(int radius){
        return (int)(PI*radius*radius);
    }
}

class Square implements ShapeArea{

    public int area(int length){
        return (int)length*length;
    }
}