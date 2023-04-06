package UnionFind;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P2814 {

//    P2814 家谱 (AC)
    public static void main(String[] args) throws IOException {
        String a = "";
        UnionFind u = new UnionFind();
        while (true) {
            String s = in.next();
            if (s.charAt(0) == '$') break;
            if (s.charAt(0) == '#') {
                a = s.substring(1);
            } else if (s.charAt(0) == '+') {
                String b = s.substring(1);
                u.union(a, b);
            } else if (s.charAt(0) == '?') {
                String x = s.substring(1);
                out.println(x + " " + u.find(x));
            }
        }
        out.close();
    }

    static class UnionFind {
        HashMap<String, String> fa = new HashMap<>();

        String find(String x) {
            if (!fa.containsKey(x)) {
                fa.put(x, x);
            }
            while (x != null && !x.equals(fa.get(x))) {
                fa.put(x, fa.get(fa.get(x)));
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
