import java.io.*;
import java.util.*;

public class BOJ_18352 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] arr;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        initArrays(N);

        for (int idx = 1; idx <= M; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }

        BFS(X, K);
        printResult(countResult(N, K));
    }

    private static void initArrays(int N) {
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        arr = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            arr[idx] = new ArrayList<>();
        }
    }

    private static StringBuilder countResult(int N, int K) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= N; idx++) {
            if (dist[idx] == K) {
                sb.append(idx).append("\n");
            }
        }
        return sb;
    }

    private static void printResult(StringBuilder sb) {
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
//        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    private static void BFS(int start, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nextNode : arr[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    dist[nextNode] = dist[node] + 1;
                }
            }
        }
    }
}
