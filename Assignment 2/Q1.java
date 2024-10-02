public class Q1 {
    // Question Class
    public static void main(String[] args) {
        String ip = "Hello World"; 
        String buffer = "World";
        Solution S = new Solution();
        boolean ans = S.hasStr(ip, buffer);
        System.out.println(ans);    
    }
}

class Solution{
    // Function Class
    public boolean hasStr(String ip, String buffer){
        int bufferl = buffer.length();
        int ipl = ip.length();
        // Go through the string
        for(int i = 0; i <= ipl-bufferl; i++){
            if(buffer.equals(ip.substring(i, i+bufferl)))  // If substring found return true;
                return true;
        }
        return false; // Else return false
    }
}