import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    /* 원자 클래스 */
    static class Atom {
        int x, y, d, e, idx;

        Atom(int x, int y, int d, int e, int idx) {
            this.x = x;
            this.y = y;
            this.d = d; // dir
            this.e = e; // energy
            this.idx = idx;
        }
    }

    /* 충돌 클래스 */
    static class Collision {
        int a1, a2, time;

        Collision(int a1, int a2, int time) {
            this.a1 = a1; // atom1
            this.a2 = a2; // atom2
            this.time = time;
        }
    }

    static int N, res;
    static List<Atom> atomList;
    static List<Collision> collisions;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            atomList = new ArrayList<>();
            res = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2; // 0.5초 충돌을 정수로 표현하기 위해 좌표를 2배로 확대
                int y = Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                atomList.add(new Atom(x, y, d, e, i));
            }

            search();
            calc();

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }

    /*
     * 두 원소가 충돌하는 경우
     * 1. 90도 충돌
     * 2. 180도 수직 충돌
     * 3. 180도 수평 충돌
     * 
     * 두 원소의 충돌 여부를 확인
     * 1. 두 원소의 운동 상태를 상대 위치, 상대 속도로 나타냄
     * 2. 미래 t초 후 상대 위치가 (0, 0)이 되는지 확인
     * 3. t가 음수라면 두 원소는 미래에 만날 일이 없음을 의미
     * 4. 두 원소가 충돌한다면 ArrayList<Collision>에 저장
     */
    private static void search() {
        collisions = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            Atom a1 = atomList.get(i);
            for (int j = i + 1; j < N; j++) {
                Atom a2 = atomList.get(j);

                int r_px = a2.x - a1.x; // 상대 위치
                int r_py = a2.y - a1.y;
                int r_vx = dx[a1.d] - dx[a2.d]; // 상대 속도
                int r_vy = dy[a1.d] - dy[a2.d];

                int time = -1; // 충돌까지 걸리는 시간

                // X, Y축 모두 상대적으로 움직일 때 (90도 충돌 가능성)
                if (r_vx != 0 && r_vy != 0) {
                    int tx = r_px / r_vx;
                    int ty = r_py / r_vy;
                    if (tx == ty && tx > 0)
                        time = tx;
                }
                // X축으로만 상대적으로 움직일 때 (수평 180도 충돌 가능성)
                else if (r_vx != 0 && r_vy == 0) {
                    if (r_py == 0) { // 같은 행에 위치할 때
                        int tx = r_px / r_vx; // 상대 위치가 0이 되는 시간
                        if (tx > 0)
                            time = tx;
                    }
                }
                // Y축으로만 상대적으로 움직일 때 (수직 180도 충돌 가능성)
                else if (r_vy != 0 && r_vx == 0) {
                    if (r_px == 0) { // 같은 열에 위치할 때
                        int ty = r_py / r_vy; // 상대 위치가 0이 되는 시간
                        if (ty > 0)
                            time = ty;
                    }
                }

                if (time > 0) {
                    collisions.add(new Collision(a1.idx, a2.idx, time));
                }
            }
        }
    }

    /*
     * 시간 오름차순으로 정렬하여 순차적으로 충돌 값 계산
     */
    private static void calc() {
        collisions.sort((o1, o2) -> Integer.compare(o1.time, o2.time));

        boolean[] isDead = new boolean[N]; // 동시성 확인을 위한 배열
        int[] deathTime = new int[N];
        Arrays.fill(deathTime, Integer.MAX_VALUE);

        for (Collision c : collisions) {
            // 이전에 충돌한 원자가 포함된 경우 제외
            if (deathTime[c.a1] < c.time || deathTime[c.a2] < c.time)
                continue;

            if (!isDead[c.a1]) {
                res += atomList.get(c.a1).e;
                isDead[c.a1] = true;
                deathTime[c.a1] = c.time;
            }
            if (!isDead[c.a2]) {
                res += atomList.get(c.a2).e;
                isDead[c.a2] = true;
                deathTime[c.a2] = c.time;
            }
        }
    }
}