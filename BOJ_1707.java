import java.io.*;
import java.util.*;

public class BOJ_1707 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] check;
    private static boolean isNotBipartite;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        while (testCase-- != 0) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            initArrays(node);
            generateGraph(br, edge);

            for (int idx = 1; idx <= node; idx++) {
                DFS(idx);
            }

            if (!isNotBipartite) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static void generateGraph(BufferedReader br, int edge) throws IOException {
        StringTokenizer st;
        for (int idx = 1; idx <= edge; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }
    }

    private static void initArrays(int node) {
        visited = new boolean[node + 1];
        graph = new ArrayList[node + 1];
        check = new int[node + 1];
        isNotBipartite = false;
        for (int idx = 1; idx <= node; idx++) {
            graph[idx] = new ArrayList<>();
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int nextNode : graph[start]) {
            if (!visited[nextNode]) {
                check[nextNode] = (check[start] + 1) % 2;
                DFS(nextNode);
                visited[nextNode] = true;
            } else {
                if (check[nextNode] == check[start]) {
                    isNotBipartite = true;
                }
            }
        }
    }

}
