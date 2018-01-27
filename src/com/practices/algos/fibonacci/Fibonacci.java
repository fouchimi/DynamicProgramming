package com.practices.algos.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int N) {
        if(map.containsKey(N)) return map.get(N);
        if(N <= 0) return 0;
        if(N == 1) return 1;
        map.put(N, fib(N-1) + fib(N-2));
        return map.get(N);
    }

    public int fibOptimized(int N){
        int f[] = new int[N+1];
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i <= N; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[N];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fib(9));
        System.out.println(fib.fibOptimized(9));
    }
}
