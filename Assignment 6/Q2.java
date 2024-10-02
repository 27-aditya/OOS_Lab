public class Q2 {
    public static void main(String[] args) {
        TravelApp t = new TravelApp();

        t.bookTransport(23, "3AC");
        t.bookTransport("Main Road", "Mall");
        t.bookTransport(12, "CLT", "BOM");
        t.bookTransport("Mg Road", "Mall", 3);
    }
}

class TravelApp{
    public void bookTransport(int flightNumber, String departureCity, String arrivalCity){
        System.out.println("Flight booked");
    }

    public void bookTransport(int trainNumber, String classOfService){
        System.out.println("Train Booked");
    }

    public void bookTransport(String pickup, String destination, int passengers){
        System.out.println("Cab was booked for "+ passengers + " passengers");
    }

    public void bookTransport(String pickup, String destination){
        System.out.println("Cab was booked");
    }
}