import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int MOD = 1_000_000_000;
    static int N;
    static long[][] memo; // [len][prev]

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        memo = new long[N + 1][10];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }

        long res = 0;
        for (int i = 1; i <= 9; i++) {
            res = (res + solve(1, i)) % MOD;
        }
        System.out.println(res);
    }

    private static long solve(int len, int prev) {
        if (len == N) {
            return 1;
        }

        if (memo[len][prev] != -1)
            return memo[len][prev];

        int count = 0;
        if (prev == 0) {
            count += solve(len + 1, prev + 1) % MOD;
        } else if (prev == 9) {
            count += solve(len + 1, prev - 1) % MOD;
        } else {
            count += (solve(len + 1, prev + 1) + solve(len + 1, prev - 1)) % MOD;
        }

        return memo[len][prev] = count;
    }

}