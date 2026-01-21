import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int s = 0, e = N - 1;
        int sum = arr[s] + arr[e];
        while (s != e) {
            if (sum == M) {
                cnt++;
                e--;
            } else if (sum < M) {
                s++;
            } else {
                e--;
            }
            sum = arr[s] + arr[e];
        }

        System.out.print(cnt);
    }
}