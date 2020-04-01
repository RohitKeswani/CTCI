package Arrays;

public class Question3 {
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int trueLength = findLastCharacter(s.toCharArray());
        char[] temp = new Question3().replaceSpaces(s.toCharArray(),trueLength);
        System.out.println(new String(temp));
    }

    private String URLify(String s, int trueLength) {
        //one way to do it
        s = s.trim();
        return s.replace(" ", "%20");
    }

    public char[] replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return str;
    }
    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}
