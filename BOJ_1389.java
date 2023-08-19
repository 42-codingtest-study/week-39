import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1389 {
    private static int[][] dList;
    private static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        setDList(br, nodeNum, edgeNum);
        floydWarshall(nodeNum);

        int result = findResult(nodeNum);
        System.out.println(result);

    }

    private static int findResult(int nodeNum) {
        int min = INF;
        int result = -1;
        for (int idx = 1; idx <= nodeNum; idx++) {
            int sum = 0;
            for (int jdx = 1; jdx <= nodeNum; jdx++) {
                if (dList[idx][jdx] == INF) {
                    dList[idx][jdx] = 0;
                }
                sum += dList[idx][jdx];
            }
            if (min > sum) {
                min = sum;
                result = idx;
            }
        }
        return result;
    }

    private static void floydWarshall(int nodeNum) {
        for (int k = 1; k <= nodeNum; k++) {
            for (int s = 1; s <= nodeNum; s++) {
                for (int e = 1; e <= nodeNum; e++) {
                    dList[s][e] = Math.min(dList[s][k] + dList[k][e], dList[s][e]);
                }
            }
        }
    }

    private static void setDList(BufferedReader br, int nodeNum, int edgeNum) throws IOException {
        StringTokenizer st;
        dList = new int[nodeNum + 1][nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            Arrays.fill(dList[idx], INF);
            dList[idx][idx] = 0;
        }

        for (int idx = 1; idx <= edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dList[start][end] = 1;
            dList[end][start] = 1;
        }
    }
}
