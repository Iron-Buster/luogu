package Search;

import java.io.*;
import java.util.StringTokenizer;

public class P1019 {

    //TODO
    static String[] ss = new String[20];

    static void solve(int n) {
        for (int i = 0; i < n; i++) {

        }
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            ss[i] = in.next();
        }
        solve(n);
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
