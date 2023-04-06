package Search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P1332 {

//    P1332 血色先锋队 (AC)
    static int[][] g = new int[510][510];
    static int[][] dist = new int[510][510];
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void bfs(Queue<int[]> q, int n, int m) {
        while (q.size() > 0) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (g[nx][ny] != 1) {
                    g[nx][ny] = 1;
                    dist[nx][ny] = dist[x][y]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        int n = nextInt();
        int m = nextInt();
        int a = nextInt();
        int b = nextInt();
        while (a-- > 0) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            q.offer(new int[]{x, y});
            dist[x][y] = 0;
            g[x][y] = 1;
        }
        bfs(q, n, m);
        while (b-- > 0) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            out.println(dist[x][y]);
        }
        out.close();
    }

    static BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(ins);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    public static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    public static String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
