import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        boolean check  = true;

        for (int i = 0; i < input.length - 1; i++) {

            //System.out.println(input[i].compareTo(input[i+1]));

            if (input[i].compareTo(input[i + 1]) > 0) {
                check = false;
                break;

            }
        }
        System.out.println(check);



    }
}