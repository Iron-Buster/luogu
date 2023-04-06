package Search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5198 {

//    P5198 [USACO19JAN]Icy Perimeter S (RE) 爆栈
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static char[][] g = new char[1010][1010];
    static boolean[][] vis = new boolean[1010][1010];
    static int s = 0;
    static int c = 0;

    static void solve(int n) {
        for (boolean[] v : vis) {
            Arrays.fill(v,false);
        }
        int max = -0x3f3f3f;
        int min = 0x3f3f3f;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '#' && !vis[i][j]) {
                    s = c = 0;
                    dfs(i, j, n);
                    if (s > max) {
                        max = s; min = c;
                    } else if (s == max) {
                        min = Math.min(min, c);
                    }
                }
            }
        }
        out.print(max + " " + min);
    }

    static void dfs(int x, int y, int n) {
        if (vis[x][y]) return;
        vis[x][y] = true;
        s++;
        for (int[] d :dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || g[nx][ny] == '.') {
                c++;
                continue;
            }
            dfs(nx, ny, n);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
            }
        }
        solve(n);
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
