package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    Map<Integer, Long> memoMap;

    public long fibSequence(int n) {
        memoMap = new HashMap<>();
        return fib(n);
    }

    public long fib(int n) {
        if (memoMap.containsKey(n)) return memoMap.get(n);
        if(n==0) return 0;
        if(n==1) return 1;

        memoMap.put(n, fib(n - 1) + fib(n - 2));

        return memoMap.get(n);
    }

    public void run() {
        System.out.println(fibSequence(6)); // 8
        System.out.println(fibSequence(7)); // 13
        System.out.println(fibSequence(8)); // 21
        System.out.println(fibSequence(50)); // 12586269025
    }
}
