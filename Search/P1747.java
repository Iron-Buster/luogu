package Search;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1747 {


//    P1747 好奇怪的游戏 (AC)
    static int[] dx = {1,1,2,2,2,2,-1,-1,-2,-2,-2,-2};
    static int[] dy = {-2,2,-2,-1,1,2,-2,2,-1,1,-2,2};
    static int N = 30;
    static boolean[][] vis = new boolean[N][N];


    static void solve(int x1, int y1, int x2, int y2) {
        int ans1 = bfs(x1, y1);
        for (boolean[] v : vis) Arrays.fill(v, false);
        int ans2 = bfs(x2, y2);
        out.println(ans1);
        out.println(ans2);
    }

    static int bfs(int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 0});
        vis[1][1] = true;
        while (q.size() > 0) {
            int[] p = q.poll();
            for (int i = 0; i < 12; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if (!vis[nx][ny]) {
                    q.offer(new int[]{nx, ny, p[2] + 1});
                    vis[nx][ny] = true;
                    if (nx == ex && ny == ey) return p[2] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int x1 = nextInt(), y1 = nextInt();
        int x2 = nextInt(), y2 = nextInt();
        solve(x1, y1, x2, y2);
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
