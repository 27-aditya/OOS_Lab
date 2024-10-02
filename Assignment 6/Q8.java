public class Q8 {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        Event concert = new Concert("Summer Music Festival", 100, "The Jazz Band");
        Event play = new TheaterPlay("Shakespeare's Hamlet", 50, "John Doe");
        Event sports = new SportsGame("City Derby", 200, "Team A vs Team B");

        manager.addEvent(concert);
        manager.addEvent(play);
        manager.addEvent(sports);

        manager.bookEventTickets("Summer Music Festival", 10);
        manager.cancelEventTickets("Shakespeare's Hamlet", 5);

        manager.displayAllEvents();
    }
}

interface Event {
    String getEventName();
    int getAvailableTickets();
    boolean bookTickets(int numberOfTickets);
    boolean cancelTickets(int numberOfTickets);
}

class Concert implements Event {
    private String eventName;
    private int totalTickets;
    private int availableTickets;
    private String performer;

    public Concert(String eventName, int totalTickets, String performer) {
        this.eventName = eventName;
        this.totalTickets = totalTickets;
        this.availableTickets = totalTickets;
        this.performer = performer;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public int getAvailableTickets() {
        return availableTickets;
    }

    @Override
    public boolean bookTickets(int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            availableTickets -= numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelTickets(int numberOfTickets) {
        if ((availableTickets + numberOfTickets) <= totalTickets) {
            availableTickets += numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Concert: " + eventName + ", Performer: " + performer + ", Available Tickets: " + availableTickets;
    }
}

class TheaterPlay implements Event {
    private String eventName;
    private int totalTickets;
    private int availableTickets;
    private String director;

    public TheaterPlay(String eventName, int totalTickets, String director) {
        this.eventName = eventName;
        this.totalTickets = totalTickets;
        this.availableTickets = totalTickets;
        this.director = director;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public int getAvailableTickets() {
        return availableTickets;
    }

    @Override
    public boolean bookTickets(int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            availableTickets -= numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelTickets(int numberOfTickets) {
        if ((availableTickets + numberOfTickets) <= totalTickets) {
            availableTickets += numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Theater Play: " + eventName + ", Director: " + director + ", Available Tickets: " + availableTickets;
    }
}

class SportsGame implements Event {
    private String eventName;
    private int totalTickets;
    private int availableTickets;
    private String teamNames;

    public SportsGame(String eventName, int totalTickets, String teamNames) {
        this.eventName = eventName;
        this.totalTickets = totalTickets;
        this.availableTickets = totalTickets;
        this.teamNames = teamNames;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public int getAvailableTickets() {
        return availableTickets;
    }

    @Override
    public boolean bookTickets(int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            availableTickets -= numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelTickets(int numberOfTickets) {
        if ((availableTickets + numberOfTickets) <= totalTickets) {
            availableTickets += numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sports Game: " + eventName + ", Teams: " + teamNames + ", Available Tickets: " + availableTickets;
    }
}

class EventManager {
    private java.util.List<Event> events = new java.util.ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public boolean bookEventTickets(String eventName, int numberOfTickets) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event.bookTickets(numberOfTickets);
            }
        }
        System.out.println("Event not found: " + eventName);
        return false;
    }

    public boolean cancelEventTickets(String eventName, int numberOfTickets) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event.cancelTickets(numberOfTickets);
            }
        }
        System.out.println("Event not found: " + eventName);
        return false;
    }

    public void displayAllEvents() {
        for (Event event : events) {
            System.out.println(event.toString());
        }
    }
}
