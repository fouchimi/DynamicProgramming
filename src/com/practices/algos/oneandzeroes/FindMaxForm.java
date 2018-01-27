package com.practices.algos.oneandzeroes;

import java.util.ArrayList;
import java.util.List;

public class FindMaxForm {

    private int max = Integer.MIN_VALUE;

    public int findMaxForm(String[] strs, int m, int n) {
        List<String> list = new ArrayList<>();
        return findMaxFormUtil(strs, m, n, 0, list);
    }

    private int findMaxFormUtil(String[] strs, int m, int n, int index, List<String> list) {
        int length = strs.length;
        for(int i = index; i < length; i++) {
            int k = strs[i].length();
            int M = m, N = n;
            for(int j = 0; j < strs[i].length() && strs[i].length() <= M + N; j++) {
                if(m > 0 && strs[i].charAt(j) == '0') {
                    m--;
                    k--;
                }
                if(n > 0 && strs[i].charAt(j) == '1') {
                    n--;
                    k--;
                }
            }

            if(k == 0) list.add(strs[i]);
            if(m+n == 0) {
                max = Math.max(max, list.size());
                return max;
            }
            if(m+n > 0) findMaxFormUtil(strs, m, n, index+1, list);
            if(!list.isEmpty()) list.remove(list.size()-1);
        }

        return max;
    }

    public static void main(String[] args){

        FindMaxForm obj = new FindMaxForm();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(obj.findMaxForm(strs, 5, 3));

    }
}
