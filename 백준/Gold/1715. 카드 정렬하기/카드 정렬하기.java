import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        long res = 0;
        while (pq.size() > 1) {
            int deck1 = pq.poll();
            int deck2 = pq.poll();

            res += deck1 + deck2;
            pq.add(deck1 + deck2);
        }
        System.out.println(res);
    }

}
