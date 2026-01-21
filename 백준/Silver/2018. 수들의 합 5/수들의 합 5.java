import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        } // 배열 초기화

        int s = 1, e = 1, sum = 1, count = 1;
        while (e != N) {
            if (sum == N) {
                count++;
                e++;
                sum += e;
            } else if (sum > N) {
                sum -= s;
                s++;
            } else {
                e++;
                sum += e;
            }
        }
        System.out.print(count);
    }
}
