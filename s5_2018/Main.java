package s5_2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
<투포인터>
- start, end: 1~n, sum = 1, count = 0;
1. sum < n : e++, sum+e
2. sum > n : s++, sum-s
3. sum = n : e++, sum+e, c++

 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = 1, e = 1, sum = 1, c = 1;
        while (e != n) //왜 !!!!!!
        {
            if(sum < n) {
                e++; sum += e;
            } else if(sum > n) {
                sum -= s; s++; //s를 빼주고 ++해야함
            } else if (sum == n) {
                e++; sum += e; c++;
            }
        }
        System.out.print(c);
    }
}