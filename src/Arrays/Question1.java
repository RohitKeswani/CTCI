package Arrays;

public class Question1 {
    public boolean isUnique(String s){
        s = s.toLowerCase();
        //as maximum unique character string can only be 128, ASCII values.
        if(s.length()>128){
            return false;
        }
        int[] visited = new int[128];
        for(int i = 0; i < s.length();i++)
        {
            int current = s.charAt(i);
            if(visited[current]>0)
            {
                return false;
            }
            else
            {
                visited[current]++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "go 2 hel";
        System.out.println(new Question1().isUnique(s));
    }
}
