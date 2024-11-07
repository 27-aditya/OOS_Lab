import java.util.ArrayList;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getSessionManager();   
        
        sessionManager.login("admin", "admin");
        sessionManager.login("asd", "123");
    }
}

class SessionManager {
    
    private static SessionManager sessionManager = new SessionManager();

    ArrayList<UserInfo> users = new ArrayList<>(Arrays.asList(new UserInfo("admin", "admin"), new  UserInfo("user", "user")));

    private SessionManager(){}

    public static SessionManager getSessionManager(){
        return sessionManager;
    }

    public int login(String username, String password){
        for(UserInfo user : users){
            if(user.password == password && user.username == username){ 
                System.out.println("Login Succesful");
                return 0;
            }
        }
        System.out.println("Login failed: User does not exists");
        return 1;
    }
}

class UserInfo{
    String username;
    String password;

    public UserInfo(String username, String password){
        this.username = username;
        this.password = password;
    }
}