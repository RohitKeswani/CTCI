package Arrays;

public class Question6 {
    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        System.out.println(compressString(s1));
    }

    private static String compressString(String s1) {
        char prev = ' ';
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i<s1.length();i++){
            char curr = s1.charAt(i);
            if(curr!=prev){
                if(count!=0){
                    sb.append(count);
                    count = 0;
                }
                sb.append(curr);
                count++;
                prev = curr;
            }
            else{
                count++;
            }
        }
        sb.append(count);
        if(sb.toString().length() < s1.length())
            return sb.toString();
        else
            return s1;
    }

}
