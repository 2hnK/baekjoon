import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] jump1, jump2;
    static int[][] memo;
    static final int INF = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        jump1 = new int[N];
        jump2 = new int[N];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jump1[i] = Integer.parseInt(st.nextToken());
            jump2[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        memo = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(solve(1, 0));
    }

    private static int solve(int idx, int used) {
        if (idx == N) {
            return 0;
        }

        if (idx > N) {
            return INF;
        }

        if (memo[idx][used] != -1) {
            return memo[idx][used];
        }

        int j1 = INF, j2 = INF, j3 = INF;
        j1 = jump1[idx] + solve(idx + 1, used);
        j2 = jump2[idx] + solve(idx + 2, used);
        if (used == 0)
            j3 = K + solve(idx + 3, 1);

        return memo[idx][used] = Math.min(j1, Math.min(j2, j3));
    }
}