import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] memo; // [채운 칸]

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        memo = new long[N + 1];
        Arrays.fill(memo, -1);

        System.out.println(solve(0));
    }

    private static long solve(int len) {
        if (len == N)
            return 1;

        if (len > N)
            return 0;

        if (memo[len] != -1)
            return memo[len];

        memo[len] = (solve(len + 1) + solve(len + 2)) % 10007;

        return memo[len];
    }
}