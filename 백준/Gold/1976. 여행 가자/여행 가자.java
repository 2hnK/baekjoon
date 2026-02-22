import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent, plan;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine()); // 도시의 수
        M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수

        // 유니온 파인드 그룹 [1, N]
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 인접 행렬 입력 [1, N]
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int relation = Integer.parseInt(st.nextToken());

                if (i != j && relation == 1) {
                    union(i, j);
                }
            }
        }

        // 탐색할 도시 [1, M]
        plan = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        if (check()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static boolean check() {
        for (int i = 1; i < M; i++) {
            if (find(plan[i]) != find(plan[i + 1])) {
                return false;
            }
        }
        return true;
    }
}