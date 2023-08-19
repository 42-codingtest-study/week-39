import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1747 {

    private static boolean[] isNotPrime;
    private static final int MAX  = 1003002;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        erosto();
        System.out.println(getPalindrome(N));
    }

    private static void erosto() {
        isNotPrime = new boolean[MAX];

        isNotPrime[0] = isNotPrime[1] = true;
        for (int idx = 2; idx < Math.sqrt(MAX); idx++) {
            if (isNotPrime[idx]) {
                continue;
            }
            for (int div = idx * 2; div < MAX; div += idx) {
                isNotPrime[div] = true;
            }
        }
    }

    private static int getPalindrome(int N) {

        boolean flag;

        for (int idx = N; idx < MAX; idx++) {
            if (!isNotPrime[idx]) {
                flag = true;
                String number = Integer.toString(idx);

                for (int jdx = 0; jdx < number.length(); jdx++) {
                    if (number.charAt(jdx) != number.charAt(number.length() - 1 - jdx)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return Integer.parseInt(number);
                }
            }
        }
        return -1;
    }
}
