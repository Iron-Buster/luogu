package Search;

import java.io.*;

public class P1162 {


//    P1162 填涂颜色 (AC)
    static int[][] a = new int[31][31];

    static void solve(int n) {
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 0) dfs(i, 0, n);
            if (a[i][n-1] == 0) dfs(i, n-1, n);
        }
        for (int j = 0; j < n; j++) {
            if (a[0][j] == 0) dfs(0, j, n);
            if (a[n-1][j] == 0) dfs(n-1, j, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == -1) {
                    out.print("0 ");
                } else if (a[i][j] == 0) {
                    out.print("2 ");
                } else {
                    out.print("1 ");
                }
            }
            out.print("\n");
        }
    }

    static void dfs(int x, int y, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n || a[x][y] == 1) return;
        if (a[x][y] != -1) {
            a[x][y] = -1;
            dfs(x + 1, y, n);
            dfs(x - 1, y, n);
            dfs(x, y + 1, n);
            dfs(x, y - 1, n);
        }
    }


    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }
        solve(n);
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
