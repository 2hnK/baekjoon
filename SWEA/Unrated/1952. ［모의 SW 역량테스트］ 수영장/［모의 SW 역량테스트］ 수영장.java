import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 수영장 */
public class Solution {

    static int res;
    static int[] price, plan;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            price = new int[4];
            plan = new int[13];
            res = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    private static void dfs(int month, int current) {
        if (month > 12) {
            res = Math.min(res, current);
            return;
        }

        if (current > res)
            return;

        dfs(month + 1, current + (price[0] * plan[month]));
        dfs(month + 1, current + price[1]);
        dfs(month + 3, current + price[2]);
        dfs(month + 12, current + price[3]);
    }
}
