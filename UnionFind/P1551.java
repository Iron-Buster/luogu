package UnionFind;

import java.io.*;
import java.util.StringTokenizer;

public class P1551 {

//    P1551 亲戚(AC)

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        UnionFind u = new UnionFind(n);
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            u.union(a, b);
        }
        while (p-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (u.isConnected(a, b)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
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
