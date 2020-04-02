package Arrays;

public class Question9 {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        //check is s2 is a rotation of s1 with help of isSubstring
        System.out.println(checkIsRotation(s1,s2));
    }

    private static boolean checkIsRotation(String s1, String s2) {
        String newString = s2+s2;
        return isSubString(s1, newString);
    }

    //creating my own isSubstring method which find the index of new String in s1.
    private static boolean isSubString(String s1, String newString) {
        if(newString.indexOf(s1)>0)
            return true;
        else
            return false;
    }

}
