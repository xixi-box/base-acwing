package secend;

import java.io.*;

/**
 * 滑动窗口
 */
public class MonotoneQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int N = 1000010;
        int a[] = new int[N], q[] = new int[N];
        int n, k;
        String[] s = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        String[] s1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {
            //判断队头是否已经滑出了窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            //
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) writer.printf("%d ", a[q[hh]]);

        }
        writer.printf("\n");
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            //判断队头是否已经滑出了窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            //
            while (hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) writer.printf("%d ", a[q[hh]]);

        }
        writer.flush();
    }
}
