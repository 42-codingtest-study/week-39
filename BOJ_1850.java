import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = A > B ? euclidean(A, B) : euclidean(B, A);

        StringBuilder sb = getResult(gcd);

        System.out.println(sb);
    }

    private static StringBuilder getResult(long gcd) {
        StringBuilder sb = new StringBuilder();

        while (gcd-- != 0) {
            sb.append("1");
        }
        return sb;
    }

    private static long euclidean(long big, long small) {
        long mod = big % small;
        return mod  != 0 ? euclidean(small, mod) : small;
    }

}
