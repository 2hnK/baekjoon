import java.util.Scanner;

public class Main {
    public static int min(int a, int b, int c) {
        int[] arr = {a, b, c};
        int min = a;
        for(int i = 1; i < arr.length; i++) {
            if(min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        int res = min(a, b, c);
        System.out.println(res);
    }
}