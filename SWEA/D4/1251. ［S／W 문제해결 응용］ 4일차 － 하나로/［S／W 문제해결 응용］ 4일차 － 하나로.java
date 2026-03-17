import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim()); // 섬의 개수

            long[] x = new long[N]; // 각 섬의 x좌표
            long[] y = new long[N]; // 각 섬의 y좌표

            // x좌표 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }
            // y좌표 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }

            // 환경 부담 세율
            double E = Double.parseDouble(br.readLine().trim());

            // 프림 알고리즘 수행
            // visited[i]: i번 섬이 MST에 포함되었는지 여부
            boolean[] visited = new boolean[N];
            // minDist[i]: MST에 포함된 섬들과 i번 섬 사이의 최소 거리의 제곱
            double[] minDist = new double[N];

            // 초기화: 모든 거리를 무한대로 설정
            for (int i = 0; i < N; i++) {
                minDist[i] = Double.MAX_VALUE;
            }

            // 우선순위 큐: {비용(거리²), 섬 번호}
            PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));

            // 0번 섬에서 시작
            minDist[0] = 0;
            pq.offer(new double[] { 0, 0 });

            double totalCost = 0; // 총 비용 (거리²의 합)
            int count = 0; // MST에 포함된 섬의 수

            while (!pq.isEmpty() && count < N) {
                double[] cur = pq.poll();
                double cost = cur[0];
                int u = (int) cur[1];

                // 이미 방문한 섬이면 스킵
                if (visited[u])
                    continue;

                // MST에 포함
                visited[u] = true;
                totalCost += cost;
                count++;

                // u와 연결된 모든 미방문 섬에 대해 거리 갱신
                for (int v = 0; v < N; v++) {
                    if (visited[v])
                        continue;

                    // 두 섬 사이 거리의 제곱
                    double dist = (double) (x[u] - x[v]) * (x[u] - x[v])
                            + (double) (y[u] - y[v]) * (y[u] - y[v]);

                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                        pq.offer(new double[] { dist, v });
                    }
                }
            }

            // 총 비용에 세율을 곱한 후 반올림
            long result = Math.round(totalCost * E);
            sb.append('#').append(tc).append(' ').append(result).append('\n');
        }
        System.out.print(sb);
    }
}