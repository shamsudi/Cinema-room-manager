import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int row = 0; row < arr.length; row++) { //Cycles through rows
            for (int col = 0; col < arr[row].length; col++) { //Cycles through columns

                if (col == row) {
                    arr[row][col] = 0;
                } else {
                    arr[row][col] = Math.abs(col - row);
                }
                System.out.printf("%d ", arr[row][col]);
            }
            System.out.println(); //Makes a new row
        }
    }
}