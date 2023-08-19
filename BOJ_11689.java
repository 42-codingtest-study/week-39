import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11689 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long eulerPhi = N;

        for (long idx = 2; idx <= Math.sqrt(N); idx++) {
            if (N % idx == 0) {
                eulerPhi = eulerPhi - (eulerPhi / idx);
            }
            while (N % idx == 0) {
                N /= idx;
            }
        }
        if (N != 1) {
            eulerPhi = eulerPhi - (eulerPhi / N);
        }
        System.out.println(eulerPhi);
    }

}
