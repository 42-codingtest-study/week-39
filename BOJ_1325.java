import java.io.*;
import java.util.*;

public class BOJ_1325 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;
    private static int[] depth;
    private static int  max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];
        arr = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            arr[idx] = new ArrayList<>();
        }

        for (int idx = 1; idx <= M; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
//            arr[end].add(start);
        }

        max = 0;
        for (int idx = 1; idx <= N; idx++) {
            visited = new boolean[N + 1];
            BFS(idx);
        }
        for (int idx = 1; idx <= N; idx++) {
            max = Math.max(depth[idx], max);
        }

        StringBuilder sb = new StringBuilder();

        for (int idx = 1; idx <= N; idx++) {
            if (depth[idx] == max) {
                sb.append(idx + " ");
            }
        }
        System.out.println(sb);
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nextNode : arr[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    depth[nextNode]++;
                }
            }
        }
    }
}
