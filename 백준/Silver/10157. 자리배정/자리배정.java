import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(st.nextToken()); // 가로
        int R = Integer.parseInt(st.nextToken()); // 세로

        int K = Integer.parseInt(br.readLine());

        int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
        int[] dy = { 0, 1, 0, -1 };
        int[][] arr = new int[R + 1][C + 1];
        boolean[][] visited = new boolean[R + 1][C + 1];

        int x = R, y = 1, dir = 0;
        for (int i = 1; i <= C * R; i++) {
            arr[x][y] = i;
            visited[x][y] = true;

            if (arr[x][y] == K) {
                sb.append(y + " " + Math.abs(x - R - 1));
                break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || nx > R || ny < 1 || ny > C || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        } // init array

        if (sb.length() == 0)
            sb.append(0);
        System.out.print(sb);
    }
}