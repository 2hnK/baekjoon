import java.util.Scanner;
public class Main {

    public static int counting(int A, int B) {
        int cnt = 0;
        String str = "";

        for(int i = A; i <= B; i++) {
            // 3의 배수인가?
            if(i % 3 == 0){
                cnt += 1;
                continue;
            }

            // 각 자리수에 3, 6, 9가 포함되어 있는가?
            str = String.valueOf(i);
            if(str.contains("3") || str.contains("6") || str.contains("9"))
                cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.
        int res = counting(A, B);
        System.out.println(res);
    }
}