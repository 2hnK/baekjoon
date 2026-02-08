import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 상호의 배틀필드 */
public class Solution {

    static int H, W, N, r, c, dir;
    static char[][] map;
    static char[] shape = { '^', 'v', '<', '>' };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            dir = 0;
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String line = br.readLine();

                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);

                    if ("^v<>".contains(map[i][j] + "")) {
                        r = i;
                        c = j;
                    }

                    switch (map[i][j]) {
                        case '^':
                            dir = 0;
                            break;
                        case 'v':
                            dir = 1;
                            break;
                        case '<':
                            dir = 2;
                            break;
                        case '>':
                            dir = 3;
                            break;
                    }
                }
            }
            Tank tank = new Tank(r, c, dir);

            N = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (char c : commands.toCharArray()) {
                if ("UDLR".contains(c + ""))
                    tank.move(c);
                else if (c == 'S')
                    tank.shoot();
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                sb.append(map[i]);
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Tank {
        int r, c, dir; // dir:0123 상하좌우
        int[] dr = { -1, 1, 0, 0 }; // 상하좌우
        int[] dc = { 0, 0, -1, 1 };

        Tank(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        public void move(char command) {
            int nr = 0, nc = 0;
            switch (command) {
                case 'U':
                    dir = 0;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                    break;
                case 'D':
                    dir = 1;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                    break;
                case 'L':
                    dir = 2;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                    break;
                case 'R':
                    dir = 3;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                    break;
            }

            if ((nr >= 0 && nr < H && nc >= 0 && nc < W)
                    && map[nr][nc] == '.') {
                map[r][c] = '.';
                r = nr;
                c = nc;
            }
            map[r][c] = shape[dir];
        }

        public void shoot() {
            int br = r, bc = c;
            while (true) {
                br += dr[dir];
                bc += dc[dir];

                // 장외
                if (br < 0 || br >= H || bc < 0 || bc >= W)
                    break;

                // 벽돌
                if (map[br][bc] == '*') {
                    map[br][bc] = '.';
                    break;
                }

                if (map[br][bc] == '#')
                    break;
            }
        }
    }
}
