import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        Arrays.fill(memo, -1);

        int[] D = new int[N + 1];
        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0)
                D[i] = Math.min(D[i], D[i / 2] + 1);
            if (i % 3 == 0)
                D[i] = Math.min(D[i], D[i / 3] + 1);
        }

        System.out.println(D[N]);
        // System.out.println(solve(N));
    }

    public static int solve(int n) {
        if (n == 1)
            return 0;

        if (memo[n] != -1)
            return memo[n];

        int res = solve(n - 1) + 1;
        if (n % 2 == 0) {
            res = Math.min(res, solve(n / 2) + 1);
        }

        if (n % 3 == 0) {
            res = Math.min(res, solve(n / 3) + 1);
        }
        return memo[n] = res;
    }
}
