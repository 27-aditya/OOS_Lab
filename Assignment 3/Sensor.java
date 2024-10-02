import java.util.ArrayList;
import java.util.Scanner;

//Q5.java

public class Sensor {
    private int sensorId;
    private String sensorType;
    private boolean isActive;

    public Sensor(String sensorType){
        this.isActive = true;
        this.sensorType = sensorType;
        this.sensorId = (int) (Math.random()*100000);
    }

    public void displayDetails(){
        System.out.println("sensorId: "+ sensorId);
        System.out.println("sensorType: "+ sensorType);
        System.out.println("isActive" + isActive);
    }

    public static void main(String[] args){
        ArrayList<Sensor> sensors = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add sensor");
            System.out.println("2. Display");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("sensorType: ");
                    String sensorType = sc.nextLine();
                    sensors.add(new Sensor(sensorType));
                    break;
                case 2:
                    for(Sensor sensor : sensors)
                        sensor.displayDetails();
                    break;
                case 3:
                    sc.close();
                    return;
            }
        }
    }
}
