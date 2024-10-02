public class Q7{

}

class Vehicle{
    String make;
    String model;
    int year;
    String color;
    int currentSpeed;

    public Vehicle(String make, String model, int year, String color, int currentSpeed){
        this.make = make;
        this.currentSpeed = currentSpeed;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public void accelerate(){
        System.out.println("Accelerating");
    }

    public void brake(){
        System.out.println("Braking");
    }

    public void turnLeft(){
        System.out.println("Turning Left");
    }

    public void turnRight(){
        System.out.println("Turning Right");
    }
}

class Bus extends Vehicle{
    int numSeats;
    String routeNumber;
    boolean doubleDecker;

    public Bus(String model, String make, int year, String color, int currentSpeed, int numSeats, String routeNumber, boolean doubleDecker){
        super(make, model, year, color, currentSpeed);
        this.numSeats = numSeats;
        this.routeNumber = routeNumber;
        this.doubleDecker = doubleDecker;
    }

    public void openDoors(){
        System.out.println("Doors Opened HAha");
    } 

    public void closeDoors(){
        System.out.println("Doors Closed ll");
    }
}

class Car extends Vehicle{
    int numDoors;
    double trunkCapacity;

    public Car(String model, String make, int year, String color, int currentSpeed, int numDoors, double trunkCapacity){
        super(make, model, year, color, currentSpeed);
        this.numDoors = numDoors;
        this.trunkCapacity = trunkCapacity;
    }

    public void openTrunk(){
        System.out.println("Trunk is open lol");
    }

    public void closeTrunk(){
        System.out.println("Trunk is closed");
    }
}

class SUV extends Car{
    boolean offRoadCapability;
    
    public SUV(String model, String make, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, boolean offRoadCapability){
        super(model, make, year, color, currentSpeed, numDoors, trunkCapacity);
        this.offRoadCapability = offRoadCapability;
    }

    public void engage4WD(){
        System.out.println("Activate 4WD");
    }
}

class Sedan extends Car{
    boolean luxuryInterior;

    public Sedan(String model, String make, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, boolean luxuryInterior){
        super(model, make, year, color, currentSpeed, numDoors, trunkCapacity);
        this.luxuryInterior = luxuryInterior;
    }

    public void activateMassageSeats(){
        System.out.println("Massage on");
    }
}

class ElectricCar extends Car{
    int batteryCapacity;

    public ElectricCar(String model, String make, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, int batteryCapacity){
        super(model, make, year, color, currentSpeed, numDoors, trunkCapacity);
        this.batteryCapacity = batteryCapacity;
    }

    public void accelerate(){
        System.out.println("Accelerating On");
    }

    public void chargeBattery(){
        System.out.println("Charging");
    }
}

class SportsCar extends Car{
    int topSpeed;

    public SportsCar(String model, String make, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, int topSpeed){
        super(model, make, year, color, currentSpeed, numDoors, trunkCapacity);
        this.topSpeed = topSpeed;
    }

    public void accelerate(){
        System.out.println("Accelerating");
    }
}
