package first;

import java.util.*;

public class IntervalMerging {
    public static void main(String[] args) {
        int n, l, r;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        List<Pair2> alls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            alls.add(new Pair2(l, r));
        }
        Collections.sort(alls);
       int res= merge(alls);
        System.out.println(res);
    }

    public static int merge(List<Pair2> alls) {
        List<Pair2> res = new ArrayList<>();
        int MAX = (int) -2e9;
        int st = MAX, end = MAX;
        for (Pair2 pair : alls)
            //找到一个新区间
            if (end < pair.first) {
                //判断 避免是
                if (st != MAX)
                    res.add(new Pair2(st, end));
                st = pair.first;
                end = pair.second;
            } else end = Math.max(pair.second, end);
        if (st != MAX)
            res.add(new Pair2(st, end));
        return res.size();
    }
}

//这是一个Pair类，用来存操作的类
class Pair2 implements Comparable<Pair2> {
    int first;
    int second;

    public Pair2(int x, int c) {
        this.first = x;
        this.second = c;
    }

    @Override
    public int compareTo(Pair2 o) {
        return this.first - o.first;
    }
}