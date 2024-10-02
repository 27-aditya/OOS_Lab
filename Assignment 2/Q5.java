public class Q5 {
    public static void main(String[] args) {
        String ip = "Holla";
        Solution S = new Solution();
        String ans = S.revString(ip);
        System.out.println(ans);
    }
}

class Solution {
    // Recursive string reverse 
    public String revString(String ip) {
        int n = ip.length();
        char[] charArr = ip.toCharArray();
        reverse(charArr, 0, n - 1);
        return new String(charArr);
    }

    // Recursive swap function for char
    private void reverse(char[] charArr, int l, int r) {
        if (l < r) {
            char temp = charArr[l];
            charArr[l] = charArr[r];
            charArr[r] = temp;
            reverse(charArr, l + 1, r - 1);
        }
    }
}


