class PlatformUser {
    protected String name;
    protected String email;
    protected String userId;

    public PlatformUser(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public void accessPortal() {
        System.out.println("Accessing the platform portal.");
    }
}

class Student extends PlatformUser {

    public Student(String name, String email, String userId) {
        super(name, email, userId);
    }

    public void attendLiveSession() {
        System.out.println("Attending live session.");
    }

    public void viewRecordedLectures() {
        System.out.println("Viewing recorded lectures.");
    }

    public void submitAssignment() {
        System.out.println("Submitting assignments online.");
    }

    @Override
    public void accessPortal() {
        System.out.println("-- Student Access --");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("UserID: " + userId);
        System.out.println("Portal Access:");
        System.out.println("- Viewing online courses.");
        System.out.println("- Attending live session.");
        System.out.println("- Submitting assignments online.");
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
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("UserID: " + userId);
        System.out.println("Portal Access:");
        System.out.println("- Uploading course material.");
        System.out.println("- Conducting live online lecture.");
    }
}

public class Q2 {
    public static void main(String[] args) {
        Student student = new Student("John Doe", "john@student.com", "STU001");
        student.accessPortal();
        student.attendLiveSession();
        student.viewRecordedLectures();
        student.submitAssignment();

        System.out.println();

        Faculty faculty = new Faculty("Dr. Smith", "smith@university.com", "FAC001");
        faculty.accessPortal();
        faculty.conductLiveSession();
        faculty.uploadCourseMaterial();
        faculty.uploadAssignment();
    }
}
