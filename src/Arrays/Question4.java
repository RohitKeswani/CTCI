package Arrays;

import java.util.HashMap;

public class Question4 {
    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println(checkIfPermuationIsPallindrome(str));

    }

    private static boolean checkIfPermuationIsPallindrome(String str) {
        boolean foundOdd = false;
        str = str.toLowerCase();
        HashMap<Character, Integer> countChars = new HashMap<>();
        for(int i = 0; i<str.length();i++)
        {
            char temp = str.charAt(i);
            if('a'<= temp && temp <='z')
                countChars.put(str.charAt(i), countChars.getOrDefault(str.charAt(i),0)+1);
        }
        for(int i: countChars.values())
            if(i%2 == 0)
                continue;
            else
                if(foundOdd)
                {
                    return false;
                }
                else
                {
                    foundOdd = true;
                }
        return true;
    }
}
