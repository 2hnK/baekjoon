import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dwarfs = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            dwarfs.add(height);
            sum += height;
        }
        dwarfs.sort(null);

        search:
        for (int i = 0; i < dwarfs.size() - 1; i++) {
            for (int j = i + 1; j < dwarfs.size(); j++) {
                if (dwarfs.get(i) + dwarfs.get(j) == sum - 100) {
                    dwarfs.remove(j);
                    dwarfs.remove(i);
                    break search;
                }
            }
        }

        for (int h : dwarfs) {
            System.out.println(h);
        }

    }
}
