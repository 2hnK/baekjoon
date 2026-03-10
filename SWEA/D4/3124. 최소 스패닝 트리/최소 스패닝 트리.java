import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int[] parents;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Edge> edgeList = new ArrayList<>();

            parents = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edgeList.add(new Edge(a, b, c));
            }

            Collections.sort(edgeList);

            int count = 0;
            long res = 0;
            for (Edge e : edgeList) {
                if (find(e.from) != find(e.to)) {
                    union(e.from, e.to);
                    res += e.weight;
                    count++;

                    if (count == V - 1)
                        break;
                }
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    } // End Of TestCase

    private static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
