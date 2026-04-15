import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    private static class Meeting implements Comparable<Meeting> {
        int s, e;

        Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.e == o.e)
                return Integer.compare(this.s, o.s);
            return Integer.compare(this.e, o.e);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeSet<Meeting> reserved = new TreeSet<>();

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e);
        }
        Arrays.sort(meetings);

        int count = 0;
        for (Meeting m : meetings) {
            if (reserved.isEmpty()) {
                reserved.add(m);
                count++;
                continue;
            }

            Meeting last = reserved.last();
            if (last.e <= m.s) {
                reserved.add(m);
                count++;
            }
        }
        System.out.println(count);
    }

}
