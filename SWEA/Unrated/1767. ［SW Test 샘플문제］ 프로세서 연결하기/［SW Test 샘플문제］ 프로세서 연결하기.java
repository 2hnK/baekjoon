import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 프로세서 연결하기 */
public class Solution {

    static int N, coreCnt, maxConnectedCores, minWireLength;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
    static ArrayList<Core> coreList = new ArrayList<>();

    static class Core {
        int row;
        int col;

        public Core(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // 값 초기화
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();
            maxConnectedCores = 0;
            minWireLength = Integer.MAX_VALUE;

            // 맵 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // Core 위치 저장
                    if (map[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) { // 가장자리 코어 제외
                            maxConnectedCores++;
                        } else {
                            coreList.add(new Core(i, j));
                        }
                    }
                }
            }

            dfs(0, maxConnectedCores, 0);

            sb.append("#").append(tc).append(" ").append(minWireLength).append("\n");

        } // end of tc
        System.out.println(sb);
    }

    private static void dfs(int count, int connectedCore, int wireLength) {
        // 기저 조건
        if (count == coreList.size()) {
            // 최대 코어 연결 갱신(전선 길이의 합)
            if (connectedCore > maxConnectedCores) {
                maxConnectedCores = connectedCore;
                minWireLength = wireLength;
            } else if (connectedCore == maxConnectedCores) {
                minWireLength = Math.min(minWireLength, wireLength);
            }
            return;
        }

        Core cur = coreList.get(count);

        // 4방향 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nr = cur.row;
            int nc = cur.col;
            int dist = 0;
            boolean isPossible = false;

            // 방향 및 거리 계산
            while (true) {
                nr += dr[dir];
                nc += dc[dir];

                // 연결 가능한 경우
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    isPossible = true;
                    break;
                }

                // 코어, 전선을 만난 경우
                if (map[nr][nc] != 0)
                    break;

                dist++;
            }

            // 전선 놓기
            if (isPossible) {
                for (int i = 1; i <= dist; i++) {
                    map[cur.row + dr[dir] * i][cur.col + dc[dir] * i] = 2;
                }

                // 다음 코어 탐색
                dfs(count + 1, connectedCore + 1, wireLength + dist);

                // 전선 되돌리기
                for (int i = 1; i <= dist; i++) {
                    int curRow = cur.row + dr[dir] * i;
                    int curCol = cur.col + dc[dir] * i;
                    map[curRow][curCol] = 0;
                }
            }

        }
        // 다음 코어 탐색(전선 놓지 않음)
        dfs(count + 1, connectedCore, wireLength);
    }

}