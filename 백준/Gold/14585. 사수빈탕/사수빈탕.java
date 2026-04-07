import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] grid;
    static long[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[301][301];
        memo = new long[301][301];
        for (int i = 0; i <= 300; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grid[x][y] = 1;
        }

        System.out.println(solve(0,0));

    }

    private static long solve(int x, int y) {
        if (x > 300 || y > 300)
            return 0;

        if (memo[x][y] != -1)
            return memo[x][y];

        long cur = 0;
        if (grid[x][y] == 1) {
            cur = Math.max(0, M - (x + y));
        }

        memo[x][y] = Math.max(solve(x + 1, y), solve(x, y + 1)) + cur;

        return memo[x][y];
    }

}
