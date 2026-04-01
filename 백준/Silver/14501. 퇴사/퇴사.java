import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] T, P, memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];
        memo = new int[N];
        Arrays.fill(memo, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(0));

    }

    private static int solve(int day) {
        // 기저
        if (day >= N)
            return 0;

        // 메모
        if (memo[day] != -1)
            return memo[day];

        // 상담 받지 않는 경우
        int skip = solve(day + 1);

        // 상담 받는 경우
        int take = 0;
        if (day + T[day] <= N)
            take = P[day] + solve(day + T[day]);

        // 리턴
        return memo[day] = Math.max(skip, take);
    }
}
