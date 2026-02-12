import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 장훈이의 높은 선반 */
public class Solution {

    static int N, B, result;
    static int[] clerks;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 점원 수
            B = Integer.parseInt(st.nextToken()); // 선반 높이
            result = Integer.MAX_VALUE;

            clerks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                clerks[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append("#").append(tc).append(" ").append(result - B).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    private static void dfs(int index, int sum) {
        if (sum >= B) {
            result = Math.min(result, sum);
            return;
        }

        if (sum == B || index == N)
            return;

        dfs(index + 1, sum + clerks[index]);
        dfs(index + 1, sum);
    }
}