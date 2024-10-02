import java.util.*;

class Pupil {
    int rollNumber;
    String fullName;
    int weightInKg;
    int heightInCm;
    int teacherId;

    public Pupil(int rollNumber, String fullName, int heightInCm, int weightInKg, int teacherId) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
        this.teacherId = teacherId;
    }

    public void addPupil() {
        System.out.println(fullName + " has been added to the pupil list.");
    }

    static void sortList(Pupil[] pupilList) {
        Pupil temp;
        for (int i = 0; i < pupilList.length - 1; i++) {
            for (int j = i + 1; j < pupilList.length; j++) {
                if (pupilList[i].heightInCm > pupilList[j].heightInCm) {
                    temp = pupilList[i];
                    pupilList[i] = pupilList[j];
                    pupilList[j] = temp;
                }
            }
        }
    }

    static void printPupilList(Pupil[] pupilList, String[] teacherNames) {
        for (int i = 0; i < pupilList.length; i++) {
            System.out.println("Roll Number: " + pupilList[i].rollNumber);
            System.out.println("Full Name: " + pupilList[i].fullName);
            System.out.println("Height: " + (float) pupilList[i].heightInCm);
            System.out.println("Weight: " + (float) pupilList[i].weightInKg);
            System.out.println("Assigned Teacher: " + teacherNames[pupilList[i].teacherId - 1]);
        }
        System.out.println();
    }
}

class Mentor {
    int mentorId;
    String mentorName;

    public Mentor(int mentorId, String mentorName) {
        this.mentorId = mentorId;
        this.mentorName = mentorName;
    }

    static void printMentorList(Mentor[] mentorList, String[] teacherNames) {
        for (int i = 0; i < mentorList.length; i++) {
            System.out.println(mentorList[i].mentorName + " - " + teacherNames[mentorList[i].mentorId - 1]);
        }
    }
}

public class Q8 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] teacherNames = { "Mr. Sabu", "Ms. Jaya", "Dr. Babu" };
        
        System.out.print("Enter the number of pupils to add: ");
        int numberOfPupils = scanner.nextInt();
        Pupil[] pupilList = new Pupil[numberOfPupils];
        
        for (int i = 0; i < numberOfPupils; i++) {
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter height in cm: ");
            int heightInCm = scanner.nextInt();
            System.out.print("Enter weight in kg: ");
            int weightInKg = scanner.nextInt();
            System.out.println("Available teachers:\r\n" + //
                                "1. Mr. Sabu\r\n" + //
                                "2. Ms. Jaya\r\n" + //
                                "3. Dr. Babu");
            System.out.print("Choose a teacher by ID: ");
            int teacherId = scanner.nextInt();
            pupilList[i] = new Pupil(rollNumber, fullName, heightInCm, weightInKg, teacherId);
            pupilList[i].addPupil();
        }

        Pupil.sortList(pupilList);
        Mentor[] mentorList = new Mentor[numberOfPupils];
        for (int i = 0; i < pupilList.length; i++) {
            mentorList[i] = new Mentor(pupilList[i].teacherId, pupilList[i].fullName);
        }

        System.out.println("All pupils sorted by height:");
        Pupil.printPupilList(pupilList, teacherNames);
        System.out.println("Pupil Names and their Assigned Teachers:");
        Mentor.printMentorList(mentorList, teacherNames);
        
        scanner.close();
    }
}
