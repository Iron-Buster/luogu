package DP;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class P1352 {
    // 树形DP模板题
//    P1352 没有上司的舞会
    static int[] h = new int[6001];
    static boolean[] v = new boolean[6001];
    static List<Integer>[] son = new List[6001];
    static int[][] dp = new int[6001][2];

    static void dfs(int x) {
        dp[x][0] = 0;
        dp[x][1] = h[x];
        for (int i = 0; i < son[x].size(); i++) {
            int y = son[x].get(i);
            dfs(y);
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] += dp[y][0];
        }
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        for (int i = 1; i <= n-1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            son[y].add(x);
            v[x] = true;
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                root = i;
                break;
            }
        }
        int ans = Math.max(dp[root][0], dp[root][1]);
        out.println(ans);
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
