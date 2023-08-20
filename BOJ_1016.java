import java.io.*;
import java.util.*;

public class BOJ_1016 {

    private static boolean[] nonoNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long count = max - min + 1;
        nonoNumber = new boolean[(int)count];

        for (long idx = 2; idx * idx <= max; idx++) {
            long pow = idx * idx;
            long mod = min % pow;
            long start = min / pow;
            if (mod != 0) {
                start += 1;
            }

            for (long jdx = start; jdx * pow <= max; jdx++) {
                int notNonoNumber = (int)(jdx * pow - min);
                if (!nonoNumber[notNonoNumber]) {
                    nonoNumber[notNonoNumber] = true;
                    count--;
                }
            }
        }
        System.out.println(count);
    }
}
