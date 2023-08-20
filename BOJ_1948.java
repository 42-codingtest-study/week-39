import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1948 {

    static class Node {
        int toNode;
        int weight;

        public Node(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }
    }

    private static boolean[] visited;
    private static ArrayList<Node>[] nodeList;
    private static ArrayList<Node>[] nodeRevList;
    private static int[] indegree;
    private static int[] revIndegree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        int[] dList = new int[nodeNum + 1];
        visited = new boolean[nodeNum + 1];

        setNodeListForTopologySort(nodeNum, edgeNum, br);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topologySort(start, nodeList, dList, indegree);

        int maxTime = dList[end];
        int cityCount = revTopologySort(end, nodeRevList, dList, revIndegree);

        System.out.println(maxTime);
        System.out.println(cityCount);
    }

    private static void setNodeListForTopologySort(int nodeNum, int edgeNum, BufferedReader br) throws IOException {
        StringTokenizer st;
        nodeList = new ArrayList[nodeNum + 1];
        nodeRevList = new ArrayList[nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            nodeList[idx] = new ArrayList<>();
            nodeRevList[idx] = new ArrayList<>();
        }

        indegree = new int[nodeNum + 1];
        revIndegree = new int[nodeNum + 1];
        for (int idx = 1; idx <= edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end, weight));
            nodeRevList[end].add(new Node(start, weight));

            indegree[end]++;
            revIndegree[start]++;

        }
    }

    private static int revTopologySort(int end, ArrayList<Node>[] nodeRevList, int[] dList, int[] revIndegree) {
        int cityCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);

        visited[end] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Node cur : nodeRevList[node]) {
                if (visited[node] && dList[node] - dList[cur.toNode] == cur.weight) {
                    cityCount++;
                    visited[cur.toNode] = true;
                }
                revIndegree[cur.toNode]--;
                if (revIndegree[cur.toNode] == 0) {
                    queue.add(cur.toNode);
                }
            }
        }
        return cityCount;
    }

    private static void topologySort(int start, ArrayList<Node>[] nodeList, int[] dList, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Node next : nodeList[node]) {
                dList[next.toNode] = Math.max(dList[next.toNode], dList[node] + next.weight);

                indegree[next.toNode]--;
                if (indegree[next.toNode] == 0) {
                    queue.add(next.toNode);
                }
            }
        }
    }
}