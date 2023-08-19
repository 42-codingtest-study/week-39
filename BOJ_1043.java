import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1043 {

    private static int[] arr;
    private static boolean[] knownArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // set graph
        arr = new int[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            arr[idx] = idx;
        }

        // check known node
        st = new StringTokenizer(br.readLine());
        int knownNum = Integer.parseInt(st.nextToken());

        if (knownNum == 0) {
            System.out.println(M);
            return ;
        }
        knownArr = new boolean[N + 1];
        for (int idx = 0; idx < knownNum; idx++) {
            int arrIndex = Integer.parseInt(st.nextToken());

            knownArr[arrIndex] = true;
        }

        // save party
        int[] eachPartyRepresentativeValues;

        eachPartyRepresentativeValues = new int[M];
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int visitedNum = Integer.parseInt(st.nextToken());
            if (visitedNum == 0)
                continue;
            int visitedA = Integer.parseInt(st.nextToken());
            for (int jdx = 1; jdx < visitedNum; jdx++) {
                int visitedB = Integer.parseInt(st.nextToken());
                union(visitedA, visitedB);
                visitedA = visitedB;
            }
            eachPartyRepresentativeValues[idx] = find(visitedA);
        }

        for (int idx = 0; idx < M; idx++) {
            eachPartyRepresentativeValues[idx] = find(eachPartyRepresentativeValues[idx]);
        }

        int count = M;
        for (int idx = 1; idx < knownArr.length; idx++) {
            if (knownArr[idx]) {
                for (int jdx = 0; jdx < M; jdx++) {
                    if (find(eachPartyRepresentativeValues[jdx]) == arr[idx]) {
                        count--;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void union(int visitedA, int visitedB) {
        int root_A = find(visitedA);
        int root_B = find(visitedB);

        if (root_A != root_B) {
            if (root_A > root_B) {
                arr[root_A] = root_B;
            } else {
                arr[root_B] = root_A;
            }
        }
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return num;
        } else {
            return arr[num] = find(arr[num]);
        }
    }

}
