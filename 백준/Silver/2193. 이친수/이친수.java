import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        memo = new long[N + 1][2];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(solve(1, 1));
    }

    private static long solve(int len, int lastDigit) {
        if (len == N) {
            return 1;
        }

        if (memo[len][lastDigit] != -1) {
            return memo[len][lastDigit];
        }

        long count = 0;

        if (lastDigit == 0) {
            count += solve(len + 1, 0);
            count += solve(len + 1, 1);
        } else {
            count += solve(len + 1, 0);
        }

        return memo[len][lastDigit] = count;
    }
}