package DP;

import java.io.*;
import java.util.StringTokenizer;

public class P1049 {

//    P1049 [NOIP2001 普及组] 装箱问题 (AC)

    static int[] w = new int[31];
    static Integer[][] memo = new Integer[31][20001];

    static void solve(int v, int n) {
        int ans = dfs(0, v, n);
        out.println(ans);
    }

    static int dfs(int i, int v, int n) {
        if (v < 0) return 0x3f3f;
        if (i >= n) return v;
        if (memo[i][v] != null) {
            return memo[i][v];
        }
        // 不选第i个
        int a = dfs(i + 1, v, n);
        // 选第i个
        int b = dfs(i + 1, v - w[i], n);
        int ans = Math.min(a, b);
        return memo[i][v] = ans;
    }

    public static void main(String[] args) throws IOException {
        int v = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        solve(v, n);
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
