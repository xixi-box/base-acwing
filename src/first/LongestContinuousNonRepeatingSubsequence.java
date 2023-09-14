package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestContinuousNonRepeatingSubsequence {
    public static void main(String[] args) throws IOException {
        int N = 100010;
        int n;
        int a[] = new int[N], s[] = new int[N];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s[a[i]]++;
            while (s[a[i]] > 1) {
                s[a[j]]--;//要把现在的j去掉
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
