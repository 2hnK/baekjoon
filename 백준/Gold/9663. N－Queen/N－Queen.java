import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[] visited_col, visited_s1, visited_s2;
    static int[] select;
    static int N, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited_col = new boolean[N];
        visited_s1 = new boolean[2 * N]; // 대각선 '↘'
        visited_s2 = new boolean[2 * N]; // 대각선 '↙'
        select = new int[N];

        res = 0;
        search(0);

        System.out.println(res);
    }

    static private void search(int r) {
        // 기저조건
        if (r == N) { // depth: 행
            res++;
            return;
        }

        for (int c = 0; c < N; c++) { // 열 탐색
            int v1 = (r - c) + (N - 1);
            int v2 = r + c;

            if (!visited_col[c] && !visited_s1[v1] && !visited_s2[v2]) {
                visited_col[c] = true;
                visited_s1[v1] = true;
                visited_s2[v2] = true;

                search(r + 1);

                visited_col[c] = false;
                visited_s1[v1] = false;
                visited_s2[v2] = false;
            }

        }

    }
}
