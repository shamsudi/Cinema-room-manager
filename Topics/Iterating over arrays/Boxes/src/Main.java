import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        int b1Bigger = 0;
        int b2Bigger = 0;

        for (int i = 0; i < box1.length; i++) {
            box1[i] = sc.nextInt();
        }

        for (int i = 0; i < box2.length; i++) {
            box2[i] = sc.nextInt();
        }
        Arrays.sort(box1);
        Arrays.sort(box2);

        if (box1[0] > box2[0]) {
            b1Bigger++;
        } else if (box2[0] > box1[0]) {
            b2Bigger++;
        }
        if (box1[1] > box2[1]) {
            b1Bigger++;
        } else if (box2[1] > box1[1]) {
            b2Bigger++;
        }
        if (box1[2] > box2[2]) {
            b1Bigger++;
        } else if (box2[2] > box1[2]) {
            b2Bigger++;
        }


        if (b1Bigger == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (b2Bigger == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }



    }
}