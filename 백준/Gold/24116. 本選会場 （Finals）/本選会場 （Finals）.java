import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static ArrayList<ArrayList<Edge>> edgeList;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.add(new Edge(u, v, w));
		}

		int res = 0;
		int count = 0;
		while (count < N - K) {
			Edge cur = pq.poll();
			if (union(cur.from, cur.to)) {
				res += cur.weight;
				count++;
			}

		}

		System.out.println(res);
	}

	static private boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return false;
		} else {
			parents[y] = x;
			return true;
		}
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		else
			return parents[x] = find(parents[x]);
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
			return this.weight - o.weight;
		}
	}
}
