package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        int N = 100010;
        int n, q[] = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        quickSort(q, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", q[i]);
        }
    }

    static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        int x = q[(l + r) / 2];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}
