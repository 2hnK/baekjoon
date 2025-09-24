import java.util.Scanner;

public class Main {

    public static Boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int res = 0;
        for(int i = a; i <= b; i++) {
            if(isPrime(i))
                res += i;
        }
        System.out.println(res);
    }
}