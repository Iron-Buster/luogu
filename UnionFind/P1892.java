package UnionFind;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1892 {

//    P1892 [BOI2003]团伙 (AC)

    static List<Integer>[] em = new List[1001];

    static int[] fa;
    static int count;

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
        int n = in.nextInt();
        count = n;
        fa = new int[n+1];
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
            em[i] = new ArrayList<>();
        }
        int m = in.nextInt();
        while (m-- > 0) {
            String opt = in.next();
            int p = in.nextInt();
            int q = in.nextInt();
            if (opt.equals("E")) {
                em[p].add(q);
                em[q].add(p);
                for (int v : em[q]) {
                    union(p, v);
                }
                for (int v : em[p]) {
                    union(q, v);
                }
            } else {
                union(p, q);
            }
        }
        out.println(count);
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
