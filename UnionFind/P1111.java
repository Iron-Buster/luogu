package UnionFind;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1111 {


//    P1111 修复公路 (AC)
    static int[][] a = new int[100010][3];

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int t = in.nextInt();
            a[i] = new int[]{x, y, t};
        }
        Arrays.sort(a, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for (int[] g : a) {
            if (u.count == 1) break;
            int a = g[0], b = g[1], t = g[2];
            if (u.isConnected(a, b)) continue;
            u.union(a, b);
            ans = t;
        }
        if (u.count != 1) {
            out.println(-1);
        } else {
            out.println(ans);
        }
        out.close();
    }

    static class UnionFind {
        int[] fa;
        int count;
        public UnionFind(int n) {
            fa = new int[n+1];
            for (int i = 1; i <= n; i++) {
                fa[i] = i;
            }
            count = n;
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
            count--;
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
