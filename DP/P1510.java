package DP;

import java.io.*;
import java.util.StringTokenizer;

public class P1510 {

//    P1510 精卫填海
    static int INF = -0x3f3f3f;
    static int[] W = new int[10001]; // 体力
    static int[] V = new int[10001]; // 体积
    static int[] dp = new int[10001];
//    static int[][] arr = new int[10001][2];
//    static Integer[][] memo;

    static void solve(int v, int n, int c) {
        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= W[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        for (int i = 0; i <= v; i++) {
            if (dp[i] >= v) {
                out.println(c - i);
                return;
            }
        }
        out.println("Impossible");
    }

    // 数据太强大, 记忆化DFS爆栈
//    static int dfs(int i, int v, int n, int c) {
//        if (c < 0) return INF;
//        if (v <= 0) return c;
//        if (i >= n) return INF;
//        if (memo[i][v] != null) {
//            return memo[i][v];
//        }
//        // 不选择第i块石头
//        int a = dfs(i + 1, v, n, c);
//        // 选择第i块石头
//        int b = dfs(i + 1, v - arr[i][0], n, c - arr[i][1]);
//        int ans = Math.max(a, b);
//        return memo[i][v] = ans;
//    }

    public static void main(String[] args) throws IOException {
        int v = in.nextInt(); // 体积
        int n = in.nextInt(); // n块石头
        int c = in.nextInt(); // 体力
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            V[i] = x;
            W[i] = y;
//            arr[i] = new int[]{x, y};
            sum += x;
        }
        if (sum < v) {
            out.println("Impossible");
        } else {
            solve(v, n, c);
        }
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
