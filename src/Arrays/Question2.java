package Arrays;

import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "lloeh";
        System.out.println(new Question2().checkAnagram(s1,s2));
    }

    private boolean checkAnagram(String s1, String s2) {
        return sort(s1).equals(sort(s2));
    }

    private String sort(String s) {
        char[] tempArray = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
