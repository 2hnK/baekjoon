import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // init arr

        int inCnt = 1;
        int deCnt = 1;
        int res = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1])
                inCnt++;
            else
                inCnt = 1;

            if (arr[i] <= arr[i - 1])
                deCnt++;
            else
                deCnt = 1;

            res = Math.max(res, Math.max(inCnt, deCnt));
        }

        System.out.print(res);
    }
}