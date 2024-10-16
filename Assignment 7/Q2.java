class PlatformUser {
    String name;
    String email;
    String userId;

    public PlatformUser(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public void accessPortal() {
        System.out.println("Portal Access:");
    }
}

class Student extends PlatformUser {

    public Student(String name, String email, String userId) {
        super(name, email, userId);
    }

    public void attendLiveSession() {
        System.out.println("- Attending live session.");
    }

    public void viewRecordedLectures() {
        System.out.println("- Viewing recorded lectures.");
    }

    public void submitAssignment() {
        System.out.println("- Submitting assignments online.");
    }

    @Override
    public void accessPortal() {
        super.accessPortal();
        attendLiveSession();
        viewRecordedLectures();
        submitAssignment();
    }
}

class Faculty extends PlatformUser {

    public Faculty(String name, String email, String userId) {
        super(name, email, userId);
    }

    public void conductLiveSession() {
        System.out.println("Conducting live session.");
    }

    public void uploadRecordedLecture() {
        System.out.println("Uploading recorded lecture.");
    }

    public void uploadCourseMaterial() {
        System.out.println("Uploading course material.");
    }

    public void uploadAssignment() {
        System.out.println("Uploading an online assignment for students.");
    }

    @Override
    public void accessPortal() {
        System.out.println("-- Faculty Access --");
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("UserID: " + this.userId);
        super.accessPortal();
        uploadCourseMaterial();
        conductLiveSession();
        uploadAssignment();
    }
}

public class Q2 {
    public static void main(String[] args) {
        Student student = new Student("John Doe", "john@student.com", "STU001");
        Faculty faculty = new Faculty("Dr. Smith", "smith@university.com", "FAC001");

        System.out.println("For student case:");
        student.accessPortal();

        System.out.println();

        faculty.accessPortal();
    }
}
