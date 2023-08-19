import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }

    private static ArrayList<Node>[] graph;
    private static boolean[] visited;
    private static int[] dlist;
    private static int nodeNum;
    private static final int INF = 2147483647;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        setGraphInfo(br, edgeNum);
        setDistanceArray();

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        System.out.println(dlist[to]);

    }

    private static void setDistanceArray() {
        dlist = new int[nodeNum + 1];
        Arrays.fill(dlist, INF);
    }

    private static void setGraphInfo(BufferedReader br, int edgeNum) throws IOException {
        graph = new ArrayList[nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            graph[idx] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int idx = 1; idx <= edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }
    }

    private static void dijkstra(int start) {
        visited = new boolean[nodeNum + 1];
        dlist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            int cur = curNode.to;

            if (visited[cur]) continue;

            visited[cur] = true;
            for (Node nextNode : graph[cur]) {
                if (dlist[cur] + nextNode.weight < dlist[nextNode.to]) {
                    dlist[nextNode.to] = dlist[cur] + nextNode.weight;
                    queue.add(new Node(nextNode.to, dlist[nextNode.to]));
                }
            }
        }
    }

}
