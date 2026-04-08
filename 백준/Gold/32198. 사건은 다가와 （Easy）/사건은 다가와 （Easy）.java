import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 100_000_000;
    static int N, TOTAL_TIME;
    static int[][] T; // [a][b]
    static int[][] memo; // [time][index]

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 메모이제이션 배열
        memo = new int[1001][2001];
        for (int i = 0; i < 1000; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 시간 배열
        T = new int[1001][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            T[t][0] = Integer.parseInt(st.nextToken()) + 1000; // a
            T[t][1] = Integer.parseInt(st.nextToken()) + 1000; // b

            TOTAL_TIME = Math.max(TOTAL_TIME, t);
        }

        // System.out.println(TOTAL_TIME);
        // System.out.println(Arrays.deepToString(T));

        int res = solve(0, 1000);
        if (res < INF)
            System.out.println(res);
        else
            System.out.println(-1);
    }

    private static int solve(int time, int index) {
        // System.out.println("solve(" + time + ", " + index + ") 시작");

        if (index > T[time][0] && index < T[time][1]) {
            return INF;
        }

        if (time > TOTAL_TIME) {
            return 0;
        }

        if (index > T[time][0] && index < T[time][1]) {
            return memo[time][index] = INF;
        }

        if (memo[time][index] != -1)
            return memo[time][index];

        int cost = 1;
        int left = cost + solve(time + 1, index - 1);
        int right = cost + solve(time + 1, index + 1);
        int stand = solve(time + 1, index);

        int res = Math.min(stand, Math.min(left, right));
        return memo[time][index] = res;
    }
}
