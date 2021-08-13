import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr =  new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int cond = sc.nextInt();
        int count = 0;

        for (int j : arr) {

            if (j > cond) {
                count = count + j;
            }

        }

        System.out.println(count);
    }
}