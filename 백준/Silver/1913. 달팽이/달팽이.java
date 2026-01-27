import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[N][N];
        int[][] arr = new int[N][N];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        int x = 0, y = 0, dir = 0;
        for (int i = N * N; i > 0; i--) {
            arr[x][y] = i;
            visited[x][y] = true;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;

        }
        String temp = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
                if (arr[i][j] == M) {
                    temp = (i + 1) + " " + (j + 1);
                }
            }
            sb.append("\n");
        }
        sb.append(temp);
        System.out.print(sb);
    }
}