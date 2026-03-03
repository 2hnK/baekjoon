import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, res;
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        visited = new boolean[N + 1];

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                dfs(i);
                res++;
            }
        }
        System.out.println(res);
    }

    private static void dfs(int vertex) {
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;

        for (int next : adjList.get(vertex)) {
            if (visited[next] == false) {
                dfs(next);
            }
        }
    }

}