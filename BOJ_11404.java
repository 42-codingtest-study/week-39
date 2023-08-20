import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {

    private static int[][] graph;
    private static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        initFloydWarshall(nodeNum);
        setNodeValue(br, edgeNum);
        floydWarshall(nodeNum);
        printGraph(nodeNum);
    }

    private static void floydWarshall(int nodeNum) {
        for (int k = 1; k <= nodeNum; k++) {
            for (int s = 1; s <= nodeNum; s++) {
                for (int e = 1; e <= nodeNum; e++) {
                    graph[s][e] = Math.min(graph[s][e], graph[s][k] + graph[k][e]);
                }
            }
        }
    }

    private static void setNodeValue(BufferedReader br, int edgeNum) throws IOException {
        StringTokenizer st;
        for (int idx = 0; idx < edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start][end] = Math.min(graph[start][end], weight);
        }
    }

    private static void initFloydWarshall(int nodeNum) {
        graph = new int[nodeNum + 1][nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            Arrays.fill(graph[idx], INF);
        }

        for (int idx = 1; idx <= nodeNum; idx++) {
            graph[idx][idx] = 0;
        }
    }

    private static void printGraph(int nodeNum) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= nodeNum; idx++) {
            for (int jdx = 1; jdx <= nodeNum; jdx++) {
                if (graph[idx][jdx] == INF) {
                    graph[idx][jdx] = 0;
                }
                sb.append(graph[idx][jdx]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
