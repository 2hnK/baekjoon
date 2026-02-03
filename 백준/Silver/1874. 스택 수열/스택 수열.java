import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ptr = 0;
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            s.push(i + 1);
            sb.append("+").append("\n");

            while (!s.isEmpty() && s.peek() == arr[ptr]) {
                s.pop();
                sb.append("-").append("\n");
                ptr++;
            }
        }

        if (ptr != N) {
            sb.replace(0, sb.length(), "NO");
        }
        System.out.print(sb);
    }
}