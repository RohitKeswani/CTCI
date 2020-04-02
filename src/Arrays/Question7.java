package Arrays;

public class Question7 {
    static int[][] arr = {{1,2,3},{4,5,6}, {7,8,9}};
    public static void main(String[] args) {
        //with help of another array
        System.out.println("With help of another array");
        int[][] rotatedArray = rotateArray(arr);
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[0].length;j++)
                System.out.print(rotatedArray[i][j]+"\t");
            System.out.println();
        }
        //rotate in place
        System.out.println("Updating in same array");
        rotateArrayInPlace(arr);
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[0].length;j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println();
        }
    }

    private static void rotateArrayInPlace(int[][] arr) {
        //transpose then reverse each row
        transpose(arr);
        reverseRows(arr);
    }

    private static void reverseRows(int[][] arr) {
        int n = arr[0].length;
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j<arr[0].length/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
    }

    private static void transpose(int[][] arr) {
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr[0].length; j++){
                if(i!=j){
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
    }

    private static int[][] rotateArray(int[][] arr) {
        int[][] rotatedArray = new int[arr.length][arr[0].length];
        int N = arr.length;
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                rotatedArray[j][N-i-1] = arr[i][j];
            }
        }
        return rotatedArray;
    }

}
