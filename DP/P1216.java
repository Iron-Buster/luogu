package DP;

import java.io.*;

public class P1216 {

//    [USACO1.5][IOI1994]数字三角形 Number Triangles

    static final int N = 1001;
    static int[][] dp = new int[N][N];
    static int[][] a = new int[N][N];

    static void solve(int r) {
        int ans = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + a[i][j];
                if (i == r) ans = Math.max(ans, dp[i][j]);
            }
        }
        out.print(ans);
    }

    public static void main(String[] args) throws IOException {
        int r = nextInt();
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = nextInt();
            }
        }
        solve(r);
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
        return ins.readLine();
    }
}
