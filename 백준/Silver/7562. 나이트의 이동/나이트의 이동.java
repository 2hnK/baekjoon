import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int I = Integer.parseInt(br.readLine());
            visited = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tar_r = Integer.parseInt(st.nextToken());
            int tar_c = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{r, c});

            visited[r][c] = 1;
            int depth = 0;

            bfs: 
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int[] cur = queue.poll();
                    int cur_r = cur[0];
                    int cur_c = cur[1];

                    if (cur_r == tar_r && cur_c == tar_c) {
                        break bfs;
                    }

                    for (int j = 0; j < 8; j++) {
                        // 다음 좌표 계산
                        int nr = cur_r + dr[j];
                        int nc = cur_c + dc[j];

                        // 범위 검증
                        if (nr < 0 || nr >= I || nc < 0 || nc >= I)
                            continue;

                        // 방문 여부 확인
                        if (visited[nr][nc] == 1)
                            continue;

                        // Queue에 삽입
                        visited[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
                depth++;
            } // end of while

            System.out.println(depth);
        }
    }
}