import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static long res;
    static int[] arr;
    static int[] sumArr;
    static long[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = new long[M];
        sumArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sumArr[i] = (sumArr[i - 1] + arr[i]) % M;
            if (sumArr[i] == 0)
                res++;
            cnt[sumArr[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                res += (cnt[i] * (cnt[i] - 1)) / 2;
            }
        }

        System.out.print(res);
    }
}
