import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    static double E;
    static int N;
    static int[] parents;
    static ArrayList<Node> nodeList;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine()); // 섬의 개수
            nodeList = new ArrayList<>();
            edgeList = new ArrayList<>();

            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st1.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                nodeList.add(new Node(x, y, i));
            }
            E = Double.parseDouble(br.readLine()); // 세율

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    edgeList.add(new Edge(i, j, calcDist(nodeList.get(i), nodeList.get(j))));
                }
            }

            Collections.sort(edgeList);

            double resDouble = 0;
            int count = 0;
            for (Edge e : edgeList) {
                if (union(e.from, e.to)) {
                    resDouble += E * Math.pow(e.dist, 2);
                    count++;

                    if (count == N - 1)
                        break;
                }
            }

            long res = Math.round(resDouble);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    } // End Of TestCase

    private static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
            return true;
        }

        return false;
    }

    private static double calcDist(Node n1, Node n2) {
        long absX = Math.abs(n1.x - n2.x);
        long absY = Math.abs(n1.y - n2.y);
        return Math.sqrt(Math.pow(absX, 2) + Math.pow(absY, 2));
    }

    static class Node {
        int x, y, idx;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double dist;

        public Edge(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

}