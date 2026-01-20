import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] scores;
    static int N;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scores = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, scores[i]);
        }

        double[] newScores = new double[N];
        double sum = 0;
        for (int i = 0; i < N; i++) {
            newScores[i] = (double)scores[i] / max * 100;
            sum += newScores[i];
        }

        System.out.printf("%f", sum / N);

    }
}
