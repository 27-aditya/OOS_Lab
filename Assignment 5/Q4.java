import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfThePost = scanner.nextLine();

        int numberOfCandidates = Integer.parseInt(scanner.nextLine());
        ArrayList<String> listOfCandidates = new ArrayList<>();

        for (int i = 0; i < numberOfCandidates; i++) {
            listOfCandidates.add(scanner.nextLine());
        }

        int numberOfVotes = Integer.parseInt(scanner.nextLine());
        ArrayList<String> votesEntered = new ArrayList<>();

        for (int i = 0; i < numberOfVotes; i++) {
            votesEntered.add(scanner.nextLine());
        }

        ElectionPost electionPost = new ElectionPost(nameOfThePost, listOfCandidates, votesEntered);

        electionPost.display();
        
        electionPost.ascendDisplay();

        electionPost.descendDisplay();

        scanner.close();
    }
}

interface SortVotes {
    void ascendDisplay();
    void descendDisplay();
}

class ElectionPost implements SortVotes {
    private String nameOfThePost; 
    private ArrayList<String> listOfCandidates; 
    private ArrayList<String> votesEntered; 

    public ElectionPost(String nameOfThePost, ArrayList<String> listOfCandidates, ArrayList<String> votesEntered) {
        this.nameOfThePost = nameOfThePost;
        this.listOfCandidates = listOfCandidates;
        this.votesEntered = votesEntered;
    }

    public void display() {
        System.out.println(nameOfThePost);
        Collections.sort(listOfCandidates); 
        for (String candidate : listOfCandidates) {
            System.out.println(candidate);
        }
    }

    public void ascendDisplay() {
        Map<String, Integer> voteCount = countVotes();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteCount.entrySet());
        
        Collections.sort(sortedList, Map.Entry.comparingByValue());
        
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void descendDisplay() {
        Map<String, Integer> voteCount = countVotes();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteCount.entrySet());
        
        Collections.sort(sortedList, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private Map<String, Integer> countVotes() {
        Map<String, Integer> voteCount = new HashMap<>();
        for (String candidate : listOfCandidates) {
            voteCount.put(candidate, 0); 
        }
        for (String vote : votesEntered) {
            voteCount.put(vote, voteCount.get(vote) + 1);
        }
        return voteCount;
    }
}
