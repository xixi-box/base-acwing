package first;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 区间和
 */
public class DiscreteSum {
    public static void main(String[] args) {
        int N = 300010;//要用到的下标数量
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] a = new int[N];//存离散化后的值
        int[] s = new int[N];//存前缀和
        List<Integer> alls = new ArrayList<>();//存所有的下标
        List<Pair> add = new ArrayList<>();//存n次操作
        List<Pair> query = new ArrayList<>();//存m次询问
        //输入n个数，每次存进add，下标存入alls
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
            add.add(new Pair(x, c));
            alls.add(x);
        }
        //输入m次询问
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            query.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }
//        Collections.sort(alls);//排序
//        int unique = unique(alls);
//        alls = alls.subList(0, unique);
        alls = alls.stream().distinct().sorted().collect(Collectors.toList());
        //找到离散化的下标值 找到x的值在a中的下标是多少
        for (Pair item : add) {
            int index = find(item.first, alls);
            a[index] += item.second;
        }
        for (int i = 1; i <= alls.size(); i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (Pair item : query) {
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            System.out.println(s[r] - s[l - 1]);
        }

    }

    //去重（只要符合是第一个数或者后面一个数不等于前面一个数就是不重复的数）
    public static int unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i <= list.size() - 1; i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i)); //将不重复之后的数一个一个重新存入list中。
                j++;
            }
        }
        return j;
    }

    public static int find(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return l + 1;
    }
}

//这是一个Pair类，用来存操作的类
class Pair {
    int first;
    int second;

    public Pair(int x, int c) {
        this.first = x;
        this.second = c;
    }
}