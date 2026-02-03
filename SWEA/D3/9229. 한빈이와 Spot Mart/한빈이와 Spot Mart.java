import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수
            int M = Integer.parseInt(st.nextToken()); // 무게 합 제한
            int[] snacks = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snacks);

            int s = 0, e = N-1, sum = 0, max = -1;
            while (s < e) {
                sum = snacks[s] + snacks[e];

                if (sum == M) {
                    max = M;
                    break;
                } else if (sum < M) {
                    max = Math.max(max, sum);
                    s++;
                } else {
                    e--;
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        } // end of tc
        System.out.print(sb);
    }
}