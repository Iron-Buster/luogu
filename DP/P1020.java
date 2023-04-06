package DP;

import java.io.*;

public class P1020 {

//     [NOIP1999 普及组] 导弹拦截 TODO

    static int N = 50001;
    static int[] a = new int[N];
    static int[] dp = new int[N];

    // LIS 最长递增子序列
    static void solve(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[j] > a[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        String s = nextString();
        String[] ss = s.split(" ");
        for (int i = 1; i <= ss.length; i++) {
            a[i] = Integer.parseInt(ss[i-1]);
        }
        solve(ss.length);
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
