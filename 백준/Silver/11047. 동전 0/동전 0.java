import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int remain = K;
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (remain < coins[i]) {
                // System.out.println("coins[" + i + "]: skip");
                continue;
            }
            // System.out.println("coins[" + i + "]: " + coins[i]);
            count += remain / coins[i];
            remain %= coins[i];
        }
        System.out.println(count);
    }

}
