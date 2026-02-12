import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 나무 높이 */
public class Solution {

    static int N, res, maxHeight, totalSubHeight, odd, even;
    static int[] tree, subHeight;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            tree = new int[N];
            subHeight = new int[N];
            maxHeight = Integer.MIN_VALUE;
            even = odd = res = 0;

            // 나무 높이 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, tree[i]);
            }

            // 각 나무의 부족한 높이 계산
            for (int i = 0; i < N; i++) {
                subHeight[i] = maxHeight - tree[i];

                // 부족한 높이를 짝수, 홀수로 분리
                even += (subHeight[i] / 2);
                odd += (subHeight[i] % 2);
            }

            // 쉬는 날 최소화
            while (even > odd + 1) {
                even--;
                odd += 2;
            }

            if (odd > even) {
                res = odd * 2 - 1;
            } else if (even > odd) {
                res = even * 2;
            } else if (even == odd) {
                res = odd + even;
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // end of tc

        System.out.println(sb);
    }
}
/*
 * Q. 모든 나무의 높이가 가장 높은 나무의 높이와 같아지는 최소 일수를 구하는 문제.
 * 가장 최단 시간에 모든 나무를 맞추기 위해서는 쉬지 않고 매일 나무에게 물을 주어야 한다.
 * 따라서 홀수일에 물을 주는 날과 짝수일에 물을 주는 날의 수가 같거나 최대한 비슷해야 한다.
 * 이를 위해 각 나무의 부족한 높이를 짝수와 홀수로 분리하여 계산하였다.
 * 짝수일은 2만큼 키울 수 있기 때문에 2개의 홀수일로 대체할 수 있기 때문에 짝수와 홀수의 차이를 최소화시킨 후 결과를 계산했다.
 */