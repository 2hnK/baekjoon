import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            dq.offer(dq.pollFirst());
        }
        System.out.print(dq.peek());
    }
}
