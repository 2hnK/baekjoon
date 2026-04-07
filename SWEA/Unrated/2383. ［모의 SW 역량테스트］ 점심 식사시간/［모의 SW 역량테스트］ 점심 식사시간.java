import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 2383. [모의 SW 역량테스트] 점심 식사시간 */
public class Solution {

    /* 계단 */
    static class Stair {
        int r, c, l;

        public Stair(int r, int c, int l) {
            this.r = r;
            this.c = c;
            this.l = l;
        }
    }

    /* 사람 */
    static class Person {
        int r, c, d;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    /* 전역변수 */
    static int N, res;
    static ArrayList<Person> people; // 동일하게 도착한 사람이 들어가는 순서는 상관없다.
    static ArrayList<Stair> stairs;
    static ArrayList<Integer> stair1, stair2;
    static int[][] map;

    /* 메인함수 */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine()); // 방의 크기
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            stair1 = new ArrayList<>();
            stair2 = new ArrayList<>();

            map = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        people.add(new Person(i, j));
                    } else if (map[i][j] >= 2) {
                        stairs.add(new Stair(i, j, map[i][j]));
                    }
                }
            }

            res = Integer.MAX_VALUE;
            backTracking(0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // End Of TestCase

        System.out.println(sb);
    }

    /* 백트래킹 */
    private static void backTracking(int depth) {
        if (depth == people.size()) {
            int v1 = calculateTime(stair1, stairs.get(0).l);
            int v2 = calculateTime(stair2, stairs.get(1).l);

            // 두 계단 중 더 늦게 끝나는 시간
            int total = Math.max(v1, v2);

            // 전체 경우 중 최솟값 갱신
            res = Math.min(res, total);
            return;
        }

        Person p = people.get(depth);
        Stair s1 = stairs.get(0);
        Stair s2 = stairs.get(1);

        stair1.add(calcDist(p, s1));
        backTracking(depth + 1);
        stair1.remove(stair1.size() - 1);

        stair2.add(calcDist(p, s2));
        backTracking(depth + 1);
        stair2.remove(stair2.size() - 1);

    }

    /* 종료시간 계산 */
    private static int calculateTime(ArrayList<Integer> dists, int L) {
        if (dists.isEmpty())
            return 0;

        ArrayList<Integer> sortedDist = new ArrayList<>(dists);
        Collections.sort(sortedDist);

        int size = sortedDist.size();
        int[] finishTime = new int[size];

        for (int i = 0; i < size; i++) {
            int arrival = sortedDist.get(i);
            int readyTime = arrival + 1;

            if (i < 3) {
                finishTime[i] = readyTime + L;
            } else {
                finishTime[i] = Math.max(readyTime, finishTime[i - 3]) + L;
            }
        }

        return finishTime[size - 1];
    }

    /* 맨해튼 거리 */
    private static int calcDist(Person x, Stair y) {
        int absX = Math.abs(x.r - y.r);
        int absY = Math.abs(x.c - y.c);
        return absX + absY;
    }

}
