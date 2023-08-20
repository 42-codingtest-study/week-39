import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1197 {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static ArrayList<Node> edgeList;
    private static int[] dlist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        setEdgeList(br, edgeNum);
        setUnionFindList(nodeNum);

        int weightSum = MST(nodeNum, edgeNum);

        System.out.println(weightSum);
    }

    private static int MST(int nodeNum, int edgeNum) {
        Collections.sort(edgeList);

        int connectCount = 0;
        int weightSum = 0;
        // 1. 먼저 낮은 weight 부터 start 와 end 의 find 를 확인하여 순환 불가인지 확인하고
        // 2. 불가라면 union
        // 3. 연결 개수 ++
        // 4  연결 개수 == 노드 개수 - 1 라면 종료
        for (int idx = 0; idx <= edgeNum; idx++) {
            int start = edgeList.get(idx).start;
            int end = edgeList.get(idx).end;
            int weight = edgeList.get(idx).weight;

            if (!checkSame(start, end)) {
                union(start, end);
                connectCount++;
                weightSum += weight;

                if (connectCount == nodeNum - 1) break;
            }
        }
        return weightSum;
    }

    private static void setUnionFindList(int nodeNum) {
        dlist = new int[nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            dlist[idx] = idx;
        }
    }

    private static void setEdgeList(BufferedReader br, int edgeNum) throws IOException {
        StringTokenizer st;
        edgeList = new ArrayList<>();

        for (int idx = 1; idx <= edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Node(start, end, weight));
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a >= b) dlist[a] = b;
            else dlist[b] = a;
        }
    }

    private static int find(int num) {
        if (num == dlist[num]) {
            return num;
        } else {
            return dlist[num] = find(dlist[num]);
        }
    }

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }

}
