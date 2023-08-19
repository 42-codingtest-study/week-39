import java.io.*;
import java.util.*;

public class BOJ_1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int gcd = A > B ? euclidean(A, B) : euclidean(B, A);
            int lcm = A * B / gcd;

            System.out.println(lcm);
        }
    }

    private static int euclidean(int big, int small) {
        return big % small != 0 ? euclidean(small, big % small) : small;
    }
}
