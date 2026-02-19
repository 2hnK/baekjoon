
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, cond;
	static int[] inDegree, res;
	static ArrayList<ArrayList<Integer>> adj;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		cond = Integer.parseInt(st.nextToken());

		inDegree = new int[N + 1];
		res = new int[N + 1];
		adj = new ArrayList<>();

		// ArrayList<> adj 초기화
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < cond; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			adj.get(first).add(second);
			inDegree[second]++;
		}

		solve();

		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();
		int semester = 0;

		// 진입 차수가 0인 노드 추가
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			semester++;

			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				res[cur] = semester;

				for (int next : adj.get(cur)) {
					inDegree[next]--;
					if (inDegree[next] == 0) {
						q.offer(next);
					}
				}
			}
		}

	}
}