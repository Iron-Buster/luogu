package UnionFind;

import java.io.*;
import java.util.StringTokenizer;

public class P1455 {

//    P1455 搭配购买 (AC)

    static int[] c = new int[10010];
    static int[] d = new int[10010];
    static int[] dp = new int[10010];

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int w = in.nextInt();
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
            d[i] = in.nextInt();
        }
        UnionFind uf = new UnionFind(n);
        while (m-- > 0) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (uf.isConnected(u, v)) continue;
            uf.union(u, v);
        }
        // 将同集合的云朵的价钱与价值都划到一个云朵里
        for (int i = 1; i <= n; i++) {
            if (uf.fa[i] != i) {
                d[uf.find(i)] += d[i];
                d[i] = 0;
                c[uf.find(i)] += c[i];
                c[i] = 0;
            }
        }
        // 01背包
        for (int i = 1; i <= n; i++) {
            for (int j = w; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-c[i]] + d[i]);
            }
        }
        out.println(dp[w]);
        out.close();
    }

    static class UnionFind {
        int[] fa;
        public UnionFind(int n) {
            fa = new int[n+1];
            for (int i = 1; i <= n; i++) {
                fa[i] = i;
            }
        }
        int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            fa[b] = a;
        }

        boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
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
