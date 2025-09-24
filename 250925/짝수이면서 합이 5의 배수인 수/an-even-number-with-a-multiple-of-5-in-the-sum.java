import java.util.Scanner;
public class Main {

    public static Boolean def(int n) {
        if (n%2 != 0)
            return false;
        int xx = n / 10;
        int x = n % 10;
        int sum = x + xx;

        if (sum % 5 == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Boolean b = def(n);
        if (b)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}