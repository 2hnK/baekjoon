import java.util.Scanner;
public class Main {
    public static int sumUntilX(int x) {
        int sum = 0;
        for(int i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int sum = sumUntilX(n);
        int result = sum / 10;
        System.out.println(result);
    }
}