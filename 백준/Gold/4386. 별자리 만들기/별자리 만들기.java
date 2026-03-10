import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> nodeList = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            nodeList.add(new Node(x, y, i));
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                Node n1 = nodeList.get(i);
                Node n2 = nodeList.get(j);

                double x1_x2 = Math.abs(n1.x - n2.x);
                double y1_y2 = Math.abs(n1.y - n2.y);
                double dist = Math.sqrt(Math.pow(x1_x2, 2) + Math.pow(y1_y2, 2));
                edgeList.add(new Edge(n1, n2, dist));
            }
        }

        Collections.sort(edgeList);

        int test = 0;

        double totalWeight = 0;
        int count = 0;
        for (Edge e : edgeList) {
            if (find(e.start.index) != find(e.end.index)) {
                union(e.start.index, e.end.index);
                totalWeight += e.weight;
                count++;

                if (count == N - 1)
                    break;
            }
        }

        System.out.printf("%.2f", totalWeight);
    }

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
}

class Node {
    int index;
    double x, y;

    public Node(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Edge implements Comparable<Edge> {
    Node start, end;
    double weight;

    public Edge(Node start, Node end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}
