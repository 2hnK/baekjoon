import java.util.Scanner;

public class Main {

    public static int counting(int a, int b) {
        int cnt = 0;

        for (int i = a; i <= b; i++) {
            if(i==2) cnt += 2;
            for (int j = 2; j < i; j++) {
                if((i % j) == 0)
                    break;
                else if(j == i-1)
                    cnt += i;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int res = counting(a, b);
        System.out.println(res);
    }
}