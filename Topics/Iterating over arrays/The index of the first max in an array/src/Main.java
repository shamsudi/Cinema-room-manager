import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc =  new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        int largest = 0;

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[largest]) {
                largest = i;

            }
        }
        System.out.println(largest);
    }
}