import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s = Math.max(s, arr[i]);
            e += arr[i];
        }

        while (s <= e) {
            int m = (s + e) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > m) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        System.out.println(s);
    }
}
