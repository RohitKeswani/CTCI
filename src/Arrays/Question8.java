package Arrays;

public class Question8 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}, {0,3,4,6}, {21,89,90,81}, {23, 0, 45, 76}};
        int[][] editedArray = editArray(arr);
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[0].length;j++)
                System.out.print(editedArray[i][j]+"\t");
            System.out.println();
        }
    }

    private static int[][] editArray(int[][] arr) {
        int[][] editedArray = arr;
        boolean[] row = new boolean[arr.length];
        boolean[] col = new boolean[arr[0].length];
        for(int i = 0; i<arr.length;i++)
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        for(int i = 0 ; i< row.length; i++){
            if(row[i]) {
                editedArray= nullifyRow(i, editedArray);
            }
        }
        for(int j = 0; j<col.length; j++){
            if(col[j]){
                editedArray = nullifyCol(j, editedArray);
            }
        }
        return editedArray;
    }

    private static int[][] nullifyCol(int j, int[][] editedArray) {
        for(int i = 0; i<editedArray.length; i++){
            editedArray[i][j] = 0;
        }
        return editedArray;
    }

    private static int[][] nullifyRow(int i, int[][] editedArray) {
        for(int j = 0 ; j < editedArray[i].length; j++){
            editedArray[i][j] = 0;
        }
        return editedArray;
    }

}
