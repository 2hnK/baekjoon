import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } // init array

            System.out.printf("#%d\n", testcase);
            printArray(arr, N);
        } // end of testcase
    }

    private static void printArray(int[][] arr, int N) {
        for (int i = 0; i < N; i++) {
            // 90 degree
            for (int j = 0; j < N; j++) {
                System.out.print(arr[N - 1 - j][i]);
            }
            System.out.print(" ");

            // 180 degree
            for (int j = 0; j < N; j++) {
                System.out.print(arr[N - 1 - i][N - 1 - j]);
            }
            System.out.print(" ");

            // 270 degree
            for (int j = 0; j < N; j++) {
                System.out.print(arr[j][N - 1 - i]);
            }
            System.out.println(" ");
        }
    }
}
