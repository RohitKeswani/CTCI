package Arrays;

public class Question5 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "ba";
        System.out.println(checkOneEdit(s1.toLowerCase(), s2.toLowerCase()));
    }

    private static boolean checkOneEdit(String s1, String s2) {
        if (s1.length() == s2.length())
            return checkOneReplace(s1, s2);
        if (s1.length() + 1 == s2.length())
            return checkOneInsert(s1, s2);
        if (s1.length() - 1 == s2.length())
            return checkOneInsert(s2, s1);
        return false;
    }

    private static boolean checkOneReplace(String s1, String s2) {
        boolean foundDifference = false;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < s1.length() && idx2 < s2.length()) {
            if (s1.charAt(idx1) != s2.charAt(idx2)) {
                if (foundDifference) {
                    return false;
                } else
                    foundDifference = true;
            }
            idx1++;
            idx2++;
        }
        return true;
    }

    private static boolean checkOneInsert(String s1, String s2) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < s1.length() && idx2 < s2.length()) {
            if (s1.charAt(idx1) != s2.charAt(idx2)) {
                if (idx1 != idx2) {
                    return false;
                }
                idx2++;
            } else {
                idx1++;
                idx2++;
            }
        }
        return true;
    }
}
