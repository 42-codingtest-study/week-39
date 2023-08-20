import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {

    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int idx = 0; idx <= n; idx++) {
            arr[idx] = idx;
        }

        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < m; idx++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (question == 1) {
                boolean result = checkSame(a, b);
                if (result) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            } else {
                union(a, b);
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a < root_b) {
            arr[root_b] = root_a;
        } else {
            arr[root_a] = root_b;
        }
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return arr[num];
        } else {
            return arr[num] = find(arr[num]);
        }
    }

    private static boolean checkSame(final int a, final int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a == root_b) {
            return true;
        } else {
            return false;
        }
    }
}
