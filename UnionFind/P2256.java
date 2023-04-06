package UnionFind;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P2256 {

//    P2256 一中校运会之百米跑 (AC)

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = in.next();
        }
        UnionFind u = new UnionFind(n+1, ss);
        while (m-- > 0) {
            String a = in.next();
            String b = in.next();
            u.union(a, b);
        }
        int k = in.nextInt();
        while (k-- > 0) {
            String a = in.next();
            String b = in.next();
            if (u.isConnected(a, b)) {
                out.println("Yes.");
            } else {
                out.println("No.");
            }
        }
        out.close();
    }

    static class UnionFind {
        HashMap<String, String> fa;
        public UnionFind(int n, String[] ss) {
            fa = new HashMap<>(n);
            for (int i = 0; i < ss.length; i++) {
                fa.put(ss[i], ss[i]);
            }
        }
        String find(String x) {
            if (!fa.containsKey(x)) {
                fa.put(x, x);
            }
            while (x != null && !x.equals(fa.get(x))) {
                fa.put(x, fa.get(x));
                x = fa.get(x);
            }
            return x;
        }
        void union(String a, String b) {
            a = find(a);
            b = find(b);
            if (a.equals(b)) return;
            fa.put(b, a);
        }
        boolean isConnected(String a, String b) {
            return find(a).equals(find(b));
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
