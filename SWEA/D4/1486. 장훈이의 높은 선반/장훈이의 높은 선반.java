import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int T;
    static int N;
    static int B;
    static int res;
    static int[] heights;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            heights = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            } // init array of staffs

            res = Integer.MAX_VALUE;
            backtrack(0, 0);

            System.out.println("#" + test_case + " " + res);
        } // end of tc
    } // end of main

    private static void backtrack(int cnt, int sum) {
        if (sum - B >= res)
            return;

        if (sum >= B) {
            res = Math.min(res, sum - B);
            return;
        }

        if (cnt == N)
            return;

        backtrack(cnt + 1, sum + heights[cnt]);
        backtrack(cnt + 1, sum);
    }
} // end of class