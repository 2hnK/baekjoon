import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, res;
    static int[] Sender = { 0, 0, 1, 1, 2, 2 };
    static int[] Receiver = { 1, 2, 0, 2, 0, 1 };
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now; // 시작 값

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[201][201];
        answer = new boolean[201];
        now = new int[3];

        for (int i = 0; i < 3; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int z = now[2] - x - y;

            // 경우의 수 탐색
            for (int i = 0; i < 6; i++) {
                int[] next = { x, y, z };
                next[Receiver[i]] += next[Sender[i]];
                next[Sender[i]] = 0;
                if (next[Receiver[i]] > now[Receiver[i]]) {
                    next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                    next[Receiver[i]] = now[Receiver[i]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.offer(new State(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }

    }

    private static class State {
        int x, y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
