import java.util.*;

public class Q7 {
    static List<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add Vehicle");
            System.out.println("2. Display Vehicles");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    displayVehicles();
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }

    static void addVehicle() {
        System.out.println("a. Car");
        System.out.println("b. Truck");
        System.out.print("Enter your choice: ");
        char type = sc.next().charAt(0);

        System.out.print("ModelNumber: ");
        String modelNumber = sc.next();
        System.out.print("Rate: ");
        double rate = sc.nextDouble();
        System.out.print("FuelType(petrol/diesel): ");
        String fuelType = sc.next();

        if (type == 'a') {
            System.out.print("Passengers: ");
            int passengers = sc.nextInt();
            vehicles.add(new Car(modelNumber, rate, fuelType, passengers));
        } else if (type == 'b') {
            System.out.print("Loadlimit: ");
            double loadLimit = sc.nextDouble();
            vehicles.add(new Truck(modelNumber, rate, fuelType, loadLimit));
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    static void displayVehicles() {
        Collections.sort(vehicles, new Comparator<Vehicle>() {
            public int compare(Vehicle v1, Vehicle v2) {
                return Double.compare(v2.calculateTax(), v1.calculateTax());
            }
        });

        for (Vehicle v : vehicles) {
            System.out.println(v.modelNumber + " " + v.fuelType + " " + (int)v.calculateTax());
        }
    }
}

interface TaxCalculatable {
    double calculateTax();
}

class Vehicle implements TaxCalculatable {
    String modelNumber;
    double rateBought;
    String fuelType;
    int numberOfWheels;

    Vehicle(String modelNumber, double rateBought, String fuelType, int numberOfWheels) {
        this.modelNumber = modelNumber;
        this.rateBought = rateBought;
        this.fuelType = fuelType;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public double calculateTax() {
        return 0;
    }
}

class Car extends Vehicle {
    int numberOfPassengers;

    Car(String modelNumber, double rateBought, String fuelType, int numberOfPassengers) {
        super(modelNumber, rateBought, fuelType, 4);
        this.numberOfPassengers = numberOfPassengers;
    }

    public double calculateTax() {
        if (fuelType.equals("petrol")) {
            return (rateBought * 0.1 * numberOfPassengers) * 0.5;
        } else {
            return (rateBought * 0.1 * numberOfPassengers) * 0.4;
        }
    }
}

class Truck extends Vehicle {
    double loadLimit;

    Truck(String modelNumber, double rateBought, String fuelType, double loadLimit) {
        super(modelNumber, rateBought, fuelType, 6);
        this.loadLimit = loadLimit;
    }

    public double calculateTax() {
        if (fuelType.equals("petrol")) {
            return (rateBought * 0.1 * loadLimit * 0.002) * 0.5;
        } else {
            return (rateBought * 0.1 * loadLimit * 0.002) * 0.4;
        }
    }
}

