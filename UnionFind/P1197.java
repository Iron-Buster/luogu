package UnionFind;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1197 {


//    P1197 [JSOI2008] 星球大战
    // 逆向思维 求删点后的并查集联通块
    static int N = (int) (4e5 + 4);
    static boolean[] e = new boolean[N];
    static int[] h = new int[N];
    static List<Integer>[] g = new List[N];
    static int count;
    static int[] fa;

    static int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x =  fa[x];
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
        int n = in.nextInt();
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            fa[i] = i;
        }
        int m = in.nextInt();
        while (m-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        int k = in.nextInt();
        count = n - k;
        for (int i = 1; i <= k; i++) {
            int x = in.nextInt();
            e[x] = true;
            h[i] = x;
        }
        for (int i = 0; i < 2*m; i++) {

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
