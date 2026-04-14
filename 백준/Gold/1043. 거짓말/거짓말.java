import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T, res;
    static int[] parent, known;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수

        if (T == 0) {
            System.out.println(M);
            return;
        }

        // 진실을 아는 사람 입력
        known = new int[T + 1]; // [1, T]
        for (int i = 1; i <= T; i++) {
            known[i] = Integer.parseInt(st.nextToken());
        }

        // 그룹 배열 초기화
        parent = new int[N + 1]; // [1, T]
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 파티 참석 인원 정보 입력
        party = new ArrayList[M + 1]; // [1, M][1, party_size]
        for (int i = 1; i <= M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(st.nextToken());

            // 파티 그룹 맺기
            int first = Integer.parseInt(st.nextToken());
            party[i].add(first);
            for (int j = 2; j <= party_size; j++) {
                int next = Integer.parseInt(st.nextToken());
                party[i].add(next);
                union(first, next);
            }
        }

        // 진실을 아는 그룹 맺기
        for (int i = 2; i <= T; i++) {
            union(known[1], known[i]);
        }

        res = 0;
        for (int i = 1; i <= M; i++) {
            boolean isPossible = true;
            int root = party[i].get(0);

            if (find(root) == find(known[1])) {
                isPossible = false;
            }
            if (isPossible)
                res++;
        }
        System.out.println(res);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (parent[x] != parent[y])
            parent[y] = x;
    }

    private static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }
}