import java.util.*;

class Job {
    int priorityLevel;
    String jobName;

    public Job(int priorityLevel, String jobName) {
        this.priorityLevel = priorityLevel;
        this.jobName = jobName;
    }
}

public class Q12 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return Integer.compare(j1.priorityLevel, j2.priorityLevel);
            }
        });

        while (true) {
            System.out.print("Select the operation: ");
            int operation = scanner.nextInt();
            scanner.nextLine();
            switch (operation) {
                case 1: {
                    System.out.println("Add Job with priority and description");
                    String input = scanner.nextLine();
                    String[] parts = input.split(",", 2); 
                    int priorityLevel = Integer.parseInt(parts[0].trim());
                    String jobName = parts[1].trim(); 
                    jobQueue.add(new Job(priorityLevel, jobName));
                    System.out.println("Job added: " + jobName);
                    break;
                }

                case 2: {
                    jobQueue.poll();    
                }

                case 3: {
                    Job job = jobQueue.peek();
                    System.out.println(job.jobName);    
                }

                case 4: {
                    System.exit(0);
                    scanner.close();
                }
            }
        }
    }
}
