import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {

    private static int[][] dList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());

        setDList(br, nodeNum);
        floydWarshall(nodeNum);
        printResult(nodeNum);
    }

    private static void floydWarshall(int nodeNum) {
        for (int k = 1; k <= nodeNum; k++) {
            for (int s = 1; s <= nodeNum; s++) {
                for (int e = 1; e <= nodeNum; e++) {
                    if (dList[s][k] == 1 && dList[k][e] == 1) {
                        dList[s][e] = 1;
                    }
                }
            }
        }
    }

    private static void setDList(BufferedReader br, int nodeNum) throws IOException {
        dList = new int[nodeNum + 1][nodeNum + 1];

        for (int idx = 1; idx <= nodeNum; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int jdx = 1; jdx <= nodeNum; jdx++) {
                int input = Integer.parseInt(st.nextToken());

                dList[idx][jdx] = input;
            }
        }
    }

    private static void printResult(int nodeNum) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= nodeNum; idx++) {
            for (int jdx = 1; jdx <= nodeNum; jdx++) {
                if (dList[idx][jdx] == 0) {
                    sb.append("0 ");
                } else {
                    sb.append("1 ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
