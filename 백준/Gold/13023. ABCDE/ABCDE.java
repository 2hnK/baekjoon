import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, res;
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 관계 수

        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            flag = false;
            visited = new boolean[N];
            dfs(i, 1);
            if (flag) {
                res = 1;
                break;
            }
        }

        System.out.println(res);
    }

    private static void dfs(int person, int depth) {
        if (depth == 5) {
            flag = true;
            return;
        }

        visited[person] = true;
        for (int friend : adjList.get(person)) {
            if (!visited[friend]) {
                dfs(friend, depth + 1);
                if (flag)
                    return;
            }
        }
        visited[person] = false;
    }
}
