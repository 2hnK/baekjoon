import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, K;
    static int[] dr = { 0, -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 0, -1, 1 };
    static int[] reverseDir = { 0, 2, 1, 4, 3 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 셀의 개수
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수

            List<mOrg> list = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                list.add(new mOrg(r, c, v, dir));
            }

            for (int t = 0; t < M; t++) {
                for (int i = 0; i < list.size(); i++) {
                    mOrg m = list.get(i);
                    m.r += dr[m.dir];
                    m.c += dc[m.dir];

                    if (m.r == 0 || m.r == N - 1 || m.c == 0 || m.c == N - 1) {
                        m.v /= 2;
                        m.dir = reverseDir[m.dir];
                        if (m.v == 0) {
                            list.remove(i);
                            i--;
                        }
                    }
                }

                Collections.sort(list);

                for (int i = 0; i < list.size() - 1; i++) {
                    mOrg cur = list.get(i);
                    mOrg next = list.get(i + 1);

                    if (cur.r == next.r && cur.c == next.c) {
                        cur.v += next.v;
                        list.remove(i + 1);
                        i--;
                    }
                }
            }

            int total = 0;
            for (mOrg m : list)
                total += m.v;

            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }

        System.out.println(sb);
    }

    static class mOrg implements Comparable<mOrg> {
        int r, c, v, dir;

        public mOrg(int r, int c, int v, int dir) {
            this.r = r;
            this.c = c;
            this.v = v;
            this.dir = dir;
        }

        @Override
        public int compareTo(mOrg o) {
            if (this.r != o.r)
                return Integer.compare(this.r, o.r);
            if (this.c != o.c)
                return Integer.compare(this.c, o.c);
            return Integer.compare(o.v, this.v);
        }
    }
}