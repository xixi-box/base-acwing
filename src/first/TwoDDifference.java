package first;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 二维差分
 */
public class TwoDDifference {
    static int N = 1010;
    static int n, m, q;
    static int a[][] = new int[N][N], b[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }
        while (q != 0) {
            q--;
            int x1;
            int y1;
            int x2;
            int y2;
            int c;
            st = new StringTokenizer(bf.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            insert(x1, y1, x2, y2, c);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                writer.write(b[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.flush();
        //必须刷新，关不关闭无所谓
        writer.close();
        bf.close();
    }

    static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
