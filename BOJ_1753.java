import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1753 {

    static class Node {
        int toNode;
        int edgeValue;

        Node (int toNode, int edgeValue) {
            this.toNode = toNode;
            this.edgeValue = edgeValue;
        }
    }

    private static boolean[] visited;
    private static int[] distances;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int edgeValue = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, edgeValue));
        }

        distances = new int[nodeNum + 1];
        for (int idx = 0; idx <= nodeNum; idx++) {
            if (idx == startNode) {
                distances[idx] = 0;
            } else {
                distances[idx] = 2147483647;
            }
        }

        visited = new boolean[nodeNum + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            if (graph[node].isEmpty())
                break;
            int min = 2147483647;
            int minNode = 2147483647;
            for (Node nextNode : graph[node]) {
                if (!visited[nextNode.toNode]) {
                    if (distances[node] + nextNode.edgeValue < distances[nextNode.toNode]) {
                        distances[nextNode.toNode] = distances[node] + nextNode.edgeValue;
                    }
                    if (min > nextNode.edgeValue) {
                        min = nextNode.edgeValue;
                        minNode = nextNode.toNode;
                    }
                }
            }
            visited[minNode] = true;
            queue.add(minNode);
        }

        for (int idx = 1; idx <= nodeNum; idx++) {
            if (distances[idx] == 2147483647) {
                System.out.println("INF");
            } else {
                System.out.println(distances[idx]);
            }
        }
    }
}
