package Search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1683 {

//    P1683 入门 (AC)

    static char[][] g = new char[21][21];
    static boolean[][] vis = new boolean[21][21];
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int ans = 0;

    static void solve(int n, int m, int x, int y) {
        for (boolean[] v : vis) {
            Arrays.fill(v, false);
        }
        ans = 1;
        vis[x][y] = true;
        dfs(x, y, n, m);
        out.print(ans);
    }

    static void dfs(int x, int y, int n, int m) {
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == '#') continue;
            if (!vis[nx][ny]) {
                vis[nx][ny] = true;
                ans++;
                dfs(nx, ny, n, m);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int w = in.nextInt();
        int h = in.nextInt();
        int x = 0, y = 0;
        for (int i = 0; i < h; i++) {
            String s = in.next();
            for (int j = 0; j < w; j++) {
                g[i][j] = s.charAt(j);
                if (g[i][j] == '@') { x = i; y = j; }
            }
        }
        solve(h, w, x, y);
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader{
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException{
            while(st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException{
            return bf.readLine();
        }

        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException{
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
    }

}
