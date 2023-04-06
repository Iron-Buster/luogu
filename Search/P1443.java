package Search;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1443 {


//    P1443 马的遍历 (AC)
    static int[] dx = {-2,-2,2,2,1,-1,1,-1};
    static int[] dy = {-1,1,-1,1,2,-2,-2,2};
    static int[][] g;
    static boolean[][] vis = new boolean[401][401];

    static void solve(int n, int m, int x, int y) {
        for (int[] arr : g) {
            Arrays.fill(arr, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        g[x][y] = 0;
        vis[x][y] = true;
        while (q.size() > 0) {
            int[] p = q.poll();
            int s = p[2];
            for (int i = 0; i < 8; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    g[nx][ny] = s + 1;
                    q.offer(new int[]{nx, ny, s + 1});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.printf("%-5d", g[i][j]);
            }
            out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        int x = nextInt(), y = nextInt();
        g = new int[n][m];
        solve(n, m, x-1, y-1);
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
