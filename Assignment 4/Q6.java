public class Q6{
    public static void main(String[] args){
        Tesla T1 = new Tesla();
        T1.start();
    }
}

class Vehicle{
    public void start(){
        System.out.println("Starting the vehicle");
    }
    
}

class Car extends Vehicle{
    public void start(){
        super.start();
        System.out.println("Starting the car");
    }
}

class ElectricCar extends Car{
    public void start(){
        super.start();
        System.out.println("Electric Car is starting");
    }
}

class Tesla extends ElectricCar{
    public void start(){
        super.start();
        System.out.println("Tesla is starting");
    }
}