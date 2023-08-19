import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1976 {

    private static ArrayList<Integer>[] graph;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        initLinkedInfoArray(N);
        initGraph(N);
        setGraph(br, N);
        unionFind(N);

        StringBuilder sb = validatePath(br, M);
        System.out.println(sb);
    }

    private static StringBuilder validatePath(BufferedReader br, int M) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        for (int idx = 2; idx <= M; idx++) {
            int to = Integer.parseInt(st.nextToken());

            if (find(from) != find(to)) {
                sb.append("NO");
                break;
            } else {
                to = from;
            }
        }
        if (sb.length() == 0) {
            sb.append("YES");
        }
        return sb;
    }

    private static void unionFind(int N) {
        for (int idx = 1; idx <= N; idx++) {
            for (int target : graph[idx]) {
                union(idx, target);
            }
        }
    }

    private static void initLinkedInfoArray(int N) {
        arr = new int[N + 1];
        for (int idx = 0; idx <= N; idx++) {
            arr[idx] = idx;
        }
    }

    private static void setGraph(BufferedReader br, int N) throws IOException {
        for (int idx = 1; idx <= N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int jdx = 1; jdx <= N; jdx++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) {
                    graph[idx].add(jdx);
                }
            }
        }
    }

    private static void initGraph(int N) {
        graph = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            graph[idx] = new ArrayList<>();
        }
    }

    private static void union(int from, int to) {
        int root_from = find(from);
        int root_to = find(to);

        if (root_from >= root_to) {
            arr[root_from] = root_to;
        } else {
            arr[root_to] = root_from;
        }
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return num;
        } else {
            return arr[num] = find(arr[num]);
        }
    }

}
