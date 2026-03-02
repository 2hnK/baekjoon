import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Node>> adjList, adjList_r;
    static int[] indegree, result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 도로의 개수

        indegree = new int[N + 1];
        result = new int[N + 1];
        adjList = new ArrayList<>();
        adjList_r = new ArrayList<>();

        // 인접리스트 초기화
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            adjList_r.add(new ArrayList<>());
        }

        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Node(v, w));
            adjList_r.get(v).add(new Node(u, w));
            indegree[v]++;
        }

        st = new StringTokenizer(br.readLine());
        int START = Integer.parseInt(st.nextToken());
        int END = Integer.parseInt(st.nextToken());

        // 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(START);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node next : adjList.get(cur)) {
                indegree[next.target]--;
                result[next.target] = Math.max(result[next.target], result[cur] + next.val);
                if (indegree[next.target] == 0) {
                    q.offer(next.target);
                }
            }
        }

        // 위상 역정렬
        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        q = new ArrayDeque<>();
        q.offer(END);
        visited[END] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node next : adjList_r.get(cur)) {
                if (result[cur] == result[next.target] + next.val) {
                    resultCount++;

                    if (visited[next.target] == false) {
                        visited[next.target] = true;
                        q.offer(next.target);
                    }
                }
            }
        }

        sb.append(result[END]).append("\n").append(resultCount);
        System.out.println(sb);
    }

    static class Node {
        int target;
        int val;

        Node(int target, int val) {
            this.target = target;
            this.val = val;
        }
    }
}
