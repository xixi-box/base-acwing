package secend;

import java.util.Scanner;

public class Trie {
    static int N = 100010, idx;
    static int[][] son = new int[N][26];//根节点
    static int[] cnt = new int[N];//以当前点结尾的单词有多少个
    static char[] str = new char[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- != 0) {
            char op = scanner.next().charAt(0);
            str = scanner.next().toCharArray();
            if (op == 'I')
                insert(str);
            else
                System.out.println(query(str));

        }

    }

    public static void insert(char str[]) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            //找到当前字母的子节点编号
            int u = str[i] - 'a';
            if (son[p][u] == 0)
                son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }

    public static int query(char str[]) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0)
                return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
