import java.util.Scanner;

public class Main {
    public static int minValue(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        int res = minValue(a, b, c);
        System.out.println(res);
    }
}