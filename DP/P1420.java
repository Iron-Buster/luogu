package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1420 {


//    P1420 最长连号 (AC)

    static long[] a = new long[10001];
    static long[] dp = new long[10001];

    static void solve(int n) {
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            if (a[i] - a[i-1] == 1) {
                dp[i] = dp[i-1] + 1;
            }
        }
        long ans = Arrays.stream(dp).max().getAsLong();
        out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
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
