package Search;

import java.io.*;
import java.util.StringTokenizer;

public class P2372 {

//    P2372 yyy2015c01挑战算周长

    static int[] dx = {-1,-1,1,1,-1,0,0,1};
    static int[] dy = {-1,1,-1,1,0,-1,1,0};
    static char[][] g = new char[30][30];
    static boolean[][] vis = new boolean[30][30];
    static int ans = 0;

    static void solve(int n, int m, int x, int y) {
        dfs(x, y, n, m);
        out.println(ans);
    }

    static void dfs(int x, int y, int n, int m) {
        vis[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && nx <= n && ny > 0 && ny < m && !vis[nx][ny] && g[nx][ny] == 'X') {
                dfs(nx, ny, n, m);
            }
            if (i > 3 && (nx <= 0 || nx > n || ny <= 0 || ny > m || g[nx][ny] != 'X')) {
                ans++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int m = in.nextInt();
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        for (int i = 1; i <= m; i++) {
            String s = in.next();
            for (int j = 1; j <= n; j++) {
                g[i][j] = s.charAt(j-1);
            }
        }
        solve(n, m, x, y);
        out.close();
    }


    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
