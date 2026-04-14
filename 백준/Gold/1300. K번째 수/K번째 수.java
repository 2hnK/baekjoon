import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        long start = 1;
        long end = K;
        long res = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count >= K) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(res);
    }

}
