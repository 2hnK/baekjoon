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

        // System.out.println(pq);

        int res = 0;
        int i = 1;
        while (pq.size() > 0) {
            // System.out.println("#" + i++);
            int v1 = pq.poll();
            // System.out.println("v1: " + v1);
            if (pq.size() == 0) {
                res += v1;
                break;
            }

            // 최솟값이 음수인 경우
            if (v1 < 0) {
                if (pq.peek() <= 0) { // 다음 값이 0 이하인 경우
                    int v2 = pq.poll();
                    // System.out.println("v2: " + v2);
                    res += v1 * v2;
                } else if (pq.peek() > 0) { // 다음 값이 양수인 경우
                    res += v1;
                }
            }
            // 최솟값이 0인 경우
            else if (v1 == 0) {
                res += v1;
            }
            // 최솟값이 양수인 경우
            else if (v1 == 1) {
                res += v1;
            } else {
                if (pq.size() % 2 == 0) { // 남은 값이 홀수 개인 경우
                    res += v1;
                } else {
                    int v2 = pq.poll();
                    // System.out.println("v2: " + v2);
                    res += v1 * v2;

                }
            }
        }

        System.out.println(res);
    }

}
