import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a), absB = Math.abs(b);
            if (absA != absB)
                return absA - absB;
            else // (absA == absB)
                return a - b;
        });

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v != 0) {
                pq.add(v);
                continue;
            }

            if (pq.size() == 0) {
                sb.append("0").append("\n");
                pq.poll();
            } else {
                sb.append(pq.poll()).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
