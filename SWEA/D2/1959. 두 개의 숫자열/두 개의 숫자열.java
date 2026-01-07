import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A_i = new int[N];
            int[] B_j = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A_i[i] = Integer.parseInt(st.nextToken());
            } // init A_i

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B_j[i] = Integer.parseInt(st.nextToken());
            } // init B_j

            int k = Math.abs(A_i.length - B_j.length) + 1;
            int max = 0;

            for (int i = 0; i < k; i++) {
                int len = 0;
                int temp = 0;

                if (A_i.length < B_j.length) {
                    len = A_i.length;
                    temp = multiply(A_i, Arrays.copyOfRange(B_j, i, i + len));
                } else {
                    len = B_j.length;
                    temp = multiply(B_j, Arrays.copyOfRange(A_i, i, i + len));
                }
                max = (max < temp ? temp : max);
            }

            System.out.printf("#%d %d\n", testcase, max);
        } // end of testcase
    }

    private static int multiply(int[] A, int[] B) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[i];
        }

        return sum;
    }
}
