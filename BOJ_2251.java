import java.io.*;
import java.util.*;

public class BOJ_2251 {

    private static int capaA, capaB, capaC;
    private static boolean[][][] visited;
    private static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[201][201][201];
        result = new ArrayList<>();

        capaA = Integer.parseInt(st.nextToken());
        capaB = Integer.parseInt(st.nextToken());
        capaC = Integer.parseInt(st.nextToken());

        BFS(0, 0, capaC);

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int idx : result) {
            sb.append(idx + " ");
        }
        System.out.println(sb);
    }

    private static void BFS(int a, int b, int c) {
        Queue<Water> queue = new LinkedList<>();
        queue.add(new Water(a, b, c));

        while (!queue.isEmpty()) {
            Water water = queue.poll();
            int amountA = water.a;
            int amountB = water.b;
            int amountC = water.c;

            if (visited[amountA][amountB][amountC]) {
                continue;
            }

            visited[amountA][amountB][amountC] = true;
            if (amountA == 0) {
                result.add(amountC);
            }

            setQueue(queue, amountA, amountB, amountC);
        }

    }

    private static void setQueue(Queue<Water> queue, int amountA, int amountB, int amountC) {
        if (amountA + amountB >= capaB) {
            queue.add(new Water(amountA - (capaB - amountB), capaB, amountC));
        } else {
            queue.add(new Water(0, amountA + amountB, amountC));
        }
        if (amountA + amountC >= capaC) {
            queue.add(new Water(amountA - (capaC - amountC), amountB, capaC));
        } else {
            queue.add(new Water(0, amountB, amountC + amountA));
        }
        if (amountB + amountA >= capaA) {
            queue.add(new Water(capaA, amountB - (capaA - amountA), amountC));
        } else {
            queue.add(new Water(amountB + amountA, 0, amountC));
        }
        if (amountB + amountC >= capaC) {
            queue.add(new Water(amountA, amountB - (capaC - amountC), capaC));
        } else {
            queue.add(new Water(amountA, 0, amountB + amountC));
        }
        if (amountC + amountA >= capaA) {
            queue.add(new Water(capaA, amountB, amountC - (capaA - amountA)));
        } else {
            queue.add(new Water(amountC + amountA, amountB, 0));
        }
        if (amountC + amountB >= capaB) {
            queue.add(new Water(amountA, capaB, amountC - (capaB - amountB)));
        } else {
            queue.add(new Water(amountA, amountB + amountC, 0));
        }
    }

    static class Water {
        int a;
        int b;
        int c;

        Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

}
