import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];

        for (int row = 0; row < arr.length; row++) { //Cycles through rows
            for (int col = 0; col < arr[row].length; col++) { //Cycles through columns

                if (col == n / 2 || row == n / 2 || col == row || col == n - (row + 1)) {
                    arr[row][col] = '*';
                } else {
                    arr[row][col] = '.';
                }
                System.out.printf("%c ", arr[row][col]);
            }
            System.out.println(); //Makes a new row
        }
    }
}