package org.atom.datastructure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * @author ssadhukhan
 *
 */
class ChefString {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public ChefString(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        }
        while (!isSpaceChar(c));
        return res.toString();
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }
}

public class ChefStringMain {

    public static void main(String args[]) throws IOException, InterruptedException {
        final ChefString br = new ChefString(System.in);
        final StringBuilder sb = new StringBuilder();
        final Solver solver = new Solver();
        for (int t = br.readInt(); t > 0; t--) {
            final int n = br.readInt(), q = br.readInt();
            final String s = br.readString();
            final long[] results = solver.solve(n, s.toCharArray());
            for (int i = 0; i < q; i++) {
                int k = br.readInt();
                sb.append(results[k <= n ? k : 0]).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}

class Solver {
    private final Multiplier multiplier = new Multiplier();

    public long[] solve(int n, char chars[]) {
        char s[] = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            s[i] = (char) (chars[i] - 'a');
        }
        final Node root = new Node(0);
        long counts[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            Node start = root;
            for (int j = i; j < n; j++) {
                if (start.pointers[s[j]] == null) {
                    start.pointers[s[j]] = new Node(1);
                    counts[1]++;
                } else {
                    counts[start.pointers[s[j]].val]--;
                    start.pointers[s[j]].val++;
                    counts[start.pointers[s[j]].val]++;
                }
                start = start.pointers[s[j]];
            }
        }
        return multiplier.getLongs(n, counts);
    }
}

class Multiplier {
    private static final long MOD = 1000000007;

    public long[] getLongs(int n, long[] counts) {
        //System.out.println(Arrays.toString(counts));
        final long comb[][] = new long[n + 1][n + 1];
        comb[0] = new long[2];
        comb[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = ((comb[i - 1][j - 1] + comb[i - 1][j]) % MOD);
            }
        }
        final long results[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                results[i] = (results[i] + counts[j] * comb[j][i]) % MOD;
            }
        }
        return results;
    }
}

class Node {
    final Node pointers[] = new Node[26];
    int val;

    public Node(int val) {
        this.val = val;
    }
}