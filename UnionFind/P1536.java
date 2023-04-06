package UnionFind;

import java.io.*;
import java.util.StringTokenizer;

public class P1536 {

//    P1536 村村通 (AC)
    static int[] fa;
    static int count;

    static void init(int n) {
        fa = new int[n+1];
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        count = n;
    }

    static int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        fa[b] = a;
        count--;
    }

    public static void main(String[] args) throws IOException {
        int n;
        while ((n = in.nextInt()) != 0) {
            int m = in.nextInt();
            init(n);
            while (m-- > 0) {
                int a = in.nextInt();
                int b = in.nextInt();
                union(a, b);
            }
            out.println(count-1);
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
