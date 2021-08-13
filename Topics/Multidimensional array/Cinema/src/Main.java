import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();
        String[][] cinema = new String[rows][seats];

        int adjacentCounter;
        int rowIndex = 0;

        //create "cinema" matrix"
        for (int r = 0; r < rows; r++) {
            for (int s = 0; s < seats; s++) {
                cinema[r][s] = scanner.next();

            }
        }

        //find consecutive seats, k
        int k = scanner.nextInt();

        if (k > seats) {
            System.out.println(rowIndex);
            System.exit(0);


        }


        loop:
        for (int row = 0; row < cinema.length; row++) { //Cycles through rows
            adjacentCounter = 1;
            for (int col = 0; col < cinema[row].length - 1; col++) { //Cycles through columns

                if ("0".equals(cinema[row][col + 1]) && k == 1) {
                    rowIndex = row + 1;
                    break loop;
                }

                if ("0".equals(cinema[row][col]) && "0".equals(cinema[row][col + 1])) {
                    adjacentCounter++;

                }
                if ("0".equals(cinema[row][col]) && "1".equals(cinema[row][col + 1])) {
                    adjacentCounter = 1;
                    continue;
                }

                if (adjacentCounter == k) {
                    rowIndex = row + 1;
                    break loop;
                }

            }

        }
        System.out.println(rowIndex);

    }

}

