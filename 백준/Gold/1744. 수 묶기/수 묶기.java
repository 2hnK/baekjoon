import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int res = 0;
        while (pq.size() > 0) {
            int v1 = pq.poll();
            if (pq.size() == 0) {
                res += v1;
                break;
            }

            // 최솟값이 음수인 경우
            if (v1 < 0) {
                if (pq.peek() <= 0) { // 다음 값이 0 이하인 경우
                    int v2 = pq.poll();
                    res += v1 * v2;
                } else { // 다음 값이 양수인 경우
                    res += v1;
                }
            }
            // 최솟값이 0, 1인 경우
            else if (v1 == 0 || v1 == 1) {
                res += v1;
            }
            // 최솟값이 2이상인 경우
            else {
                if (pq.size() % 2 == 0) { // 남은 값이 홀수 개인 경우
                    res += v1;
                } else { // 남은 값이 짝수 개인 경우
                    int v2 = pq.poll();
                    res += v1 * v2;
                }
            }
        }

        System.out.println(res);
    }
}
