// Java program to find the longest repeated
// non-overlapping substring

import java.util.Scanner;
class GFG {
    static String longestRepeatedSubstring(String str) {
        String returnString = null;
        boolean isNumeric = str.chars().allMatch( Character::isDigit );
        if(isNumeric == true){
            returnString = "no null";
            return returnString;
        }
        int n = str.length();
        int LCSRe[][] = new int[n + 1][n + 1];
        String res = "";
        int res_length = 0;
        int i, index = 0;
        for (i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1)
                        && LCSRe[i - 1][j - 1] < (j - i)) {
                    LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;
                    if (LCSRe[i][j] > res_length) {
                        res_length = LCSRe[i][j];
                        index = Math.max(i, index);
                    }
                } else {
                    LCSRe[i][j] = 0;
                }
            }
        }
        if (res_length > 0) {
            for (i = index - res_length + 1; i <= index; i++) {
                res += str.charAt(i - 1);
            }
            if (res.length() >= 2) {
                returnString = "yes" + " " + res;
            }
            else {
                returnString = "no pattern";
            }
        }
        return returnString;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(longestRepeatedSubstring(str));
    }
}
