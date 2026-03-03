import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, res;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 자릿수
        res = 0;

        int[] arr = { 2, 3, 5, 7 };

        for (int oneDigit : arr) {
            dfs(oneDigit, 1);
        }
        System.out.println(sb);
    }

    private static void dfs(int num, int depth) {
        if (depth == N) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int temp = num * 10 + i;
            if (isPrime(temp)) {
                dfs(temp, depth + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        boolean flag = true;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }

}
