import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X, res;
	static int[] dist;
	static ArrayList<ArrayList<Edge>> adjList;
	static ArrayList<ArrayList<Edge>> reverseList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 노드 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		X = Integer.parseInt(st.nextToken()); // 왕복 이동할 도시 번호
		res = 0;

		adjList = new ArrayList<>();
		reverseList = new ArrayList<>();
		for (int i = 0; i <= N; i++) { // 노드번호: 1~1000
			adjList.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			adjList.get(from).add(new Edge(to, time));
			reverseList.get(to).add(new Edge(from, time));
		}

		int[] distToGo = dijkstra(X, reverseList);
		int[] distToReturn = dijkstra(X, adjList);

		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (distToGo[i] != Integer.MAX_VALUE && distToReturn[i] != Integer.MAX_VALUE) {
				res = Math.max(res, distToGo[i] + distToReturn[i]);
			}
		}

		System.out.println(res);
	}

	private static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.index] < cur.time)
				continue;

			for (Edge next : list.get(cur.index)) {
				int temp = cur.time + next.weight;
				if (temp < dist[next.to]) {
					dist[next.to] = temp;
					pq.add(new Node(next.to, temp));
				}
			}
		}

		return dist;
	}

	static class Node implements Comparable<Node> {
		int index, time;

		public Node(int index, int time) {
			this.index = index;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	static class Edge {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

}