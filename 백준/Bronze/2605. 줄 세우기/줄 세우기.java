import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> arr = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int student = 1; student <= N; student++) {
            int index = Integer.parseInt(st.nextToken());
            arr.add(arr.size() - index, student);
        }

        for (int s : arr) {
            sb.append(s + " ");
        }
        
        System.out.print(sb);
    }
}
