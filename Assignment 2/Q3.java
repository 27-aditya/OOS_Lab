import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Check all substrings of the first string

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        scanner.nextLine();  

        String[][] strArray = new String[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter the number of strings in row " + (i + 1) + ": ");
            int cols = scanner.nextInt();
            scanner.nextLine();  

            strArray[i] = new String[cols];

            for (int j = 0; j < cols; j++) {
                System.out.print("Enter string " + (j + 1) + " in row " + (i + 1) + ": ");
                strArray[i][j] = scanner.nextLine();
            }
        }

        for (int i = 0; i < strArray.length; i++) {
            String lcs = findLongestCommonSubstring(strArray[i]);
            if (!lcs.isEmpty()) {
                for (int j = 0; j < strArray[i].length; j++) {
                    strArray[i][j] = strArray[i][j].replaceAll(lcs, lcs.toUpperCase());
                }
            }
        }

        System.out.println("Modified 2D array:");
        for (String[] row : strArray) {
            for (String word : row) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static String findLongestCommonSubstring(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        String firstString = strings[0];
        int len = firstString.length();

        String lcs = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substring = firstString.substring(i, j);

                boolean isCommon = true;
                for (int k = 1; k < strings.length; k++) {
                    if (!strings[k].contains(substring)) {
                        isCommon = false;
                        break;
                    }
                }

                if (isCommon && substring.length() > lcs.length()) {
                    lcs = substring;
                }
            }
        }

        return lcs;
    }
}
