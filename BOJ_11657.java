import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {

    static class Node {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static ArrayList<Node> edgeValues;
    private static long[] dlist;
    private static final int INF = 2147483647;
    private static boolean cycleFlag;
    private static int nodeNum, edgeNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());

        setEdgeList(br, edgeNum);
        setDistanceArray(nodeNum);
        bellmanFord(1);

        StringBuilder sb = setResult();
        if (sb == null) return;

        System.out.println(sb);
    }

    private static StringBuilder setResult() {
        StringBuilder sb = new StringBuilder();
        if (!cycleFlag) {
            for (int idx = 2; idx <= nodeNum; idx++) {
                if (dlist[idx] != INF) {
                    sb.append(dlist[idx] + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
            }
        } else {
            System.out.println(-1);
            return null;
        }
        return sb;
    }

    private static void bellmanFord(int start) {
        dlist[start] = 0;
        for (int idx = 1; idx <= nodeNum - 1; idx++) {
            for (Node edgeValue : edgeValues) {
                if (dlist[edgeValue.from] != INF && dlist[edgeValue.from] + edgeValue.weight < dlist[edgeValue.to]) {
                    dlist[edgeValue.to] = dlist[edgeValue.from] + edgeValue.weight;
                }
            }
        }

        for (Node edgeValue : edgeValues) {
            if (dlist[edgeValue.from] != INF && dlist[edgeValue.from] + edgeValue.weight < dlist[edgeValue.to]) {
                cycleFlag = true;
                break;
            }
        }
    }

    private static void setDistanceArray(int nodeNum) {
        dlist = new long[nodeNum + 1];
        Arrays.fill(dlist, INF);
    }

    private static void setEdgeList(BufferedReader br, int edgeNum) throws IOException {
        StringTokenizer st;
        edgeValues = new ArrayList<>();
        for (int idx = 1; idx <= edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeValues.add(new Node(from, to, weight));
        }
    }

}
