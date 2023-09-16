package first;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {
    static int N = 1000010;
    static int n, q[] = new int[N], temp[] = new int[N];

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(st.nextToken());
        }
        merge(q, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", q[i]);
        }
    }
    static void merge(int q[], int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        merge(q, l, mid);
        merge(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] < q[j])
                temp[k++] = q[i++];
            else temp[k++] = q[j++];
        }
        while (i <= mid)
            temp[k++] = q[i++];
        while (j <= r)
            temp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = temp[j];
        }
    }
}