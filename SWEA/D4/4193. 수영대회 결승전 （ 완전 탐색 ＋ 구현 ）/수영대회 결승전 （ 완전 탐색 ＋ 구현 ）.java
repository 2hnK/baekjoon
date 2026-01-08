import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int startX, startY, endX, endY;
    static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            } // init map, dist

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            int result = bfs();
            System.out.println("#" + testcase + " " + result);

        } // end of testcase
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, 0));
        dist[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.time > dist[cur.x][cur.y])
                continue;
            if (cur.x == endX && cur.y == endY)
                return cur.time;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 1) {
                    int nextTime = cur.time + 1;

                    if (map[nx][ny] == 2) {
                        int wait = (2 - (cur.time % 3));
                        nextTime = cur.time + wait + 1;
                    }

                    if (nextTime < dist[nx][ny]) {
                        dist[nx][ny] = nextTime;
                        pq.add(new Node(nx, ny, nextTime));
                    }
                }
            }
        }

        return -1;
    }

    static class Node implements Comparable<Node> {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}