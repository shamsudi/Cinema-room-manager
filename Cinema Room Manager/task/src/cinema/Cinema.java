package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Create Cinema layout
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();
        String[][] room = createMatrix(rows, seats);
        int sold; // get the ticket price everytime is purchased
        int counter = 0;
        int [] currentSold = new int [rows*seats]; // store all ticket prices as they are purchased

        int menuOption;
        do {

            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");

            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    printCinema(room);
                    break;
                case 2:
                    sold = bookTicket(room);
                    currentSold[counter] = sold;
                    counter++;
                    break;
                case 3:
                    showStatistics(room, currentSold);
                    break;
                case 0:
                    return;

            }

        } while (true);


    }

    private static int calcCurrentIncome(int[] currentSold) {
        int sum = 0;
        for( int i : currentSold) {
            sum += i;
        }

        return sum;
    }

    private static int calcTotalIncome(String[][] room) {
        int totalIncome;
        int roomRows = (room.length -1);
        int roomSeats = (room[0].length -1 );
        int roomSize = roomSeats * roomRows;
        int frontRows = roomRows / 2;
        int backRows =  roomRows - frontRows;


        if (roomSize <= 60) {
            totalIncome = roomSize * 10;
        } else {
            int frontRowIncome = 10 * frontRows * roomSeats;
            int backRowIncome = 8* backRows * roomSeats;

            totalIncome = frontRowIncome + backRowIncome;
        }
        return  totalIncome;
    }

    private static double calcOccupancy(int ticketsSold, String[][] room) {

        return ((double) ticketsSold / ((room.length -1) * (room[0].length -1)) * 100);
    }

    private static int checkTicketsSold(String[][] room) {
        int ticketsSold = 0;


        for (String[] strings : room) { //Cycles through rows
            for (String string : strings) { //Cycles through columns
                if ("B".equals(string)) {
                    ticketsSold++;
                }

            }
        }

        return ticketsSold;
    }

    private static void showStatistics(String[][] room, int[] currentSold) {

        int ticketsSold = checkTicketsSold(room);
        double occupancy = calcOccupancy(ticketsSold, room);
        int currentIncome  = calcCurrentIncome(currentSold);
        int totalIncome = calcTotalIncome(room);


        System.out.printf(" Number of purchased tickets: %d \n Percentage: %.2f%% \n Current income: $%d \n Total income: $%d \n",
                ticketsSold,
                occupancy,
                currentIncome,
                totalIncome);

        System.out.println();
    }

    private static void printCinema(String[][] room) {

        System.out.println("Cinema:");

        for (String[] strings : room) { //Cycles through rows
            for (String string : strings) { //Cycles through columns

                System.out.printf("%s ", string);
            }
            System.out.println(); //Makes a new row
        }
        System.out.println();
    }

    private static int bookTicket(String[][] room) {
        int ticketValue = 0;
        boolean seatTaken = true;

        while (seatTaken) {

            System.out.println("Enter a row number: ");
            Scanner sc =  new Scanner(System.in);
            int rowNum = sc.nextInt();
            System.out.println("Enter a seat number in that row: ");
            int seatNum = sc.nextInt();

            if (rowNum < 0 || rowNum > room[0].length - 1 || seatNum < 0 || seatNum > room.length - 1) {
                System.out.println("Wrong input! \n");

            } else if ("B".equals(room[rowNum][seatNum])) {

                System.out.println("That ticket has already been purchased! \n");

            } else {
                room[rowNum][seatNum] = "B";
                ticketValue = calcPrice(room,rowNum);
                seatTaken = false;
            }

        }

        return ticketValue;
    }

    private static int calcPrice(String[][] room, int rowsNum) {
        int totalSeats = (room.length -1) * (room[0].length -1);
        int frontRows = (room[0].length -1) / 2;
        int ticketPrice;


        if (totalSeats <= 60) {

            ticketPrice = 10;
            System.out.println("Ticket price: " + "$"+(ticketPrice));
            System.out.println();

        } else if (rowsNum <= frontRows) {
            ticketPrice = 10;
            System.out.println("Ticket price: " + "$"+(ticketPrice));
            System.out.println();
        } else {
            ticketPrice = 8;
            System.out.println("Ticket price: " + "$"+(ticketPrice));
            System.out.println();
        }
        return ticketPrice;
    }

    private static String[][] createMatrix(int r, int s) {
        String[][] cinema = new String[r + 1][s + 1];
        System.out.println("Cinema:");
        for (int row = 0; row < cinema.length; row++) { //Cycles through rows
            for (int col = 0; col < cinema[row].length; col++) { //Cycles through columns

                if (row == 0 && col == 0) {
                    cinema[row][col] = " ";
                } else if (row == 0) {
                    cinema[row][col] = String.valueOf(col);
                } else if (col == 0) {
                    cinema[row][col] = String.valueOf(row);

                } else {
                    cinema[row][col] = "S";
                }
                //System.out.printf("%s ", cinema[row][col]);
            }
            //System.out.println(); //Makes a new row
        }

        return cinema;
    }
}