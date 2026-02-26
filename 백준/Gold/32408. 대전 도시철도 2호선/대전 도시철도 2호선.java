import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] adjList;
    static int[] parent;
    static boolean[] isPath;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        // BFS를 통해 1번에서 N번까지의 경로 탐색
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        findPath(1, N);

        // 1호선 경로에 포함된 노드 마킹 및 개수 세기
        isPath = new boolean[N + 1];
        long pathNodeCount = 0;
        int cur = N;
        while (cur != 0) {
            isPath[cur] = true;
            pathNodeCount++;
            cur = parent[cur];
        }

        // 1호선이 아닌 노드들의 전체 개수 M 계산
        long M = N - pathNodeCount;
        long totalPairs = M * (M - 1) / 2;

        // 1호선을 거치지 않는 같은 서브트리에 있는 쌍의 수 차감
        visited = new boolean[N + 1];
        long invalidPairs = 0;
        for (int i = 1; i <= N; i++) {
            if (!isPath[i] && !visited[i]) {
                long size = getSubtreeSize(i);
                invalidPairs += size * (size - 1) / 2;
            }
        }

        System.out.println(totalPairs - invalidPairs);
    }

    // 1번 노드에서 N번 노드까지의 부모 관계를 찾는 BFS
    static void findPath(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == target)
                return;

            for (int next : adjList[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = curr;
                    q.add(next);
                }
            }
        }
    }

    // 1호선 노드를 만나지 않고 갈 수 있는 연결 요소의 크기를 구하는 BFS
    static long getSubtreeSize(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        long count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int next : adjList[curr]) {
                if (!isPath[next] && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return count;
    }
}